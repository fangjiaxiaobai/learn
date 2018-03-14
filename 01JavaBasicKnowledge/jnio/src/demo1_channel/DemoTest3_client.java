package demo1_channel;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * @author fangjiaxiaobai@163.com
 * @date 2018/2/28
 */
public class DemoTest3_client {
    
    public static void main(String[] args) throws IOException {
    
        SocketChannel channel=SocketChannel.open(new InetSocketAddress(12345));
    
        while (true) {
            String next = new Scanner(System.in).next();
            sendMesage(channel,next);
        }
    
    }
    
    private static void sendMesage(SocketChannel channel, String message) {
        
        if(message==null || message.isEmpty()){
            return ;
        }
    
        try {
            byte[] bytes=message.getBytes("utf-8");
            int size=bytes.length;
            ByteBuffer buffer=ByteBuffer.allocate(size);
            ByteBuffer sizeBuffer=ByteBuffer.allocate(4);
            
            sizeBuffer.putInt(size);
            buffer.put(bytes);
            
            buffer.flip();
            sizeBuffer.flip();
            
            ByteBuffer dest[] = {sizeBuffer,buffer};
            while (sizeBuffer.hasRemaining() || buffer.hasRemaining()) {
                channel.write(dest);
            }
    
    
        } catch (IOException e) {
            try {
                channel.close();
            } catch (IOException e1) {
            
            }
        }
    
    
    }
    
    
}
