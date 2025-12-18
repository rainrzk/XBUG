package com.xbug.system.domain;

import com.xbug.common.core.domain.entity.SysUser;
import com.xbug.system.domain.type.SysDefectLogStateEnum;
import com.xbug.system.domain.type.SysDefectStateEnum;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.xbug.common.annotation.Excel;
import com.xbug.common.core.domain.BaseEntity;

import java.util.List;

/**
 * 缺陷日志对象 sys_defect_log
 * 
 * @author rzk
 * @date 2023-11-23
 */
@Data
public class SysDefectLog extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 缺陷日志id */
    private Long defectLogId;

    /** 缺陷日志的描述 */
    @Excel(name = "缺陷日志的描述")
    private String defectLogDescribe;

    /** 处理类型(转发\评论\关闭) */
    private SysDefectLogStateEnum defectLogType = SysDefectLogStateEnum.CREATE;

    @Excel(name = "处理类型")
    private String defectLogTypeName;

    /** 缺陷接收人 */
    @Excel(name = "缺陷接收人")
    private List<Long> receiveBy;

    private List<SysUser> receiveByList;

    /** 附件集合 */
    @Excel(name = "附件集合")
    private String annexUrls;

    /** 缺陷id */
    @Excel(name = "缺陷id")
    private Long defectId;

    private String createByName;

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("defectLogId", getDefectLogId())
            .append("defectLogDescribe", getDefectLogDescribe())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("defectLogType", getDefectLogType())
            .append("receiveBy", getReceiveBy())
            .append("annexUrls", getAnnexUrls())
            .append("defectId", getDefectId())
            .toString();
    }

    public Long getDefectId() {
        return defectId;
    }

    public void setDefectId(Long defectId) {
        this.defectId = defectId;
    }

    public List<Long> getReceiveBy() {
        return receiveBy;
    }

    public void setReceiveBy(List<Long> receiveBy) {
        this.receiveBy = receiveBy;
    }


    public SysDefectLogStateEnum getDefectLogType() {
        return defectLogType;
    }

    public void setDefectLogType(SysDefectLogStateEnum defectLogType) {
        this.defectLogType = defectLogType;
    }

    public String getDefectLogTypeName() {
        return defectLogType.name();
    }

    public void setDefectLogTypeName(String defectLogTypeName) {
        this.defectLogTypeName = defectLogTypeName;
    }   

    public Long getDefectLogId() {
        return defectLogId;
    }

    public void setDefectLogId(Long defectLogId) {
        this.defectLogId = defectLogId;
    }

    public String getDefectLogDescribe() {
        return defectLogDescribe;
    }

    public void setDefectLogDescribe(String defectLogDescribe) {
        this.defectLogDescribe = defectLogDescribe;
    }

    public String getAnnexUrls() {
        return annexUrls;
    }

    public void setAnnexUrls(String annexUrls) {
        this.annexUrls = annexUrls;
    }

    public String getCreateByName() {
        return createByName;
    }

    public void setCreateByName(String createByName) {
        this.createByName = createByName;
    }
}
