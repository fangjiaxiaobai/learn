package com.fxb.aspectj;

import org.aspectj.lang.annotation.*;

/**
 * @author 方小白 on 2017/9/27 21:02.
 * @description
 */
@Aspect  // 通过该注解将PreGreetingAspect标识为一个切面
public class PreGreetingAspect {
    
    /**
     * 前置增强
     */
    // 表达式的意思是在目标类的greetTo方法上织入增强，greetTo方法可以带任意的入参和任意的返回值。
    @Before("execution(* greetTo(..)) and args(String)") // 定义切点的增强类型。
    public void beforeGreeting(){ // 增强的横切逻辑
        System.out.println("how are you!");
    }
    
    /**
     * 后置增强
     *  value：该成员定义切点
     *  pointcut：表示切点的信息。
     *  returning：将目标对象方法的返回值绑定给增强的方法
     *  argNames：如果在java编译时未启用调试信息或者需要在运行期解析切点，就必须通过这个成员指定主机所标注增强方法的参数名
     */
    @AfterReturning("within(com.fxb.target.Waiter+) and args(String)")
    public void afterReturningGreeting(){
        System.out.println("后置增强---------afterReturningGreeting。。。。");
    }
    
    /**
     * 环绕增强：
     *  value;定义切点。
     *  argNames：如前所述。
     */
    @AfterReturning("within(com.fxb.target.Waiter+) and args(String)")
    public void aroundGreeting(){
        System.out.println("环绕增强-------arounGreeting.......");
    }
    
    /**
     * 抛出增强
     */
    @AfterThrowing("execution(* throwsTo(..))")
    public void afterThrowingGreeting(){
        System.out.println("抛出增强");
    }
    
    /**
     * final增强：不管是抛出异常还是正常退出，该增强都会得到执行。
     *  该增强没有对应的增强接口，可以把它看成ThrowsAdvice和AfterReturningAdvice的混合物。
     *      value：该成员用于定义切点。
     *      argNames：
     */
    @After("execution(* com.fxb..*.*(..))")
    public void afterGreeting(){
        System.out.println("final 增强     thank for you !!!");
    }
    
    
    
}
