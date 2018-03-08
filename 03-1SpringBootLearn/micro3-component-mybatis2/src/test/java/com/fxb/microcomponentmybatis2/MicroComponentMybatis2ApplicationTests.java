package com.fxb.microcomponentmybatis2;

import com.fxb.microcomponentmybatis2.model.User;
import com.fxb.microcomponentmybatis2.model.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MicroComponentMybatis2ApplicationTests {

    @Autowired
    private UserMapper userMapper;
    
	@Test
	public void contextLoads() {
	    userMapper.insert("wangsu","123456","123456789111");
	    User user = userMapper.findUserByPhone("123456789111");
        System.out.println(user);
//        Assert.assertEquals("wangsu",user.getUsername());
	}
	@Test
    @Transactional
	public void test2() {
	    userMapper.insert("wangsu1","123456","45456456");
//	        int a = 1/ 0;
	    userMapper.insert("wangsu2","123456","123130");
	    
//        Assert.assertEquals("wangsu",user.getUsername());
	}

}
