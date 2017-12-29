package com.fxb.rabbitMQ.learn;

import com.fxb.rabbitMQ.learn.commons.EndPoint;
import org.apache.commons.lang.SerializationUtils;

import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.TimeoutException;

/**
 * @author fangjiaxiaobai
 * @date 2017/12/20
 */
public class Producer extends EndPoint {
    
    public Producer(String endPointName) throws IOException, TimeoutException {
        super(endPointName);
    }
    
    /***
     * 发布一条消息
     * @param object
     * @throws IOException
     */
    public void sendMessage(Serializable object) throws IOException {
        channel.basicPublish("",endPointName,null, SerializationUtils.serialize(object));
    }
    
}
