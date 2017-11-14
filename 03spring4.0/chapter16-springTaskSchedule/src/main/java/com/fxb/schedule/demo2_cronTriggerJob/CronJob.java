package com.fxb.schedule.demo2_cronTriggerJob;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author fangxiaobai on 2017/10/16 21:05.
 * @description
 */
public class CronJob implements Job {
    
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("cron Trigger -- 【"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"】");
    }
    
}
