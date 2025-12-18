package com.xbug.quartz.mapper;

import java.util.List;
import com.xbug.quartz.domain.SysJobLog;

/**
 * 调度用例日志信息 数据层
 * 
 * @author ruoyi
 */
public interface SysJobLogMapper
{
    /**
     * 获取quartz调度器日志的计划用例
     * 
     * @param jobLog 调度日志信息
     * @return 调度用例日志集合
     */
    public List<SysJobLog> selectJobLogList(SysJobLog jobLog);

    /**
     * 查询所有调度用例日志
     *
     * @return 调度用例日志列表
     */
    public List<SysJobLog> selectJobLogAll();

    /**
     * 通过调度用例日志ID查询调度信息
     * 
     * @param jobLogId 调度用例日志ID
     * @return 调度用例日志对象信息
     */
    public SysJobLog selectJobLogById(Long jobLogId);

    /**
     * 新增用例日志
     * 
     * @param jobLog 调度日志信息
     * @return 结果
     */
    public int insertJobLog(SysJobLog jobLog);

    /**
     * 批量删除调度日志信息
     * 
     * @param logIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteJobLogByIds(Long[] logIds);

    /**
     * 删除用例日志
     * 
     * @param jobId 调度日志ID
     * @return 结果
     */
    public int deleteJobLogById(Long jobId);

    /**
     * 清空用例日志
     */
    public void cleanJobLog();
}
