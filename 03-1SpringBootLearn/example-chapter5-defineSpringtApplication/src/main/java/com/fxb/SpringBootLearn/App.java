package com.fxb.SpringBootLearn;

import com.sun.glass.ui.Application;
import javafx.scene.Parent;
import org.springframework.boot.Banner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author 方小白 on 2017/9/14 16:49.
 * @description
 */
@SpringBootApplication
public class App implements ExitCodeGenerator{
    public static void main(String[] args) {
        /**
         * 传递给SpringApplication的构造器参数是spring beans的配置源。
         * 在大多数情况下，这些将是@Configuration类的引用，但它们也可能是XML配置或要扫描包的引用。
         */
//        SpringApplication app = new SpringApplication(App.class);
//        app.setBannerMode(Banner.Mode.LOG);
//        app.run(args);
    
        /***
         * ：创建ApplicationContext层次时有些限制，比如，Web组件(components)必须包含在子上
         * 下文(child context)中，且相同的Environment即用于父上下文也用于子上下文中。
         */
        new SpringApplicationBuilder().sources(Parent.class).child(App.class).run(args);
    }
    
    @Override
    public int getExitCode() {
        return 0;
    }
}
