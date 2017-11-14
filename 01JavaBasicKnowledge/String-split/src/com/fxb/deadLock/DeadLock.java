package com.fxb.deadLock;

/**
 * @create by: wangxiyue on 2017/7/20 16:29.
 * @ClassName:
 * @userfor:
 * @description:
 */
public class DeadLock implements Runnable {
    public int flag=1;
    public static Object o1=new Object();
    public static Object o2=new Object();

    public static void main(String[] args){
        DeadLock td1=new DeadLock();
        DeadLock td2=new DeadLock();
        td1.flag=1;
        td2.flag=2;
        Thread t1=new Thread(td1);
        Thread t2=new Thread(td2);
        t1.start();
        t2.start();
    }

    @Override
    public void run(){
        System.out.println("flag:" + flag);
        if (flag == 1) {
            synchronized (o1) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                synchronized (o2) {
                    System.out.println("1");
                }
            }

        } else if (flag == 2) {
            synchronized (o2) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                synchronized (o1) {
                    System.out.println("2");
                }
            }

        }

    }
}
