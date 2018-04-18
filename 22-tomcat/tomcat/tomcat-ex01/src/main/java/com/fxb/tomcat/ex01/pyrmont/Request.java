package com.fxb.tomcat.ex01.pyrmont;

import java.io.IOException;
import java.io.InputStream;

/**
 * tomcat - 请求实体
 *
 * @author fangjiaxiaobai@163.com
 * @date 2018-04-16
 */
public class Request {

    private InputStream input;

    private String uri;

    public Request(InputStream input) {
        this.input = input;
    }

    public void parse(){

        StringBuffer request = new StringBuffer(2048);

        int i;

        byte[] buffer = new byte[2048];

        try {
            i = input.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
            i = -1;
        }
        
        for (int j=0;j<i;j++){
            request.append((char)buffer[i]);
        }
        System.out.println(request.toString());
        uri = parseUri(request);

    }

    private String parseUri(StringBuffer request) {
        return null;
    }
}
