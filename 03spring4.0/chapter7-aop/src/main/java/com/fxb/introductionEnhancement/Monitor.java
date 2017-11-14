package com.fxb.introductionEnhancement;

/**
 * @author wangxiyue on 2017/9/27 9:37.
 * @description
 */
public interface Monitor {
    // 监测开始
    void begin(String name);
    
    // 监测结束
    void end(String name);
}
