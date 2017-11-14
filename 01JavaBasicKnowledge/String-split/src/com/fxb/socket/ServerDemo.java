package com.fxb.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @create by: wangxiyue on 2017/7/14 15:04.
 * @ClassName:
 * @userfor:
 * @description:
 */
public class ServerDemo {
    public static void main(String[] args){
        ServerSocket serverSocket= null;
        try {
            serverSocket=new ServerSocket(52641);
            System.out.println("服务器启动成功");
        } catch (Exception e) {
//                e.printStackTrace();
            System.out.println("服务器端启动失败");
        }

        Socket socket = null;
        try {
            socket=serverSocket.accept();


            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader consoleIn = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());

            System.out.println("Client: "+ in.readLine());
            System.out.print("Server: ");
            String line = consoleIn.readLine();
            while(true){
                printWriter.println(line);
                printWriter.flush();
                System.out.println("Client:"+in.readLine());
                System.out.print("Server: ");
                line = consoleIn.readLine();
                if(false){
                    break;
                }
            }
            printWriter.close();
            in.close();
            socket.close();
            serverSocket.close();
            socket.close();


        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
