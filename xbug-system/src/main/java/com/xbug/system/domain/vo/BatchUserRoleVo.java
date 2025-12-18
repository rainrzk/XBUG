package com.xbug.system.domain.vo;

import lombok.Data;

/**
 * @Author: rzk
 * @CreateTime: 2023-11-21 00:54
 * @Version: 1.0.0
 */
@Data
public class BatchUserRoleVo {
    /**
     * 团队id
     */
    private Long projectId;
    /**
     * 团队id
     */
    private Long teamId;

    /**
     * 角色id集合
     */
    private Long[] roleIds;

    /**
     * 成员id集合
     */
    private Long[] memberIds;

    public Long[] getMemberIds() {
        return memberIds;
    }

    public void setMemberIds(Long[] memberIds) {
        this.memberIds = memberIds;
    }

    public Long[] getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(Long[] roleIds) {
        this.roleIds = roleIds;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}
