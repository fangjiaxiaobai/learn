package com.fxb.socket.multithreading;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * @create by: wangxiyue on 2017/7/14 16:56.
 * @ClassName:
 * @userfor:
 * @description:
 */
public class MyClient {
    public static void main(String[] args) throws IOException{
        Socket s = new Socket("127.0.0.1",52134);
        new Thread(new ClientThread(s)).start();

        //本次Socket的发送流
        PrintStream ps = new PrintStream(s.getOutputStream());
        String line = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (null != (line=br.readLine())) {
            ps.println(line);
        }
    }
}
