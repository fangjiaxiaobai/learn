package demo1_channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 *
 *  UDP --- DatagramChannel 简单使用
 *
 * @author fangjiaxiaobai@163.com
 * @date 2018/2/28
 */
public class DemoTest5 {
    public static void main(String[] args) throws IOException {
        // 创建一个DatagramChannel
        DatagramChannel channel=DatagramChannel.open();
        // 绑定一个端口
        channel.socket().bind(new InetSocketAddress(3455));
        ByteBuffer buf=ByteBuffer.allocate(1024);
        buf.clear();
        buf.flip();
        channel.receive(buf);
        while(buf.hasRemaining()){
            System.out.print(buf.get());
        }
    
    
    }
}
