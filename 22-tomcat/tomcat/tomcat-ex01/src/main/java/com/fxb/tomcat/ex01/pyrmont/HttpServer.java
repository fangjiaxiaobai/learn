package com.fxb.tomcat.ex01.pyrmont;


import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * tomcat - HttpServer
 * 代表一个web服务器.
 *
 * @author fangjiaxiaobai@163.com
 * @date 2018-04-16
 */
public class HttpServer {

    /**
     *  静态资源的所在目录。
     *  web服务器能提供WEB_ROOT下的所有子目录的静态资源。
     */
    public static final String WEB_ROOT = System.getProperty("user.dir")+ File.separator +"webRoot";

    /**
     * 停止服务的命令
     * http://localhost:8080/SHUTDOWN
     */
    private static final String SHUTDOWN_COMMAND = "/SHUTDOWN";

    private boolean shutdown = false;

    public static void main(String[] args) {
        HttpServer server = new HttpServer();
        server.await();
    }

    /**
     * 创建一个ServerSocket实例，然后一直循环(除非有SHUTDOWN命令)。
     */
    private void await() {

        ServerSocket serverSocket = null;

        int port = 8080;

        try {
            serverSocket = new ServerSocket(port,1,InetAddress.getByName("127.0.0.1"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        while(!shutdown){

            Socket socket = null;

            InputStream input = null;

            OutputStream output = null;

            try {
                socket = serverSocket.accept();

                input = socket.getInputStream();

                output = socket.getOutputStream();

                // 创建Request
                Request request = new Request();
//                request.parse();

                // 创建Response
                Response response = new Response();
//                response.setRequest(request);
//                request.setStaticResource();
                socket.close();
//                shutdown = request.getUri().equals(SHUTDOWN_COMMAND);

            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }
    }

    @Test
    public void testPrint(){
        System.out.println(System.getProperty("user.dir"));
    }
}
