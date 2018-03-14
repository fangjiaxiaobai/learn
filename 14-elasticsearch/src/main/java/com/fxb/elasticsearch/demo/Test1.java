package com.fxb.elasticsearch.demo;


import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.cluster.node.DiscoveryNode;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.io.IOException;
import java.net.InetAddress;
import java.util.List;

/**
 * @author fangjiaxiaobai@163.com
 * @date 2018/2/1
 */
public class Test1 {
    
    public static void main(String[] args) throws IOException {
        Settings settings=Settings.builder().put("cluster.name", "fangjiaxiaobai").build();
        
        TransportClient client=new PreBuiltTransportClient(settings).
            addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
        // 查看集群信息
        searchClusterInfo(client);
        put(client);
        GetResponse getRe=client.prepareGet("test1","ip","1").execute().actionGet();
        System.out.println(getRe.getSourceAsString());
    
    
        client.close();
    }
    
    private static void put(TransportClient client) throws IOException {
        for (int i=0; i < 1; i++) {
            IndexResponse indexResponse=client.prepareIndex("test1", "ip", i+"").setSource(
                XContentFactory.jsonBuilder().startObject()
                    .field("sourceIp", "1.1.1.1")
                    .field("sourcePort", 389).field("destIp", "114.144.114.114")
                    .endObject()).get();
            System.out.println(indexResponse.isCreated());
        }
    }
    
    /**
     * 查看集群信息
     *
     * @param client
     */
    private static void searchClusterInfo(TransportClient client) {
        List<DiscoveryNode> nodes=client.connectedNodes();
        for (DiscoveryNode node : nodes) {
            System.out.println("version:"+node.getVersion());
            System.out.println("hostName:"+node.getHostName());
            System.out.println("hostAddress:"+node.getHostAddress());
        }
    }
    
    
}
