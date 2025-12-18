package com.xbug.system.domain;

import java.util.Date;
import java.util.List;

import com.xbug.common.core.domain.entity.SysUser;
import com.xbug.system.domain.type.SysDefectStateEnum;
import com.xbug.system.domain.type.SysDefectTypeEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.xbug.common.annotation.Excel;
import com.xbug.common.core.domain.BaseEntity;

import javax.servlet.annotation.HandlesTypes;

/**
 * 缺陷对象 sys_defect
 * 
 * @author rzk
 * @date 2023-11-23
 */
@Data
public class SysDefect extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 缺陷id */
    private Long defectId;

    /** 项目编号 */
    private Long projectNum;

    /** 缺陷类型 */
    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private SysDefectTypeEnum defectType;

    @Excel(name = "缺陷类型")
    private SysDefectTypeEnum defectTypeName;

    /** 缺陷标题 */
    @Excel(name = "缺陷标题")
    private String defectName;

    /** 缺陷描述 */
    private String defectDescribe;

    /** 附件 */
    @Excel(name = "附件")
    private String annexUrls;

    /** 附件 */
    @Excel(name = "图片")
    private String imgUrls;

    /** 项目id */
    private Long projectId;

    /** 项目 */
    @Excel(name = "项目")
    private String projectName;


    /** 测试计划id */
//    @Excel(name = "测试计划id")
    private Long testPlanId;

    /** 测试用例id */
//    @Excel(name = "测试用例id")
    private Long caseId;

    /** 数据来源 */
    @Excel(name = "数据来源")
    private Integer dataSources;

    /** 数据来源相关参数 */
    @Excel(name = "数据来源相关参数")
    private String dataSourcesParams;

    /** 测试模块id */
    private Long moduleId;

    /** 测试模块名称 */
    @Excel(name = "测试模块id")
    private String moduleName;

    /** 版本 */
    @Excel(name = "版本")
    private String moduleVersion;

    /** 缺陷状态 */
    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private SysDefectStateEnum defectState;

    /** 缺陷状态 */
    @Excel(name = "缺陷状态")
    private SysDefectStateEnum defectStateName;

    /** 用例步骤id */
//    @Excel(name = "用例步骤id")
    private Long caseStepId;

    /** 处理人id */
    private List<Long> handleBy;

    /** 处理人名称 */
    @Excel(name = "处理人")
    private List<SysUser> handleByList;

    /** 处理时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "处理时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date handleTime;

    /** 缺陷等级 */
    private String defectLevel;

    @Excel(name = "缺陷等级")
    private String defectLevelName;

    /** 是否收藏 */
    private boolean collect;

    private String relatedDefectName;

    private Long relatedDefectId;

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("defectId", getDefectId())
            .append("defectType", getDefectType())
            .append("defectName", getDefectName())
            .append("defectDescribe", getDefectDescribe())
            .append("annexUrls", getAnnexUrls())
            .append("projectId", getProjectId())
            .append("projectName", getProjectName())
            .append("testPlanId", getTestPlanId())
            .append("caseId", getCaseId())
            .append("dataSources", getDataSources())
            .append("dataSourcesParams", getDataSourcesParams())
            .append("moduleId", getModuleId())
            .append("moduleVersion", getModuleVersion())
            .append("moduleName", getModuleName())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("defectState", getDefectState())
            .append("caseStepId", getCaseStepId())
            .append("handleBy", getHandleBy())
            .append("handleTime", getHandleTime())
            .append("defectLevel", getDefectLevel())
            .append("imgUrls", getImgUrls())
            .append("relatedDefectId", getRelatedDefectId())
            .append("relatedDefectName", getRelatedDefectName())
            .toString();
    }

    public List<Long> getHandleBy() {
        return handleBy;
    }

    public void setHandleBy(List<Long> handleBy) {
        this.handleBy = handleBy;
    }

    public List<SysUser> getHandleByList() {
        return handleByList;
    }

    public void setHandleByList(List<SysUser> handleByList) {
        this.handleByList = handleByList;
    }   

    public Date getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(Date handleTime) {
        this.handleTime = handleTime;
    }

    public String getDefectLevel() {
        return defectLevel;
    }

    public void setDefectLevel(String defectLevel) {
        this.defectLevel = defectLevel;
    }   

    public String getDefectLevelName() {
        return defectLevelName;
    }

    public void setDefectLevelName(String defectLevelName) {
        this.defectLevelName = defectLevelName;
    }
    
    public Long getDefectId() {
        return defectId;
    }

    public void setDefectId(Long defectId) {
        this.defectId = defectId;
    }

    public SysDefectStateEnum getDefectState() {
        return defectState;
    }

    public void setDefectState(SysDefectStateEnum defectState) {
        this.defectState = defectState;
    }
    
    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getProjectNum() {
        return projectNum;
    }

    public void setProjectNum(Long projectNum) {
        this.projectNum = projectNum;
    }

    public SysDefectTypeEnum getDefectType() {
        return defectType;
    }

    public void setDefectType(SysDefectTypeEnum defectType) {
        this.defectType = defectType;
    }

    public String getDefectName() {
        return defectName;
    }

    public void setDefectName(String defectName) {
        this.defectName = defectName;
    }

    public String getDefectDescribe() {
        return defectDescribe;
    }

    public void setDefectDescribe(String defectDescribe) {
        this.defectDescribe = defectDescribe;
    }

    public String getAnnexUrls() {
        return annexUrls;
    }

    public void setAnnexUrls(String annexUrls) {
        this.annexUrls = annexUrls;
    }
    
    public Long getTestPlanId() {
        return testPlanId;
    }

    public void setTestPlanId(Long testPlanId) {
        this.testPlanId = testPlanId;
    }

    public Long getCaseId() {
        return caseId;
    }

    public void setCaseId(Long caseId) {
        this.caseId = caseId;
    }
    
    public Integer getDataSources() {
        return dataSources;
    }

    public void setDataSources(Integer dataSources) {
        this.dataSources = dataSources;
    }

    public String getDataSourcesParams() {
        return dataSourcesParams;
    }

    public void setDataSourcesParams(String dataSourcesParams) {
        this.dataSourcesParams = dataSourcesParams;
    }
    
    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleVersion() {
        return moduleVersion;
    }

    public void setModuleVersion(String moduleVersion) {
        this.moduleVersion = moduleVersion;
    }

    public Long getCaseStepId() {
        return caseStepId;
    }

    public void setCaseStepId(Long caseStepId) {
        this.caseStepId = caseStepId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName; 
    }

    public String getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(String imgUrls) {
        this.imgUrls = imgUrls;
    }

    public Long getRelatedDefectId() {
        return relatedDefectId;
    }

    public void setRelatedDefectId(Long relatedDefectId) {
        this.relatedDefectId = relatedDefectId;
    }

    public String getRelatedDefectName() {
        return relatedDefectName;
    }

    public void setRelatedDefectName(String relatedDefectName) {
        this.relatedDefectName = relatedDefectName;
    }
}
