package demo1_channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 *  TCP -- SocketChannel 简单使用
 *          和DemoTest4 配合使用。
 *       目前不是一个好的栗子，日后再补。
 *
 * @author fangjiaxiaobai@163.com
 * @date 2018/2/28
 */
public class DemoTest3 {
    
    
    public static void main(String[] args) throws IOException {
//        readData1();
    
        SocketChannel channel=SocketChannel.open(new InetSocketAddress(2222));
        channel.configureBlocking(false);
        String data = "ByteBuffer.allocate(1024)";
        
        ByteBuffer buf=ByteBuffer.allocate(1024);
        buf.put(data.getBytes());
        
        buf.flip();
        while (buf.hasRemaining()) {
            channel.write(buf);
        }
        
        channel.close();
    }
    
    private static void readData1() throws IOException {
        Charset charset = Charset.forName("GBK");
        SocketChannel channel=SocketChannel.open();
        channel.connect(new InetSocketAddress("www.baidu.com",80));
        
        ByteBuffer buf=ByteBuffer.allocate(128);
        int read=channel.read(buf);
        channel.write(charset.encode("GET " + "/ HTTP/1.1" + "\r\n\r\n"));
        //step3:读取数据
        ByteBuffer buffer = ByteBuffer.allocate(1024);// 创建1024字节的缓冲
        while (channel.read(buffer) != -1) {
            buffer.flip();// flip方法在读缓冲区字节操作之前调用。
            System.out.println(charset.decode(buffer));
            // 使用Charset.decode方法将字节转换为字符串
            buffer.clear();// 清空缓冲
        }
        
        channel.close();
    }
}
