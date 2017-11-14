package com.fxb.js;

import javax.script.*;

/**
 * @author 方小白 on 2017/9/28 16:51.
 * @description
 *
 *      演示JVM动态语言。
 *
 *
 */
public class ScriptSample {
    public static void main(String[] args) throws ScriptException, NoSuchMethodException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine scriptEngine = manager.getEngineByName("JavaScript");
        String scriptText = "function sum(a,b){return a+b;}";
        scriptEngine.eval(scriptText);
        Invocable invocable = (Invocable) scriptEngine;
        Object result = invocable.invokeFunction("sum",100,99);
        System.out.println(result);
    }
}
