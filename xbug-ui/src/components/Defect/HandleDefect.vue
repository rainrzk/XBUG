<!-- HandleDefect.vue -->
<template>
  <el-drawer
    size="45%"
    :visible.sync="visible"
    direction="rtl"
    :before-close="closeDefectDrawer"
  >
    <template slot="title">
      <div class="defect-edit-header">
        <div class="defect-edit-title">
          <i class="el-icon-arrow-left" @click="cancel"></i>
          <h4 class="defect-edit-title-num">#{{ defect.projectNum }}</h4>
          <h4 class="defect-edit-title-name">{{ defect.defectName }}</h4>
        </div>
        <div>
          <defect-tools
            :defect="defect"
            size="mini"
            @delete="deleteHandle"
            @log="logHandle"
          ></defect-tools>
        </div>
      </div>
    </template>
    <div class="app-container defect-edit-body">
      <el-collapse v-model="activeNames">
        <el-collapse-item :title="$i18n.t('describe')" name="defectDescribe">
          <div>{{ defect.defectDescribe }}</div>
        </el-collapse-item>

        <el-collapse-item :title="$i18n.t('defect.base-info')" name="base">
          <el-row class="defect-edit-body-base" :gutter="20">
            <el-col :span="12">
              <label>{{$t('project')}}:</label>
              <span>{{ defect.projectName }}</span>
            </el-col>
            <el-col :span="12">
              <label>{{$t('module')}}:</label>
              <span>{{ defect.moduleName }}</span>
            </el-col>
            <el-col :span="12">
              <label>{{$t('version')}}:</label>
              <span>{{ defect.moduleVersion }}</span>
            </el-col>
            <el-col :span="12">
              <label>{{ '关联' }}:</label>
              <span>
                <el-link
                  type="primary"
                  v-if="defect.relatedDefectId"
                  @click="openRelatedDefect(defect.relatedDefectId)"
                >
                  {{ defect.relatedDefectName }}
                </el-link>
                <span v-else>-</span>
              </span>
            </el-col>
            <el-col :span="12">
              <label>{{$t('state')}}:</label>
              <span>{{ getDefectStateName(defect.defectState) }}</span>
            </el-col>
          </el-row>
        </el-collapse-item>

        <el-collapse-item :title="$i18n.t('image')" name="imgUrls">
          <el-image
            v-for="(img, index) in getUrl(defect.imgUrls)"
            :key="index"
            style="width: 100px; height: 100px"
            :src="img"
            :preview-src-list="getUrl(defect.imgUrls)"
            fit="contain"
          ></el-image>
        </el-collapse-item>

        <el-collapse-item :title="$i18n.t('annex')" name="annexUrls">
          <div class="defect-edit-body-annex">
            <el-link
              type="primary"
              v-for="(file, index) in getUrl(defect.annexUrls)"
              :key="index"
              :href="file"
              target="_blank"
            >
              {{ getFileName(file) }}
            </el-link>
          </div>
        </el-collapse-item>
      </el-collapse>
      <div slot="footer" class="dialog-footer"></div>
    </div>
  </el-drawer>
</template>

<script>
import { addDefect, getDefect, updateDefect } from "@/api/system/defect";
import DefectTools from "@/components/DefectTools";

