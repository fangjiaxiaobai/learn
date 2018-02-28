package demo1_channel;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 *
 *  使用 FileChannel 简单读写文件
 * @author fangjiaxiaobai@163.com
 * @date 2018/2/28
 */
public class DemoTest2 {
    
    public static void main(String[] args) throws IOException {
//        readData();
    
        writeData();
    
    }
    
    private static void writeData() throws IOException {
        FileChannel channel=new RandomAccessFile("E:/temp/nio/data2.txt","rw").getChannel();
        
        String data = "New String to write to file   "+System.currentTimeMillis();
        
        ByteBuffer buf=ByteBuffer.allocate(48);
        
        buf.clear();
        
        buf.put(data.getBytes());
        
        buf.flip();
        
        while(buf.hasRemaining()){
            channel.write(buf);
        }
        
        channel.close();
    }
    
    private static void readData() throws IOException {
        RandomAccessFile file=new RandomAccessFile("E:/temp/nio/data.txt", "rw");
        FileChannel channel=file.getChannel();
        
        ByteBuffer buf = ByteBuffer.allocate(128);
        int read=channel.read(buf);
        while(read!=-1){
            buf.flip();
            System.out.println("read:"+read);
//            System.out.println(buf.toString());
            while(buf.hasRemaining()){
                System.out.print((char) buf.get());
            }
            System.out.println();
            buf.rewind();
            read = channel.read(buf);
        }
        
        channel.close();
    }
    
}
