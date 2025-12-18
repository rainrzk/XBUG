package com.xbug.system.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.xbug.common.annotation.Excel;
import com.xbug.common.core.domain.BaseEntity;

/**
 * 用户团队角色对象 sys_user_team
 * 
 * @author rzk
 * @date 2023-11-20
 */
@Data
public class SysUserTeam extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户团队id */
    private Long userTeamId;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 团队id */
    @Excel(name = "团队id")
    private Long teamId;

    /** 是否锁定 */
    @Excel(name = "是否锁定")
    private Integer teamLock;

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userTeamId", getUserTeamId())
            .append("userId", getUserId())
            .append("teamId", getTeamId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("teamLock", getTeamLock())
            .toString();
    }

    // 添加 setTeamId 方法
    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    // 添加 setUserId 方法
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserTeamId() {
        return userTeamId;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getTeamId() {
        return teamId;
    }
    
    public Integer getTeamLock() {
        return teamLock;
    }
}
