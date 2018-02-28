package demo2_selectors;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/**
 * @author fangjiaxiaobai@163.com
 * @date 2018/2/27
 */
public class DemoTest1 {
    
    public static void main(String[] args) throws IOException {
    
        SocketChannel channel=SocketChannel.open();
        Selector selector=Selector.open();
        channel.configureBlocking(false);
        SelectionKey key=channel.register(selector, SelectionKey.OP_READ);
        
        
    
    }
    
}
