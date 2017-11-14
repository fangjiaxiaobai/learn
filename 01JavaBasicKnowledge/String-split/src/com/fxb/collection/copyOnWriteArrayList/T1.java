package com.fxb.collection.copyOnWriteArrayList;

import java.util.List;

/**
 * @create by: wangxiyue on 2017/7/13 17:39.
 * @ClassName:
 * @userfor:
 * @description:
 */
public class T1 extends Thread {
    private List<Integer> list;

    public T1(List<Integer> list)
    {
        this.list = list;
    }

    public void run()
    {
        for (Integer i : list)
        {
            System.out.println(i);
        }
    }
}
