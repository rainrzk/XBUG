package com.xbug.system.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.xbug.common.annotation.Excel;
import com.xbug.common.core.domain.BaseEntity;

/**
 * 团队对象 sys_team
 * 
 * @author rzk
 * @date 2023-11-13
 */
@Data
public class SysTeam extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 团队id */
    private Long teamId;

    /** 团队名称 */
    @Excel(name = "团队名称")
    private String teamName;

    /** 团队图标 */
    @Excel(name = "团队图标")
    private String teamIcon;

    /** 团队介绍 */
    @Excel(name = "团队介绍")
    private String introduce;

    /** 是否删除 */
    private boolean isDel;

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("teamId", getTeamId())
            .append("teamName", getTeamName())
            .append("teamIcon", getTeamIcon())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("introduce", getIntroduce())
            .append("isDel", isDel())
            .toString();
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }
    
    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
    
    public String getTeamIcon() {
        return teamIcon;
    }

    public void setTeamIcon(String teamIcon) {
        this.teamIcon = teamIcon;
    }
    
    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public boolean isDel() {
        return isDel;
    }

    public void setDel(boolean isDel) {
        this.isDel = isDel;
    }
}
