package com.fxb.schedule.demo3_calendarJob;

import org.quartz.*;
import org.quartz.impl.StdScheduler;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.AnnualCalendar;
import org.quartz.impl.calendar.CronCalendar;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author fangxiaobai on 2017/10/17 9:35.
 * @description
 *     在实际的任务调度中，不可能一成不变的按照某个特定周期调度任务，必须考虑到现实生活中的特殊日期。
 *
 */
public class CalendarJobRunner {
    
    public static void main(String[] args) throws SchedulerException, ParseException {
//        demo_annualCalendar();
        demo_cromCalendar();
    
    }
    
    private static void demo_annualCalendar() throws SchedulerException {
        //法定节日是以每年为周期，所以使用AnnualCalendar;
        AnnualCalendar holidays = new AnnualCalendar();
        
        /*** 设置 法定节日  ***/
        Calendar laborDay = new GregorianCalendar();
        laborDay.add(Calendar.MONTH,5);
        laborDay.add(Calendar.DATE,1);
        
        Calendar nationDay = new GregorianCalendar();
        nationDay.add(Calendar.MONTH,10);
        nationDay.add(Calendar.DATE,1);
        
        ArrayList<Calendar> calendars = new ArrayList <Calendar>();
        calendars.add(laborDay);
        calendars.add(nationDay);
        holidays.setDaysExcluded(calendars);
        
        
        JobDetail jobDetail = JobBuilder.newJob(CalendarJob.class)
                .withIdentity("job3-1","jgroup3-1")
                .build();
        Trigger simpleTrigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger3-1","tgroup3-1")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withRepeatCount(10).withIntervalInMilliseconds(1000))
                .modifiedByCalendar("holidays")
                .build();
        
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        // 向scheduler中注册日历
        scheduler.addCalendar("holidays",holidays,false,false);
        // 让Trigger应用指定的日历规则
        scheduler.scheduleJob(jobDetail,simpleTrigger);
        
        scheduler.start();
    }
    
    private static void demo_cromCalendar() throws SchedulerException, ParseException {
        //法定节日是以每年为周期，所以使用AnnualCalendar;
        
        /*** 设置 法定节日  ***/
        CronCalendar cronCalendar = new CronCalendar("0/5 * * * * ?");
        
        
        JobDetail jobDetail = JobBuilder.newJob(CalendarJob.class)
                .withIdentity("job3-2","jgroup3-2")
                .build();
        Trigger simpleTrigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger3-2","tgroup3-2")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withRepeatCount(100).withIntervalInMilliseconds(1000))
                .modifiedByCalendar("cronCalendar")
                .build();
        
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        // 向scheduler中注册日历
        scheduler.addCalendar("cronCalendar",cronCalendar,false,false);
        // 让Trigger应用指定的日历规则
        scheduler.scheduleJob(jobDetail,simpleTrigger);
        
        scheduler.start();
    }
    
    
}
