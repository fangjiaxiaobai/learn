package com.fxb.elasticsearch.demo;

import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/**
 * @author fangjiaxiaobai@163.com
 * @date 2018/2/2
 */
public class Test2 {
    
    public static void main(String[] args) throws UnknownHostException {
        Settings se=Settings.builder().put("cluster.name", "fangjiaxiaobai").build();
        TransportClient client=new PreBuiltTransportClient(se).addTransportAddress(new InetSocketTransportAddress(
            InetAddress.getByName("localhost"),9300
        ));
        
    }
    
    
}
