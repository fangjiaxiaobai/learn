package com.fxb.learn.chapterspringbootlearn;

import com.fxb.learn.chapterspringbootlearn.controller.HelloController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class ChapterSpringbootlearnApplicationTests {

    //用于模拟调用Controller的接口发起请求。
    private MockMvc mvc;

	@Test
	public void contextLoads() throws Exception {
	    // perform:执行一次请求调用，accept用于执行接口的数据类型。andExpect 用于判断接口返回的期望值。
	    mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().string(equalTo("hello")));
	}

	@Before
	public void setUp(){
		mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
	}



}
