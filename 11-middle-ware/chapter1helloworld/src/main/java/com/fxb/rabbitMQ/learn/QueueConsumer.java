package com.fxb.rabbitMQ.learn;

import com.fxb.rabbitMQ.learn.commons.EndPoint;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;
import org.apache.commons.lang.SerializationUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeoutException;

/**
 * @author fangjiaxiaobai
 * @date 2017/12/20
 */
public class QueueConsumer extends EndPoint implements Runnable,Consumer {
    
    public QueueConsumer(String endPointName) throws IOException, TimeoutException {
        super(endPointName);
    }
    
    /**
     *  当消费者被注册时候被调用
     * @param s
     */
    public void handleConsumeOk(String s) {
    
    }
    
    public void handleCancelOk(String s) {
    
    }
    
    public void handleCancel(String s) throws IOException {
    
    }
    
    public void handleShutdownSignal(String s, ShutdownSignalException e) {
    
    }
    
    public void handleRecoverOk(String s) {
    
    }
    
    /**
     *   获得消息后调用(Delivery:传送，传递。)
     * @param s
     * @param envelope
     * @param basicProperties
     * @param bytes
     * @throws IOException
     */
    public void handleDelivery(String s, Envelope envelope, AMQP.BasicProperties basicProperties, byte[] bytes) throws IOException {
        HashMap message = (HashMap) SerializationUtils.deserialize(bytes);
        System.out.println("消费者接收到消息:"+message.get("message"));
        
    }
    
    public void run() {
        try {
            // 接收消息，
            channel.basicConsume(endPointName,true,this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
