package pipe;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * @author fangjiaxiaobai@163.com
 * @date 2018/2/28
 */
public class DemoTest1 {
    
    public static void main(String[] args) throws IOException {
    
        Pipe pipe=Pipe.open();
    
        // 写数据管道
        Pipe.SinkChannel sink=pipe.sink();
        ByteBuffer allocate=ByteBuffer.allocate(128);
        allocate.put("this is a test phare".getBytes());
        allocate.flip();
       while(allocate.hasRemaining()){
           sink.write(allocate);
       }
       sink.close();
    
        Pipe.SourceChannel source=pipe.source();
        ByteBuffer buf=ByteBuffer.allocate(128);
        int read=source.read(buf);  // 读取了多少字节到缓冲区
        
        buf.flip();
        while(buf.hasRemaining()){
            System.out.print((char)buf.get());
        }
        source.close();
    
    }
    
    
}
