package com.xbug.system.domain.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: rzk
 * @CreateTime: 2023-11-30 11:25
 * @Version: 1.0.0
 */
@Data
// @AllArgsConstructor
// @NoArgsConstructor
public class EnumVo {
    private Integer key;
    private String value;

    // 无参构造函数
    public EnumVo() {
    }

    // 有参构造函数
    public EnumVo(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    // Getter 和 Setter（可选）
    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

