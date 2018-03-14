package demo1_channel;

import com.sun.security.ntlm.Server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 *
 * ServerSocketChannel 简单使用
 *          和DemoTest3配合使用
 * @author fangjiaxiaobai@163.com
 * @date 2018/2/28
 */
public class DemoTest4 {
    
    public static void main(String[] args) throws IOException {
        
        // 创建Channel
        ServerSocketChannel open=ServerSocketChannel.open();
        // 绑定 端口
        open.socket().bind(new InetSocketAddress(2222));
        // 非阻塞模式下
        open.configureBlocking(false);
        while(true) {
            // 等待连接，没有连接的时候，返回的都为null
            SocketChannel accept=open.accept();
            while(accept!=null){
                System.out.println(accept.getRemoteAddress().toString() + "连接成功");
                accept=null;
            }
        }
    
        
    
    }
    
}
