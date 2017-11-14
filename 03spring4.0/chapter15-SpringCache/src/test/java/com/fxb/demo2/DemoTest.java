package com.fxb.demo2;

import com.fxb.demo2.useSpringCache.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 方小白 on 2017/10/9 16:06.
 * @description
 */
    public class DemoTest {
        
        public static void main(String[] args) {
    
            ApplicationContext app = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
            UserService userService = (com.fxb.demo2.useSpringCache.service.UserService) app.getBean("userService");
    
                        
            userService.getUserById("0002");
            System.out.println("--------------- second query --------------");
            userService.getUserById("0002");
            
        }
    
}
