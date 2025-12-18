package com.xbug.quartz.service;

import java.util.List;
import org.quartz.SchedulerException;
import com.xbug.common.exception.job.TaskException;
import com.xbug.quartz.domain.SysJob;

/**
 * 定时用例调度信息信息 服务层
 * 
 * @author ruoyi
 */
public interface ISysJobService
{
    /**
     * 获取quartz调度器的计划用例
     * 
     * @param job 调度信息
     * @return 调度用例集合
     */
    public List<SysJob> selectJobList(SysJob job);

    /**
     * 通过调度用例ID查询调度信息
     * 
     * @param jobId 调度用例ID
     * @return 调度用例对象信息
     */
    public SysJob selectJobById(Long jobId);

    /**
     * 暂停用例
     * 
     * @param job 调度信息
     * @return 结果
     */
    public int pauseJob(SysJob job) throws SchedulerException;

    /**
     * 恢复用例
     * 
     * @param job 调度信息
     * @return 结果
     */
    public int resumeJob(SysJob job) throws SchedulerException;

    /**
     * 删除用例后，所对应的trigger也将被删除
     * 
     * @param job 调度信息
     * @return 结果
     */
    public int deleteJob(SysJob job) throws SchedulerException;

    /**
     * 批量删除调度信息
     * 
     * @param jobIds 需要删除的用例ID
     * @return 结果
     */
    public void deleteJobByIds(Long[] jobIds) throws SchedulerException;

    /**
     * 用例调度状态修改
     * 
     * @param job 调度信息
     * @return 结果
     */
    public int changeStatus(SysJob job) throws SchedulerException;

    /**
     * 立即运行用例
     * 
     * @param job 调度信息
     * @return 结果
     */
    public boolean run(SysJob job) throws SchedulerException;

    /**
     * 新增用例
     * 
     * @param job 调度信息
     * @return 结果
     */
    public int insertJob(SysJob job) throws SchedulerException, TaskException;

    /**
     * 更新用例
     * 
     * @param job 调度信息
     * @return 结果
     */
    public int updateJob(SysJob job) throws SchedulerException, TaskException;

    /**
     * 校验cron表达式是否有效
     * 
     * @param cronExpression 表达式
     * @return 结果
     */
    public boolean checkCronExpressionIsValid(String cronExpression);
}
