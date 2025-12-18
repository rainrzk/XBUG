<template>
  <div class="navbar">
    <hamburger
      id="hamburger-container"
      :is-active="sidebar.opened"
      class="hamburger-container"
      @toggleClick="toggleSideBar"
    />

    <breadcrumb
      id="breadcrumb-container"
      class="breadcrumb-container"
      v-if="!topNav"
    />
    <top-nav id="topmenu-container" class="topmenu-container" v-if="topNav" />

    <div class="right-menu">
      <template v-if="device !== 'mobile'">
        <!-- <el-tooltip
          :content="$t('source-code-address')"
          effect="dark"
          placement="bottom"
        >
          <x-bug-git id="xbug-git" class="right-menu-item hover-effect" />
        </el-tooltip> -->

        <!--
        <el-tooltip :content="$t('doc-address')" effect="dark" placement="bottom">
          <x-bug-doc id="xbug-doc" class="right-menu-item hover-effect" />
        </el-tooltip>
        -->

        <screenfull id="screenfull" class="right-menu-item hover-effect" />
      </template>

      <el-dropdown
        class="avatar-container right-menu-item hover-effect"
        trigger="click"
      >
        <div class="avatar-wrapper">
          <x-bug-avatar :member="member" />
          <!-- <i class="el-icon-caret-bottom" /> -->
        </div>
        <el-dropdown-menu slot="dropdown">
          <router-link to="/member/profile">
            <el-dropdown-item>{{ $t('my-center') }}</el-dropdown-item>
          </router-link>
          <el-dropdown-item divided @click.native="logout">
            <span>{{ $t('logout') }}</span>
          </el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';
import Breadcrumb from '@/components/Breadcrumb';
import TopNav from '@/components/TopNav';
import Hamburger from '@/components/Hamburger';
import Screenfull from '@/components/Screenfull';
import SizeSelect from '@/components/SizeSelect';
import Search from '@/components/HeaderSearch';
import XBugGit from '@/components/XBug/Git';
import XBugDoc from '@/components/XBug/Doc';
import XBugAvatar from '@/components/XBugAvatar';

export default {
  components: {
    Breadcrumb,
    TopNav,
    Hamburger,
    Screenfull,
    SizeSelect,
    Search,
    XBugGit,
    XBugDoc,
    XBugAvatar,
  },
  computed: {
    ...mapGetters(['sidebar', 'avatar', 'device', 'name']),
    member: {
      get() {
        return {
          avatar: this.avatar,
          name: this.name,
        };
      },
    },
    setting: {
      get() {
        return this.$store.state.settings.showSettings;
      },
      set(val) {
        this.$store.dispatch('settings/changeSetting', {
          key: 'showSettings',
          value: val,
        });
      },
    },
    topNav: {
      get() {
        return this.$store.state.settings.topNav;
      },
    },
  },
  methods: {
    toggleSideBar() {
      this.$store.dispatch('app/toggleSideBar');
    },
    async logout() {
      this.$confirm(
        this.$i18n.t('sure-logout-system').toString(),
        this.$i18n.t('prompted').toString(),
        {
          confirmButtonText: this.$i18n.t('ok'),
          cancelButtonText: this.$i18n.t('cancel'),
          type: 'warning',
        }
      )
        .then(() => {
          this.$store.dispatch('LogOut').then(() => {
            location.href = '/index';
          });
        })
        .catch(() => {});
    },
  },
};
</script>

<style lang="scss" scoped>
/* 定义颜色变量 */
$background-color: #1e1e1e; // 深色背景
$text-color: #ffffff; // 白色文字
$secondary-text-color: rgba(255, 255, 255, 0.7); // 次要文字颜色
$hover-background: darken($background-color, 5%); // 悬停时的背景色
$accent-color: #9b59b6; // 紫色强调色
$border-color: #3c3c3c; // 边框颜色
$box-shadow-color: rgba(0, 0, 0, 0.5); // 盒阴影颜色

.navbar {
  height: 50px;
  overflow: hidden;
  position: relative;
  background-color: $background-color;
  box-shadow: 0 1px 4px $box-shadow-color;

  .hamburger-container {
    line-height: 46px;
    height: 100%;
    float: left;
    cursor: pointer;
    transition: background 0.3s;
    -webkit-tap-highlight-color: transparent;

    &:hover {
      background-color: $hover-background;
    }
  }

  .breadcrumb-container {
    float: left;
    color: $text-color;
  }

  .topmenu-container {
    position: absolute;
    left: 50px;
    color: $text-color;
  }

  .errLog-container {
    display: inline-block;
    vertical-align: top;
  }

  .right-menu {
    float: right;
    height: 100%;
    line-height: 50px;

    &:focus {
      outline: none;
    }

    .right-menu-item {
      display: inline-block;
      padding: 0 8px;
      height: 100%;
      font-size: 18px;
      color: $text-color;
      vertical-align: text-bottom;

      &.hover-effect {
        cursor: pointer;
        transition: background 0.3s;

        &:hover {
          background-color: $hover-background;
        }
      }
    }

    .avatar-container {
      margin-right: 5px;

      .avatar-wrapper {
        margin-top: 7px;

        .el-icon-caret-bottom {
          cursor: pointer;
          position: absolute;
          right: -20px;
          top: 25px;
          font-size: 12px;
          color: $text-color;
        }
      }
    }
  }

  /* Tooltip 样式调整 */
  ::v-deep .el-tooltip__popper {
    background-color: $background-color;
    color: $text-color;
    border: 1px solid $border-color;
    box-shadow: 0 2px 12px $box-shadow-color;
  }

  /* Dropdown 菜单样式调整 */
  ::v-deep .el-dropdown-menu {
    background-color: $background-color;
    color: $text-color;
    border: 1px solid $border-color;

    .el-dropdown-item {
      &:hover {
        background-color: $hover-background;
      }

      &.el-dropdown-item--divided {
        border-top: 1px solid $border-color;
      }
    }
  }
}
</style>
