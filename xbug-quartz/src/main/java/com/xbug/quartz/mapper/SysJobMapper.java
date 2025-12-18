package com.xbug.quartz.mapper;

import java.util.List;
import com.xbug.quartz.domain.SysJob;

/**
 * 调度用例信息 数据层
 * 
 * @author ruoyi
 */
public interface SysJobMapper
{
    /**
     * 查询调度用例日志集合
     * 
     * @param job 调度信息
     * @return 操作日志集合
     */
    public List<SysJob> selectJobList(SysJob job);

    /**
     * 查询所有调度用例
     * 
     * @return 调度用例列表
     */
    public List<SysJob> selectJobAll();

    /**
     * 通过调度ID查询调度用例信息
     * 
     * @param jobId 调度ID
     * @return 角色对象信息
     */
    public SysJob selectJobById(Long jobId);

    /**
     * 通过调度ID删除调度用例信息
     * 
     * @param jobId 调度ID
     * @return 结果
     */
    public int deleteJobById(Long jobId);

    /**
     * 批量删除调度用例信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteJobByIds(Long[] ids);

    /**
     * 修改调度用例信息
     * 
     * @param job 调度用例信息
     * @return 结果
     */
    public int updateJob(SysJob job);

    /**
     * 新增调度用例信息
     * 
     * @param job 调度用例信息
     * @return 结果
     */
    public int insertJob(SysJob job);
}
