package com.xbug.quartz.util;

import org.quartz.JobExecutionContext;
import com.xbug.quartz.domain.SysJob;

/**
 * 定时用例处理（允许并发执行）
 * 
 * @author ruoyi
 *
 */
public class QuartzJobExecution extends AbstractQuartzJob
{
    @Override
    protected void doExecute(JobExecutionContext context, SysJob sysJob) throws Exception
    {
        JobInvokeUtil.invokeMethod(sysJob);
    }
}
