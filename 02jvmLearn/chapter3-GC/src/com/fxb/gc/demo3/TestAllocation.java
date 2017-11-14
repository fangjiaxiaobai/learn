package com.fxb.gc.demo3;

/**
 * @author 方小白 on 2017/10/9 20:47.
 * @description
 *
 *  VM option：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:+PrintGCDetails
 *
 *
 */
public class TestAllocation {
    
    private static final int _1MB = 1024 * 1024;
    
    public static void testAllocation() {
        byte[] all1, all2, all3, all4;
        all1 = new byte[2 * _1MB];
        all2 = new byte[2 * _1MB];
        all3 = new byte[2 * _1MB];
        all4 = new byte[4 * _1MB];
    }
    
    public static void main(String[] args) {
        testAllocation();
    }
    
}
