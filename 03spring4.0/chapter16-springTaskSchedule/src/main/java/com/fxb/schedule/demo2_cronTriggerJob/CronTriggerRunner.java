package com.fxb.schedule.demo2_cronTriggerJob;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author fangxiaobai on 2017/10/16 21:29.
 * @description
 */
public class CronTriggerRunner {
    
    public static void main(String[] args) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(CronJob.class).withIdentity("job2-1","tjob2-2").build();
    
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger2-1","tgroup2-1")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/1 * * * * ?"))
                .build();
        
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.scheduleJob(jobDetail,trigger);
        scheduler.start();
        
    }
    
    
}
