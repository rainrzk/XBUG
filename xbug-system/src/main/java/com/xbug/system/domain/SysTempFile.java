package com.xbug.system.domain;

import com.xbug.system.domain.type.SysTempFileTypeEnum;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.xbug.common.annotation.Excel;
import com.xbug.common.core.domain.BaseEntity;

/**
 * 临时文件对象 sys_temp_file
 * 
 * @author rzk
 * @date 2023-12-07
 */
@Data
public class SysTempFile extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 文件id */
    private Long fileId;

    /** 文件名 */
    @Excel(name = "文件名")
    private String fileName;

    /** 来源地址 */
    @Excel(name = "来源地址")
    private String srcUrl;

    /** 文件类型 */
    @Excel(name = "文件类型")
    private SysTempFileTypeEnum fileType;

    /** 文件地址 */
    @Excel(name = "文件地址")
    private String fileUrl;

    /** 文件内容 */
    private Object fileBody;


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("fileId", getFileId())
            .append("fileName", getFileName())
            .append("srcUrl", getSrcUrl())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("fileType", getFileType())
            .append("fileUrl", getFileUrl())
            .toString();
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getSrcUrl() {
        return srcUrl;
    }

    public void setSrcUrl(String srcUrl) {
        this.srcUrl = srcUrl;
    }

    public SysTempFileTypeEnum getFileType() {
        return fileType;
    }

    public void setFileType(SysTempFileTypeEnum fileType) {
        this.fileType = fileType;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public Object getFileBody() {
        return fileBody;
    }

    public void setFileBody(Object fileBody) {
        this.fileBody = fileBody;
    }
}
