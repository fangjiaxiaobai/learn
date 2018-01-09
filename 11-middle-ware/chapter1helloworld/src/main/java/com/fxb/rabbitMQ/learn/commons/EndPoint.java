package com.fxb.rabbitMQ.learn.commons;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author fangjiaxiaobai
 * @date 2017/12/20
 *  将生产者和消费者，统一为EndPoint类型，不管是生产者还是消费者
 *  队列连接的代码都是一样的。
 */
public class EndPoint {

    protected Channel channel;
    
    protected Connection connection;
    
    protected String endPointName;
    
    public EndPoint(String endPointName) throws IOException, TimeoutException {
        this.endPointName = endPointName;
        ConnectionFactory factory = new ConnectionFactory();
        // 与RabbitMQ server 建立连接
        // 连接的broker(代理)在本机上
        factory.setHost("localhost");
        
        //创建一个连接
        connection = factory.newConnection();
        
        // 创建一个频道
        channel = connection.createChannel();
    
        /**
         *  声明一个队列。存放消息
         *  queue：队列名
         *  durable：是否需要持久化
         *  exclusive： 是否排外，true为队列只可以在本次连接中被访问
         *  autoDelete：true为connection断开 队列自动删除
         *  arguments：用于扩展参数。
         */
        channel.queueDeclare(endPointName,false,false,false,null);
//        channel.exchangeDeclare("exchange","send");
    }
    
    /**
     * 关闭channel和connection。
     *  并非必须，隐含自动调用。
     * @throws IOException
     * @throws TimeoutException
     */
    public void close() throws IOException, TimeoutException {
        channel.close();
        connection.close();
    }
}
