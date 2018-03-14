package demo1_channel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author fangjiaxiaobai@163.com
 * @date 2018/2/27
 */
public class DemoTest1 {
    public static void main(String[] args) throws IOException {
//        demo1();

//        demo2_fail();
        
        RandomAccessFile fromFile = new RandomAccessFile("E:/temp/nio/fromFile.txt","rw");
        FileChannel fromChannel=fromFile.getChannel();
    
        RandomAccessFile toFile=new RandomAccessFile("E:/temp/nio/toFile.txt", "rw");
        FileChannel toChannel=toFile.getChannel();
        long position = toChannel.size();
        long count = fromChannel.size();
//        toChannel.transferFrom(fromChannel,position,count);
        fromChannel.transferTo(position,count,toChannel);
        fromChannel.close();
        toChannel.close();
        fromFile.close();
        toFile.close();
    
    }
    
    private static void demo2_fail() throws IOException {
        RandomAccessFile aFile=new RandomAccessFile("E:/temp/nio/data.txt", "rw");
        FileChannel channel=aFile.getChannel();
        ByteBuffer header=ByteBuffer.allocate(128);
        ByteBuffer body=ByteBuffer.allocate(1024);
        ByteBuffer[] bufferArray={header, body};
        long read=channel.read(bufferArray);
        
        
        while (read != -1) {
            System.out.println("read:" + read);
            header.flip();
            while (header.hasRemaining()) {
                System.out.print((char) header.get());
            }
           
           read = channel.read(bufferArray);
        }
    }
    
    private static void demo1() throws IOException {
        RandomAccessFile aFile=new RandomAccessFile("E:/temp/nio/data.txt", "rw");
        FileChannel inChannel=aFile.getChannel();
        ByteBuffer buf=ByteBuffer.allocate(256);
        
        int bytesRead=inChannel.read(buf);
        while (bytesRead != -1) {
            System.out.println("read " + bytesRead);
            buf.flip();
            
            while (buf.hasRemaining()) {
                System.out.print((char) buf.get());
            }
            buf.clear();
            bytesRead=inChannel.read(buf);
        }
        aFile.close();
    }
}
