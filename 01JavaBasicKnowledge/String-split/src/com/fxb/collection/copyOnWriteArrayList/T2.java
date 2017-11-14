package com.fxb.collection.copyOnWriteArrayList;

import java.util.List;

/**
 * @create by: wangxiyue on 2017/7/13 17:40.
 * @ClassName:
 * @userfor:
 * @description:
 */
public class T2 extends Thread
{
    private List<Integer> list;

    public T2(List<Integer> list)
    {
        this.list = list;
    }

    public void run()
    {
        for (int i = 0; i < list.size(); i++)
        {
            list.remove(i);
        }
    }
}
