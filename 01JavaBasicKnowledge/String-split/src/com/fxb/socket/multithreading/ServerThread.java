package com.fxb.socket.multithreading;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * @create by: wangxiyue on 2017/7/14 16:39.
 * @ClassName:
 * @userfor:
 * @description:
 */
public class ServerThread implements Runnable {

    Socket s=null;

    /**
     * 该线程处理Socket的数据流。
     */
    BufferedReader br=null;

    public ServerThread(Socket s) throws IOException{
        this.s=s;
        this.br=new BufferedReader(new InputStreamReader(s.getInputStream()));
    }

    @Override
    public void run(){
        try {
            String content=null;
            while (null != (content=readFromClient())) {
                for (Socket socket : MyServer.sockertList) {
                    PrintStream ps=new PrintStream(socket.getOutputStream());
                    ps.println(content);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String readFromClient(){
        try {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            MyServer.sockertList.remove(s);
        }
        return null;
    }
}
