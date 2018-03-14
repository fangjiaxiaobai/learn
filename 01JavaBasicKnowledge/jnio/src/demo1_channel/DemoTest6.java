package demo1_channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * @author fangjiaxiaobai@163.com
 * @date 2018/2/28
 */
public class DemoTest6 {
    
    public static void main(String[] args) throws IOException {
    
        DatagramChannel open=DatagramChannel.open();
        open.socket().bind(new InetSocketAddress(3456));
    
        ByteBuffer buf=ByteBuffer.allocate(1024);
        buf.put("DatagramChannel open=DatagramChannel.open()".getBytes());
//        buf.flip();
        open.send(buf,new InetSocketAddress("127.0.0.1",3455));
    }
}