export default {
  name: "HandleDefect",
  components: { DefectTools },
  data() {
    return {
      defectId: null,
      activeNames: [],
      visible: false,
      defect: {},
      form: {
        defectLevel: 'middle'
      },
      rules: {
        defectType: [
          { required: true, message: this.$i18n.t('defect.defect-type-cannot-empty'), trigger: "change" }
        ],
        handleBy: [
          { required: true, message: this.$i18n.t('defect.handle-by-cannot-empty'), trigger: "input" }
        ],
        defectName: [
          { required: true, message: this.$i18n.t('defect.defect-name-cannot-empty'), trigger: "input" }
        ],
        defectLevel: [
          { required: true, message: this.$i18n.t('defect.defect-level-cannot-empty'), trigger: "input" }
        ],
        defectDescribe: [
          { required: true, message: this.$i18n.t('defect.describe-cannot-empty'), trigger: "input" }
        ],
      }
    };
  },
  props: {
    projectId: {
      type: Number,
      default: null
    },
  },
  computed: {
    getUrl() {
      return function (urls) {
        let imgs = urls ? urls.split(',') : [];
        return imgs.map(i => process.env.VUE_APP_BASE_API + i);
      };
    },
    getFileName() {
      return function (url) {
        if (!url) return null;
        let arr = url.split('/');
        return arr[arr.length - 1];
      };
    }
  },
  methods: {
    // 打开抽屉并加载缺陷信息
    open(defectId) {
      console.log('调用 open 方法，缺陷ID:', defectId); // 调试日志
      if (this.defectId === defectId && this.visible) {
        console.log('当前缺陷已打开:', defectId);
        return;
      }
      this.reset();
      this.defectId = defectId;
      this.getDefectInfo(defectId);
      this.visible = true;
    },
    // 关闭抽屉方法，返回 Promise
    close() {
      return new Promise((resolve) => {
        this.visible = false;
        // 使用 Vue 的 nextTick 确保抽屉关闭后执行 resolve
        this.$nextTick(() => {
          resolve();
        });
      });
    },
    // 获取缺陷信息
    getDefectInfo(defectId) {
      console.log('加载缺陷ID:', defectId); // 调试日志
      this.activeNames = ['base', 'log'];
      getDefect(defectId).then(res => {
        this.defect = res.data;
        console.log('加载到的缺陷信息:', this.defect); // 调试日志
        if (this.defect.defectDescribe) {
          this.activeNames.push('defectDescribe');
        }
        if (this.defect.imgUrls && this.defect.imgUrls.length > 0) {
          this.activeNames.push('imgUrls');
        }
        if (this.defect.annexUrls && this.defect.annexUrls.length > 0) {
          this.activeNames.push('annexUrls');
        }
      }).catch(error => {
        console.error('获取缺陷信息失败:', error);
        this.$message.error("无法获取缺陷信息");
      });
    },
    // 取消按钮
    cancel() {
      this.visible = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        defectId: null,
        defectType: null,
        defectName: null,
        defectDescribe: null,
        annexUrls: null,
        projectId: null,
        testPlanId: null,
        caseId: null,
        dataSources: null,
        dataSourcesParams: null,
        moduleId: null,
        moduleVersion: null,
        createBy: null,
        updateTime: null,
        createTime: null,
        updateBy: null,
        defectState: null,
        caseStepId: null,
        handleBy: null,
        handleTime: null,
        defectLevel: 'middle',
      };
      this.activeNames = ['base', 'log'];
      // 如果有表单引用，重置表单
      if (this.$refs.form) {
        this.$refs.form.resetFields();
      }
    },
    // 提交按钮
    submitForm() {
      if (this.$refs.form) {
        this.$refs.form.validate(valid => {
          if (valid) {
            this.form.projectId = this.projectId;
            if (this.form.defectId != null) {
              updateDefect(this.form).then(res => {
                this.$modal.msgSuccess("修改成功");
                this.visible = false;
                this.$emit('added', res);
              }).catch(error => {
                console.error('更新缺陷失败:', error);
                this.$message.error("修改失败");
              });
            } else {
              addDefect(this.form).then(res => {
                this.$modal.msgSuccess("新增成功");
                this.visible = false;
                this.$emit('added', res);
              }).catch(error => {
                console.error('新增缺陷失败:', error);
                this.$message.error("新增失败");
              });
            }
          }
        });
      }
    },
    // 关闭抽屉
    closeDefectDrawer(done) {
      done();
    },
    // 处理关联缺陷点击事件
    openRelatedDefect(defectId) {
        console.log('在 HandleDefect 中点击关联缺陷ID:', defectId); // 调试日志
        if (!defectId) {
            this.$message.warning("无效的关联缺陷ID");
            return;
        }
        
        // 使用 getDefect 方法获取缺陷信息
        getDefect(defectId).then(res => {
            this.defect = res.data; // 假设返回的数据结构中包含 defect 信息
            this.visible = true; // 打开抽屉
            console.log('加载到的关联缺陷信息:', this.defect); // 调试日志
        }).catch(error => {
            console.error('获取关联缺陷信息失败:', error);
            this.$message.error("无法获取关联缺陷信息");
        });
    },
    // 处理日志事件
    logHandle(log) {
      this.open(this.defectId);
      // 如果有日志组件，可以在这里调用
    },
    // 处理删除事件
    deleteHandle() {
      this.$emit('delete', this.defect);
      this.cancel();
    },
    // 获取缺陷状态名称
    getDefectStateName(defectState) {
      const stateMap = {
        0: this.$t('PROCESSING'), // 待处理
        1: this.$t('AUDIT'),      // 待审核
        2: this.$t('RESOLVED'),   // 已解决
        3: this.$t('REJECTED'),   // 已驳回
        4: this.$t('CLOSED')      // 已关闭
      };
      return stateMap[defectState] || this.$t('UNKNOWN_STATE');
    },
    // 获取缺陷类型名称
    getDefectTypeName(defectState) {
      const stateMap = {
        0: this.$t('BUG'), // 缺陷
        1: this.$t('TASK'), // 用例
        2: this.$t('DEMAND'), // 需求
      };
      return stateMap[defectState] || this.$t('UNKNOWN_TYPE');
    },
  }
};
</script>

<style lang="scss" scoped>
::v-deep .el-drawer__header {
  margin-bottom: 0px;
}
.defect-edit-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  flex-direction: row;
  .defect-edit-title {
    display: inline-flex;
    justify-content: flex-start;
    align-items: center;
    flex-direction: row;
    .el-icon-arrow-left {
      font-size: 22px;
    }
    .el-icon-arrow-left:hover {
      cursor: pointer;
      color: #909399;
    }
    .defect-edit-title-name {
      max-width: 400px;
      overflow: hidden;
      white-space: nowrap;
      text-overflow: ellipsis;
    }
    .defect-edit-title-num, .defect-edit-title-name {
      font-size: 20px;
      color: #ffffff;
      font-weight: 500;
      margin-top: 10px;
      margin-bottom: 10px;
    }
    > * {
      margin-right: 10px;
    }
  }
}
.defect-edit-body {
  padding-left: 30px;
  padding-right: 30px;
  .defect-edit-body-annex {
    display: flex;
    flex-direction: column;
    justify-content: flex-start;
    align-items: flex-start;
  }
  ::v-deep .el-collapse {
    .el-collapse-item__header {
      font-size: 16px;
    }
    border-width: 0px;
    .el-collapse-item:last-child {
      .el-collapse-item__wrap {
        border-width: 0px;
      }
    }
  }
  h5 {
    font-size: 18px;
    color: #ffffff;
    margin: 10px 0px;
  }
  .defect-edit-body-base {
    .el-col {
      margin-bottom: 20px;
      label {
        font-size: 14px;
        color: #ffffff;
        width: 80px;
        display: inline-block;
        justify-content: flex-start;
        margin-right: 10px;
        text-align: right;
      }
    }
  }
  .defect-edit-body-annex {
    display: flex;
    flex-direction: column;
    justify-content: flex-start;
    align-items: flex-start;
  }
}
::v-deep .el-drawer__close-btn {
  display: none;
}
</style>