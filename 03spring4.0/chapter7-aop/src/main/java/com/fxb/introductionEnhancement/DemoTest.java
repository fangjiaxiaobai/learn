package com.fxb.introductionEnhancement;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wangxiyue on 2017/9/27 9:48.
 * @description
 */
public class DemoTest {
    
    String configPath = "classpath:/applicationContext.xml";
    ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
    
    @Test
    public void test1(){
        ForumService forumService = (ForumService) ctx.getBean("introducerService");
//        forumService.demo();
    
        // 启动监测
        Monitorable monitorable = (Monitorable) forumService;
        monitorable.setMonitorActive(true);
//        forumService.demo();
    }
}
