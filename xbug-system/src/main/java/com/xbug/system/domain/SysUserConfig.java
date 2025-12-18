package com.xbug.system.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.xbug.common.annotation.Excel;
import com.xbug.common.core.domain.BaseEntity;

/**
 * 用户配置对象 sys_user_config
 * 
 * @author rzk
 * @date 2023-11-16
 */
@Data
public class SysUserConfig extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户配置id */
    private Long userConfigId;

    /** 当前团队id */
    @Excel(name = "当前团队id")
    private Long currentTeamId;

    /** 当前项目id */
    private Long currentProjectId;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userConfigId", getUserConfigId())
            .append("currentTeamId", getCurrentTeamId())
            .append("userId", getUserId())
            .toString();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserConfigId() {
        return userConfigId;
    }

    public void setUserConfigId(Long userConfigId) {
        this.userConfigId = userConfigId;
    }

    public Long getCurrentTeamId() {
        return currentTeamId;
    }

    public void setCurrentTeamId(Long currentTeamId) {
        this.currentTeamId = currentTeamId;
    }

    public Long getCurrentProjectId() {
        return currentProjectId;
    }

    public void setCurrentProjectId(Long currentProjectId) {
        this.currentProjectId = currentProjectId;
    }
}
