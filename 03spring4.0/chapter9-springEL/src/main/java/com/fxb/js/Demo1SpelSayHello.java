package com.fxb.js;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * @author wangxiyue on 2017/9/28 17:13.
 * @description
 */
public class Demo1SpelSayHello {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'hello'+' world'");
        String message = (String) exp.getValue();
        System.out.println(message);
    }
}
