package com.chinesepander.excel.annotation;

import com.chinesepander.excel.calulate.Calculate;

import java.lang.annotation.*;

/**
 * Excel注解定义。
 *
 * @author fangjiaxiaobai@163.com
 * @instraduce <p> @target：表示该注解可以用到什么地方。
 * <p> @Retention: 表示该注解的作用域。
 * <>取值有三，RetentionPolicy.SOURCE:保留在源文件里，编译完成后便不存在
 * <>RetionPolicy.ClASS：到编译阶段，class文件中会存在，运行时不存在,
 * <>RetetionPolicy.RUNTIME：运行阶段</>
 * <p> @Documented: 指定该注解会被javadoc工具提取成文档</p>
 * <p> @Inherited: 被它修饰的注解将有继承性，如果某个类使用被@Inherited修饰的注解,则其子类自动具有该注解</p>
 * <p>
 * 注解小知识点：
 * 1.从java8开始，注解可以应用到任何地方。
 * 创建类实例：new@Interned MyObject()
 * 类型映射：myString=(@NonNull String)str;
 * implemenmts语句中：class UnmodifiableList<T> implements @Readonly List<@Readonly T>{.... }
 * throw exception声明 : void monitorTemperature() throws@Critical TemperatureException { ... }
 * @date 2018-04-18
 */
// 可以使用在字段，方法和类上面
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
// 定义注解可以保留的域
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExcelField {

    /**
     * 导出字段的名称
     *
     * @return
     */
    String value() default "";

    /**
     * 字段的标题
     *
     * @return
     */
    String title();

    /**
     * 字段类型
     * 0 导入导出
     * 1 仅导出
     * 2 仅导入
     *
     * @return
     */
    int type() default 0;

    /**
     * 字段的对其方式
     *
     * @return
     */
    int align() default 0;

    /**
     * 导出字段排序
     *
     * @return
     */
    int sort() default 0;

    /**
     * 字典类型
     *
     * @return
     */
    String dictType() default "";

    /**
     * 字段归属组
     *
     * @return
     */
    int[] groups() default {};

    /**
     * 值需要计算得出，计算的程序方法
     *
     * @return
     */
    String calculate() default "";

    /**
     * 计算所需的字段
     *
     * @return
     */
    String[] calculateField() default {};

    /**
     * 导入时不能为空
     */
    boolean isRequired() default false;

    /**
     * 导入为空时的提示
     *
     * @return
     */
    String message() default "";

}
