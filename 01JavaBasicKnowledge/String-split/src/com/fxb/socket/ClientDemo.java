package com.fxb.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @create by: wangxiyue on 2017/7/14 15:27.
 * @ClassName:
 * @userfor:
 * @description:
 */
public class ClientDemo {
    public static void main(String[] args){
        try {
            Socket socket = new Socket("127.0.0.1",52641);
            System.out.println("客户端启动成功");

            //控制台输入
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            //发送给server的流
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            //读取server的流
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.print("Clinet：");
            String line = in.readLine();

            while (!"end".equals(line)) {
                writer.println(line);
                writer.flush();
                System.out.println("server:"+br.readLine());
                System.out.print("Client: ");
                line = in.readLine();
            }
            writer.println("end");
            writer.close();
            in.close();
            socket.close();


        }catch (Exception e){
            e.printStackTrace();
            System.out.println("客户端启动失败");
        }
    }
}
