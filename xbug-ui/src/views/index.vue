<template>
  <div class="app-container home">
    <el-row :gutter="20">
      <el-col :sm="24" :lg="12" style="padding-left: 20px">
        <h2>{{$t('system-name')}}</h2>
        <p>{{$t('system-introduce')}}</p>
        <p>
          <b>{{ $t('version') }}:</b> <span>LTS</span>
        </p>
        <p>
          <el-button
            type="primary"
            size="mini"
            icon="el-icon-cloudy"
            plain
            @click="goTarget('https://github.com/y_project/RuoYi-Vue')"
          >{{$t('visit-github')}}</el-button>
          <el-button
            type="primary"
            size="mini"
            icon="el-icon-cloudy"
            plain
            @click="goTarget('https://gitee.com/y_project/RuoYi-Vue')"
            >{{$t('visit-gitee')}}</el-button
          >
          <el-button
            size="mini"
            icon="el-icon-s-home"
            plain
            @click="goTarget('https://gitee.com/y_project/RuoYi-Vue')"
            >{{$t('visit-homepage')}}</el-button
          >
        </p>
      </el-col>

      <el-col :sm="24" :lg="12" style="padding-left: 50px">
        <el-row>
          <el-col :span="12">
            <h2>{{$t('technical-selection')}}</h2>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="6">
            <h4>{{$t('back-end-technology')}}</h4>
            <ul>
              <li>SpringBoot</li>
              <li>Spring Security</li>
              <li>JWT</li>
              <li>MyBatis</li>
              <li>Druid</li>
              <li>Fastjson</li>
              <li>...</li>
            </ul>
          </el-col>
          <el-col :span="6">
            <h4>{{$t('front-end-technology')}}</h4>
            <ul>
              <li>Vue</li>
              <li>Vuex</li>
              <li>Element-ui</li>
              <li>Axios</li>
              <li>Sass</li>
              <li>Quill</li>
              <li>...</li>
            </ul>
          </el-col>
        </el-row>
      </el-col>
    </el-row>
    <el-divider />
    <el-row :gutter="20">
      <el-col :xs="24" :sm="24" :md="12" :lg="8">
        <el-card class="update-log">
          <div slot="header" class="clearfix">
            <span>{{$t('contact-information')}}</span>
          </div>
          <div class="body">
            <p>
              <i class="el-icon-user-solid"></i> {{$t('qq-group')}}：
              <a target="_blank" href="http://qm.qq.com/cgi-bin/qm/qr?_wv=1027&k=YyNIVXa3189arDqaDAVsbtyDLzryTxM_&authKey=a6CZ9Xy1l%2BrF%2F%2FVIO32m9TxkNzi6zfPGyiJVTMGSEDKy6fvuPN%2Fe%2BWo25eWiI1ap&noverify=0&group_code=386408487">386408487</a>
            </p>
            <p>
              <i class="el-icon-s-promotion"></i> {{$t('website')}}：
              <a target="_blank" href="http://chat.teloivts.xyz">https://chat.teloivts.xyz</a>
              
              <!-- <el-link
                href="http://chat.teloivts.xyz"
                target="_blank"
                >https://chat.teloivts.xyz</el-link
              > -->
            </p>
          </div>
        </el-card>
      </el-col>
      <el-col :xs="24" :sm="24" :md="12" :lg="8">
        <el-card class="update-log">
          <div slot="header" class="clearfix">
            <span>{{$t('update-log')}}</span>
          </div>
          <el-collapse accordion>
            <el-collapse-item title="LTS - 2024-10-07">
              <ol>
                <li>X-Bug正式发布</li>
              </ol>
            </el-collapse-item>
          </el-collapse>
        </el-card>
      </el-col>
      <el-col :xs="24" :sm="24" :md="12" :lg="8">
        <el-card class="update-log">
          <div slot="header" class="clearfix">
            <span>{{$t('document')}}</span>
          </div>
          <el-collapse accordion>
            <el-collapse-item :title="$t('system-introduction')">
              <ol>
                <li>{{$t('system-introduction')}}</li>
                <li>{{$t('install')}}</li>
              </ol>
            </el-collapse-item>
            <el-collapse-item :title="$t('function-usage')">
              <ol>
                <li>{{ $t('member.manage') }}</li>
                <li>{{ $t('project.manage') }}</li>
                <li>{{ $t('defect.manage') }}</li>
              </ol>
            </el-collapse-item>
            <el-collapse-item :title="$t('api-description')">
              <ol>
                <li>{{ $t('account') }}</li>
                <li>{{ $t('defect.submission') }}</li>
                <li>{{ $t('defect.statistics') }}</li>
              </ol>
            </el-collapse-item>
          </el-collapse>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  name: "Index",
  data() {
    return {
      // 版本号
      version: "0.0.1"
    };
  },
  methods: {
    goTarget(href) {
      window.open(href, "_blank");
    }
  }
};
</script>

