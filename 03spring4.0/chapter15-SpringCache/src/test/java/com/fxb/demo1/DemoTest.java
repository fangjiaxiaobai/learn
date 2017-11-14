package com.fxb.demo1;

import com.fxb.demo1.useCache.service.UserService;

/**
 * @author 方小白 on 2017/10/9 16:06.
 * @description
 */
    public class DemoTest {
        
        public static void main(String[] args) {
            
            UserService userService = new UserService();
            userService.getUserById("0001");
            userService.getUserById("0001");
            
            
            userService.reload();
            System.out.println("---------------after reload--------------");
            userService.getUserById("0001");
            userService.getUserById("0001");
            
        }
    
}
