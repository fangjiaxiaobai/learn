package com.fxb.socket.multithreading;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * @create by: wangxiyue on 2017/7/14 16:36.
 * @ClassName:
 * @userfor:
 * @description:
 */
public class MyServer {
    public static ArrayList<Socket> sockertList = new ArrayList<Socket>();

    public static void main(String[] args) throws IOException{
        ServerSocket ss = new ServerSocket(52134);
        while(true){
            Socket s = ss.accept();
            sockertList.add(s);
            new Thread(new ServerThread(s)).start();
        }
    }
}
