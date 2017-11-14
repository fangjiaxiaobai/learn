package com.fxb.socket.multithreading;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @create by: wangxiyue on 2017/7/14 16:59.
 * @ClassName:
 * @userfor:
 * @description:
 */
public class ClientThread implements Runnable {
    private Socket s ;

    BufferedReader br = null;
    public ClientThread(Socket s) throws IOException{
        this.s = s ;
        br = new BufferedReader(new InputStreamReader(s.getInputStream()));
    }

    @Override
    public void run(){
        try {
            String content = null;
            while (null != (content=br.readLine())) {
                System.out.println(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
