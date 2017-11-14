package com.fxb.springBootLearn.web;

import com.fxb.springBootLearn.config.AuthorSettings;
import com.fxb.springBootLearn.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.Date;
import java.util.Map;

/**
 * @author 方小白 on 2017/9/13 15:24.
 * @description
 */

@Controller
@EnableAutoConfiguration
public class Example {
    public static void main(String[] args){
        SpringApplication.run(Example.class,args);
    }
    
    /**
     *  设置为默认页
     * @return
     */
    @RequestMapping("/")
    @ResponseBody
    public String home(){
        return "Hello World,方小白,fighting";
    }
    
    //从application.properties中读取配置，如果取不到就默认值为 "hello fxb"
    @Value("${application.hello:hello fxb}")
    private String hello;
    
    @RequestMapping("/sayHello")
    @ResponseBody
    public String sayHello(){
        return hello;
    }
    
    @RequestMapping(value = {"/index.html","/index"})
    public String index(Map<String ,Object > model){
        model.put("time",new Date());
        model.put("message",this.hello);
        return "index";
    }
    
    @RequestMapping("/name/{name}")
    @ResponseBody
    public String hello(@PathVariable String name){
        return "hello " + name;
    }
    
    // 响应到jsp页面 page1
    @RequestMapping("/page1")
    public ModelAndView page1(){
        ModelAndView mav = new ModelAndView("page/page1");
        mav.addObject("content",this.hello);
        return mav;
    }
    
    // 响应jsp页面page1，可以直接使用model封装内容，直接返回页面字符串
    @RequestMapping("/page2")
    public String page2(Model model){
        model.addAttribute("content",hello+"(第二种)");
        return "page/page1";
    }
    
    
    @Bean(name="viewResolver")
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver view=new InternalResourceViewResolver();
//        view.setOrder(0);
        view.setPrefix("/WEB-INF/jsp/");
        view.setSuffix(".jsp");
        view.setViewClass(JstlView.class);
        view.setContentType("text/html");
        return view;
    }
    
    @Bean
    public BeanNameViewResolver beanNameViewResolver(){
        BeanNameViewResolver resolver = new BeanNameViewResolver();
        return resolver;
    }
    
    public String json(Model model){
        Person person = new Person("方小白",23);
        model.addAttribute("person",person);
        return "jsonView";
    }
    
    
    // 类型安全的配置；AuthorSettings
    @Autowired
    private AuthorSettings authorSettings;
    
    @RequestMapping("showAuthor")
    @ResponseBody
    public AuthorSettings showAuthor(){
        return authorSettings;
    }
    
}
