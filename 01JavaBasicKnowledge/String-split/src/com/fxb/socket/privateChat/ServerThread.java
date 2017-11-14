package com.fxb.socket.privateChat;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * @create by: wangxiyue on 2017/7/14 17:30.
 * @ClassName:
 * @userfor:
 * @description:
 */
public class ServerThread extends Thread{
    private Socket socket;
    BufferedReader br = null;
    PrintStream ps = null;

    public ServerThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run(){
        super.run();
    }
}
