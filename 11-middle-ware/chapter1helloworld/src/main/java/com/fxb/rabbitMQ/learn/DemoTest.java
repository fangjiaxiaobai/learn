package com.fxb.rabbitMQ.learn;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeoutException;

/**
 * @author fangjiaxiaobai
 * @date 2017/12/20
 */
public class DemoTest {
    public static void main(String[] args) throws IOException, TimeoutException {
        QueueConsumer queueConsumer = new QueueConsumer("queue");
        Thread consumerThread = new Thread(queueConsumer);
        consumerThread.start();
        
        Producer producer = new Producer("queue");
        
        for (int i=0;i<20;i++){
            HashMap<String, Integer> message = new HashMap<String, Integer>();
            message.put("message",i);
            producer.sendMessage(message);
            System.out.println("生产者发送消息:"+i);
        }
        
    }
}
