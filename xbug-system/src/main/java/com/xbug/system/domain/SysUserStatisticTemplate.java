package com.xbug.system.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.xbug.common.annotation.Excel;
import com.xbug.common.core.domain.BaseEntity;

import java.util.List;

/**
 * 用户统计模版对象 sys_user_statistic_template
 * 
 * @author rzk
 * @date 2024-01-24
 */
@Data
public class SysUserStatisticTemplate extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 统计模版id */
    private Long statisticTemplateId;

    /** 统计模版编码 */
    @Excel(name = "统计模版编码")
    private String statisticTemplatCode;

    /** 模型类型 */
    @Excel(name = "模型类型")
    private Long moduleType;

    /** 项目id */
    @Excel(name = "项目id")
    private Long projectId;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 统计模版配置 */
    @Excel(name = "统计模版配置")
    private String statisticTemplatConfig;

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("statisticTemplateId", getStatisticTemplateId())
            .append("statisticTemplatCode", getStatisticTemplatCode())
            .append("moduleType", getModuleType())
            .append("projectId", getProjectId())
            .append("userId", getUserId())
            .append("statisticTemplatConfig", getStatisticTemplatConfig())
            .toString();
    }

    public Long getStatisticTemplateId() {
        return statisticTemplateId;
    }

    public void setStatisticTemplateId(Long statisticTemplateId) {
        this.statisticTemplateId = statisticTemplateId;
    }

    public String getStatisticTemplatCode() {
        return statisticTemplatCode;
    }

    public void setStatisticTemplatCode(String statisticTemplatCode) {
        this.statisticTemplatCode = statisticTemplatCode;
    }
    
    public Long getModuleType() {
        return moduleType;
    }

    public void setModuleType(Long moduleType) {
        this.moduleType = moduleType;
    }
    
    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
    
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public String getStatisticTemplatConfig() {
        return statisticTemplatConfig;
    }

    public void setStatisticTemplatConfig(String statisticTemplatConfig) {
        this.statisticTemplatConfig = statisticTemplatConfig;
    }
}
