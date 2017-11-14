package com.fxb.schedule.demo1_SimpleJob;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author fangxiaobai on 2017/10/16 21:08.
 * @description
 */
public class SimpleTriggerRunner {
    
    public static void main(String[] args) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(SimpleJob.class).withIdentity("job1-1", "jgroup1-1").build();
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1-1", "tgroup1-1")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withRepeatCount(100).withIntervalInMilliseconds(1000))
                .withPriority(1000)
                .build();
        
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.scheduleJob(jobDetail,trigger);
        scheduler.start();
    }
    
}