<style scoped lang="scss">
/* 定义颜色变量 */
$background-color: #1E1E1E; // Mac 深色模式的背景颜色
$text-color: #FFFFFF; // 白色文字
$secondary-text-color: rgba(255, 255, 255, 0.7); // 次要文字颜色
$border-color: #3C3C3C; // 深色边框
$card-background-color: #2C2C2E; // 卡片背景颜色
$scrollbar-bg-color: rgba(255, 255, 255, 0.1);
$scrollbar-thumb-color: rgba(255, 255, 255, 0.3);
$button-color: #9b59b6; // 按钮紫色
$button-hover-color: darken($button-color, 10%); // 按钮悬停颜色

.home {
  background-color: $background-color;
  color: $text-color;
  font-family: -apple-system, BlinkMacSystemFont, "Helvetica Neue", Helvetica, Arial, sans-serif;
  font-size: 13px;
  overflow-x: hidden;

  /* 滚动条样式 */
  ::-webkit-scrollbar {
    width: 8px;
    background-color: transparent;
  }

  ::-webkit-scrollbar-thumb {
    background-color: $scrollbar-thumb-color;
    border-radius: 4px;
  }

  ::-webkit-scrollbar-thumb:hover {
    background-color: lighten($scrollbar-thumb-color, 10%);
  }

  blockquote {
    padding: 10px 20px;
    margin: 0 0 20px;
    font-size: 17.5px;
    border-left: 5px solid $border-color;
    background-color: darken($background-color, 5%);
    color: $secondary-text-color;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.5);
  }

  hr {
    margin-top: 20px;
    margin-bottom: 20px;
    border: 0;
    border-top: 1px solid $border-color;
  }

  .col-item {
    margin-bottom: 20px;
  }

  ul {
    padding: 0;
    margin: 0;
    list-style-type: none;

    li {
      margin-bottom: 10px;
      color: $text-color;
    }
  }

  h2,
  h4 {
    margin-top: 20px;
    color: $text-color;
  }

  h2 {
    font-size: 26px;
    font-weight: 500;
  }

  h4 {
    margin-top: 0;
  }

  p {
    margin-top: 20px;
    color: $text-color;

    b {
      font-weight: 700;
    }
  }

  .update-log {
    background-color: $card-background-color;
    color: $text-color;

    .el-card__header {
      background-color: $card-background-color;
      color: $text-color;
    }

    ol {
      margin: 0;
      padding: 0 0 0 20px;
      list-style-type: decimal;
      color: $text-color;
    }
  }

  a {
    color: $text-color;
    text-decoration: none;

    &:hover {
      text-decoration: none; // 移除下划线
    }
  }

  .el-collapse-item__header {
    background-color: $card-background-color;
    color: $text-color;
  }

  .el-collapse-item__content {
    background-color: $card-background-color; // 设置内容区域为暗色
    color: $text-color;
  }

  .el-link {
    color: $text-color;

    &:hover {
      color: $text-color;
      text-decoration: none; // 移除下划线
    }
  }

  /* 按钮样式调整 */
  .el-button--primary {
    background-color: $button-color;
    border-color: $button-color;
    color: #fff;

    &:hover {
      background-color: $button-hover-color;
      border-color: $button-hover-color;
    }
  }

  /* 响应式字体大小 */
  @media screen and (max-width: 768px) {
    font-size: 12px;

    h2 {
      font-size: 22px;
    }
  }
}
</style>
