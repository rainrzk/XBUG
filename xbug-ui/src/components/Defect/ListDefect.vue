<!-- ListDefect.vue -->
<template>
  <xbug-drawer
    :title="$i18n.t('defect.manage').toString()"
    ref="xbugDrawer"
  >
    <template slot="content">
      <el-table
        v-loading="loading"
        :data="defectList"
        @sort-change="sortChangeHandle"
        @row-click="editDefectHandle"
      >
        <!-- 其他列 -->

        <el-table-column :label="$t('关联')" align="left" prop="relatedDefectName">
          <template slot-scope="scope">
            <el-link
              type="primary"
              @click.stop="openRelatedDefect(scope.row.relatedDefectId)"
            >
              {{ scope.row.relatedDefectName }}
            </el-link>
          </template>
        </el-table-column>

        <!-- 其他列 -->
      </el-table>

      <pagination
        v-show="total > 0"
        :total="total"
        :page.sync="queryParams.pageNum"
        :limit.sync="queryParams.pageSize"
        @pagination="getList"
      />

      <!-- 引入 HandleDefect 组件，并监听相关事件 -->
      <handle-defect
        ref="handleDefectDrawer"
        @added="handleDefectAdded"
        @delete="handleDefectDeleted"
        @openRelatedDefect="openRelatedDefect"
      />
    </template>
  </xbug-drawer>
</template>

<script>
import HandleDefect from "@/components/Defect/HandleDefect"; // 确保路径正确
import XbugDrawer from "@/components/XbugDrawer";
import { listDefect, configDefect } from "@/api/system/defect";
import RowListMember from "@/components/RowListMember";
import LevelTag from "@/components/LevelTag";
import DefectTools from "@/components/DefectTools";
// 其他导入...

export default {
  name: "ListDefect",
  components: {
    XbugDrawer,
    RowListMember,
    LevelTag,
    DefectTools,
    HandleDefect, // 注册 HandleDefect 组件
    // 其他组件...
  },
  data() {
    return {
      loading: true,
      total: 0,
      defectList: [],
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        orderByColumn: 'createTime',
        isAsc: 'desc',
        defectType: null,
        defectName: null,
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
        handleBy: null,
        handleTime: null,
        defectLevel: null
      },
      // 其他数据属性...
    };
  },
  computed: {
    getUrl() {
      return function (urls) {
        let imgs = urls ? urls.split(',') : [];
        return imgs.map(i => process.env.VUE_APP_BASE_API + i);
      };
    },
    // 其他计算属性...
  },
  mounted() {
  this.$nextTick(() => {
    if (this.$refs.handleDefectDrawer) {
      console.log('mounted 时 handleDefectDrawer 存在:', this.$refs.handleDefectDrawer);
    } else {
      console.error('mounted 时 handleDefectDrawer 不存在');
    }
  });
},
  methods: {
    open() {
      this.$refs.xbugDrawer.open();
      this.getDefectConfig();
      this.getList();
    },
    getDefectConfig() {
      configDefect().then(res => {
        this.config = res.data;
      }).catch(error => {
        console.error('获取缺陷配置失败:', error);
        this.$message.error("无法获取缺陷配置");
      });
    },
    getProjectId() {
      return parseInt(this.$store.state.user.config.currentProjectId);
    },
    sortChangeHandle(e) {
      if (e.order) {
        switch (e.prop) {
          case 'defectStateName':
            this.queryParams.orderByColumn = 'defectState';
            break;
          case 'defectTypeName':
            this.queryParams.orderByColumn = 'defectType';
            break;
          default:
            this.queryParams.orderByColumn = e.prop;
            break;
        }
        this.queryParams.isAsc = e.order === 'ascending' ? "asc" : 'desc';
      } else {
        this.queryParams.orderByColumn = null;
        this.queryParams.isAsc = null;
      }
      this.getList();
    },
    getList(params) {
      this.loading = true;
      this.queryParams.params = params || {};

      if (this.daterangeUpdateTime && this.daterangeUpdateTime.length > 0) {
        this.queryParams.params["beginUpdateTime"] = this.daterangeUpdateTime[0];
        this.queryParams.params["endUpdateTime"] = this.daterangeUpdateTime[1];
      }
      if (this.daterangeCreateTime && this.daterangeCreateTime.length > 0) {
        this.queryParams.params["beginCreateTime"] = this.daterangeCreateTime[0];
        this.queryParams.params["endCreateTime"] = this.daterangeCreateTime[1];
      }
      if (this.daterangeHandleTime && this.daterangeHandleTime.length > 0) {
        this.queryParams.params["beginHandleTime"] = this.daterangeHandleTime[0];
        this.queryParams.params["endHandleTime"] = this.daterangeHandleTime[1];
      }

      this.queryParams.projectId = this.getProjectId();
      listDefect(this.queryParams).then(response => {
        this.defectList = response.rows;
        this.total = response.total;
        this.loading = false;
      }).catch(error => {
        console.error('获取缺陷列表失败:', error);
        this.$message.error("无法获取缺陷列表");
        this.loading = false;
      });
    },
    editDefectHandle(defect) {
      console.log('编辑缺陷:', defect.defectId); // 调试日志
      this.$refs.handleDefectDrawer.open(defect.defectId);
    },
    clickImageHandle(event) {
      event.stopPropagation();
    },
    /** 处理点击关联缺陷名称 */
    openRelatedDefect(defectId) {
  console.log('点击关联缺陷ID:', defectId); // 调试日志
  if (!defectId) {
    this.$message.warning("无效的关联缺陷ID");
    return;
  }

  // 检查 handleDefectDrawer 是否存在
  if (this.$refs.handleDefectDrawer) {
    console.log('handleDefectDrawer 存在:', this.$refs.handleDefectDrawer);

    // 验证是否存在 close 方法
    if (typeof this.$refs.handleDefectDrawer.close === 'function') {
      console.log('调用 close 方法');
      this.$refs.handleDefectDrawer.close()
        .then(() => {
          console.log('close() 成功执行');
          this.$nextTick(() => {
            console.log('尝试打开新抽屉');
            this.$refs.handleDefectDrawer.open(defectId);
          });
        })
        .catch((error) => {
          console.error('关闭抽屉时出现错误:', error);
        });
    } else {
      console.error('handleDefectDrawer.close 方法不存在或无效');
      this.$message.error("无法调用 HandleDefect 的 close 方法");
    }
  } else {
    console.error('handleDefectDrawer 未找到');
    this.$message.error("无法找到 HandleDefect 组件");
  }
},
    handleDefectAdded(res) {
      this.getList(); // 重新获取缺陷列表
    },
    handleDefectDeleted(res) {
      this.getList(); // 重新获取缺陷列表
    },
    // 其他方法...
  }
};
</script>

<style scoped>
/* 您的样式 */
</style>
