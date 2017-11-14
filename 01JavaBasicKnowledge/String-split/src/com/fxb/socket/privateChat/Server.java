package com.fxb.socket.privateChat;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @create by: wangxiyue on 2017/7/14 17:22.
 * @ClassName:
 * @userfor:
 * @description:
 */
public class Server {

    private static final int SERVER_PORT=30000;

    private static YeeKuMap <String, PrintStream> clients=new YeeKuMap <>();

    public void init(){
        ServerSocket ss=null;
        try {
            ss=new ServerSocket(SERVER_PORT);
            while (true) {
                Socket socket=ss.accept();
                new ServerThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("服务器启动失败，是否端口" + SERVER_PORT + "已被占用?");
        } finally {
            try {
                if (null != ss) {
                    ss.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.exit(1);
        }
    }

    public static void main(String[] args){
        Server server = new Server();
        server.init();
    }
}
