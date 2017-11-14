package com.fxb.schedule.demo1_SimpleJob;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author fangxiaobai on 2017/10/16 21:05.
 * @description
 */
public class SimpleJob implements Job {
    
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("simple Trigger -- 【"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"】");
    }
    
}
