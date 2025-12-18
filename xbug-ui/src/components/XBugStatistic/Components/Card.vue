<template>
  <div class="statistic-box">
    <div class="statistic-box-header">
      <x-bug-title :title="title"></x-bug-title>
      <div class="statistic-box-tools">
        <slot name="left-tools"></slot>
        <slot name="default-tools">
          <svg-icon
            class="statistic-box-button"
            v-for="(tool, index) in tools"
            :key="index"
            :icon-class="tool.icon"
            @click="toolsHandle($event, tool)"
          />
        </slot>
        <slot name="right-tools"></slot>
      </div>
    </div>
    <slot name="content"></slot>
  </div>
</template>

<script>
import XBugTitle from './Title';
export default {
  name: 'Card',
  components: { XBugTitle },
  props: {
    title: {
      type: String,
      default: null,
    },
    tools: {
      type: Array,
      default: () => [],
    },
  },
  methods: {
    toolsHandle(e, tool) {
      this.$emit('tools-click', e, tool);
      e.stopPropagation();
    },
  },
};
</script>

<style lang="scss" scoped>
/* 定义颜色变量 */
$background-color: #1E1E1E; // 深色背景
$box-background-color: #2C2C2E; // 盒子背景
$border-color: #3C3C3C; // 边框颜色
$text-color: #FFFFFF; // 白色文字
$secondary-text-color: rgba(255, 255, 255, 0.7); // 次要文字颜色
$icon-color: rgba(255, 255, 255, 0.7); // 图标默认颜色
$icon-hover-color: #9b59b6; // 图标悬停颜色（紫色）

.statistic-box {
  background-color: $box-background-color;
  border: 1px solid $border-color;
  padding: 10px 30px;
  border-radius: 5px;
  color: $text-color;

  .statistic-box-header {
    display: inline-flex;
    flex-direction: row;
    justify-content: space-between;
    align-items: center;
    width: 100%;

    .x-bug-title {
      flex: 1;
      color: $text-color;
    }

    .statistic-box-tools {
      margin-right: -5px;
      font-size: 14px;

      .statistic-box-button {
        cursor: pointer;
        color: $icon-color;
        margin: 0px 5px;

        &:hover {
          color: $icon-hover-color;
        }
      }
    }
  }
}

.x-bug-title {
  height: 100px;
  width: 100%;
  color: $text-color;
}
</style>
