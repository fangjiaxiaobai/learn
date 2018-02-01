package com.fxb.elasticsearch.demo;


import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.cluster.node.DiscoveryNode;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Set;

/**
 * @author fangjiaxiaobai@163.com
 * @date 2018/2/1
 */
public class Test1 {
    
    public static void main(String[] args) throws UnknownHostException {
        Settings settings=Settings.builder().put("cluster.name", "fangjiaxiaobai").build();
    
        TransportClient client=new PreBuiltTransportClient(settings).
            addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
        // 查看集群信息
        List<DiscoveryNode> nodes=client.connectedNodes();
        for (DiscoveryNode node : nodes) {
            Set<DiscoveryNode.Role> roles=node.getRoles();
            System.out.println(roles);
            System.out.println(node.getHostName());
            System.out.println(node.getHostAddress());
        }
    
        client.close();
        
//        InetAddress byAddress=InetAddress.getByName("127.0.0.1");
//        System.out.println(byAddress.getHostAddress());
    }
    
    
    
    
}
