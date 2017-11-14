package com.fxb.socket;

import java.net.InetAddress;

/**
 * @create by: wangxiyue on 2017/7/14 16:04.
 * @ClassName:
 * @userfor:
 * @description:
 */
public class Iddress {

    public static void main(String[] args){
        try {
            InetAddress address=InetAddress.getLocalHost();
            System.out.println(address.getHostAddress());
            System.out.println(address.getHostName());
            System.out.println(address.getCanonicalHostName());

            InetAddress address1 = InetAddress.getByName("SX003249");
            System.out.println(address1.getHostAddress());
            System.out.println(address1.getCanonicalHostName());

//            InetAddress address2 = InetAddress.getByAddress("10.12.28.252".getBytes());
            System.out.println(address1.getHostAddress());
            System.out.println(address1.getCanonicalHostName());
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
