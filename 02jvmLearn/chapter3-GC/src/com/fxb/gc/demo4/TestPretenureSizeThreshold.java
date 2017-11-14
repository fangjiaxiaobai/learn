package com.fxb.gc.demo4;

/**
 * @author wangxiyue on 2017/10/9 21:05.
 * @description
 *
 *      VM option:-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:+PrintGCDetails
 */
public class TestPretenureSizeThreshold {
    
    private static final int _1MB = 1024 * 1024;
    
    public static void testPretenureSizeThreshold(){
        byte [] allocation;
        allocation = new byte[4*_1MB];
    }
    
    public static void main(String[] args) {
        testPretenureSizeThreshold();
    }
    
}
