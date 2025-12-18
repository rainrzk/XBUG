<template>
  <div :class="{'hidden': hidden}" class="pagination-container">
    <el-pagination
      :background="background"
      :current-page.sync="currentPage"
      :page-size.sync="pageSize"
      :layout="layout"
      :page-sizes="pageSizes"
      :pager-count="pagerCount"
      :total="total"
      v-bind="$attrs"
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
    />
  </div>
</template>

<script>
import { scrollTo } from '@/utils/scroll-to'

export default {
  name: 'Pagination',
  props: {
    total: {
      required: true,
      type: Number
    },
    page: {
      type: Number,
      default: 1
    },
    limit: {
      type: Number,
      default: 20
    },
    pageSizes: {
      type: Array,
      default() {
        return [10, 20, 30, 50]
      }
    },
    // 移动端页码按钮的数量端默认值5
    pagerCount: {
      type: Number,
      default: document.body.clientWidth < 992 ? 5 : 7
    },
    layout: {
      type: String,
      default: 'total, sizes, prev, pager, next, jumper'
    },
    background: {
      type: Boolean,
      default: true
    },
    autoScroll: {
      type: Boolean,
      default: true
    },
    hidden: {
      type: Boolean,
      default: false
    }
  },
  data() {
    return {
    };
  },
  computed: {
    currentPage: {
      get() {
        return this.page
      },
      set(val) {
        this.$emit('update:page', val)
      }
    },
    pageSize: {
      get() {
        return this.limit
      },
      set(val) {
        this.$emit('update:limit', val)
      }
    }
  },
  methods: {
    handleSizeChange(val) {
      if (this.currentPage * val > this.total) {
        this.currentPage = 1
      }
      this.$emit('pagination', { page: this.currentPage, limit: val })
      if (this.autoScroll) {
        scrollTo(0, 800)
      }
    },
    handleCurrentChange(val) {
      this.$emit('pagination', { page: val, limit: this.pageSize })
      if (this.autoScroll) {
        scrollTo(0, 800)
      }
    }
  }
}
</script>

<style scoped lang="scss">
/* 定义颜色变量 */
$background-color: #1E1E1E;      // 深色背景
$text-color: #FFFFFF;            // 白色文字
$accent-color: #9b59b6;          // 紫色，用于强调色
$hover-background: darken($background-color, 5%); // 悬停时的背景色

.pagination-container {
  background-color: $background-color;
  padding: 32px 16px;
  color: $text-color;

  .el-pagination {
    background-color: transparent;

    .el-pager li:not(.disabled) {
      color: $text-color;

      &:hover {
        background-color: $hover-background;
      }

      &.active {
        background-color: $accent-color;
        color: $text-color;
      }
    }

    .el-icon, .el-pagination__sizes, .el-pagination__jump {
      color: $text-color;
    }

    .el-select-dropdown {
      background-color: $background-color;
      color: $text-color;

      .el-select-dropdown__item {
        &:hover {
          background-color: $hover-background;
        }

        &.selected {
          background-color: $accent-color;
          color: $text-color;
        }
      }
    }

    .el-input__inner {
      background-color: darken($background-color, 5%);
      color: $text-color;
      border: 1px solid #444;
    }

    .el-select .el-input {
      background-color: transparent;
    }
  }
}

.pagination-container.hidden {
  display: none;
}
</style>
