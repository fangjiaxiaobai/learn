package demo1_channel;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author fangjiaxiaobai@163.com
 * @date 2018/2/28
 */
public class DemoTest4_server {
    
    
    public static void main(String[] args) throws IOException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3,
            10,1000,
            TimeUnit.MILLISECONDS,new ArrayBlockingQueue<Runnable>(100));
    
        ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();
        
        serverSocketChannel.configureBlocking(false);
        
        serverSocketChannel.bind(new InetSocketAddress(12345));
    
        while (true) {
            SocketChannel socketChannel=serverSocketChannel.accept();
            if (null!=socketChannel) {
                executor.submit(new SocketChannelThread(socketChannel));
            }
        }
        
        
    }
    
    
    private static class SocketChannelThread implements Runnable {
        
        private SocketChannel socketChannel;
        private String remoteName;
        
        public SocketChannelThread(SocketChannel socketChannel) throws IOException {
            this.socketChannel = socketChannel;
            this.remoteName = socketChannel.getRemoteAddress().toString();
            System.out.println(remoteName+" 连接成功");
        }
    
        @Override
        public void run() {
            //  读取发送过来的数据
            ByteBuffer buffer=ByteBuffer.allocate(1024);
            ByteBuffer sizeBuffer=ByteBuffer.allocate(4);
            
            StringBuilder sb = new StringBuilder();
            byte b [];
            while(true){
                try {
                    int read=socketChannel.read(sizeBuffer);
                    if(read!=-1){
                        sb.setLength(0);
                        sizeBuffer.flip();
                        int size = sizeBuffer.getInt();
                        System.out.println("size="+size);
                        int readCount = 0;
                        b = new byte[1024];
                        while(readCount<size){
                            buffer.clear();
                            read = socketChannel.read(buffer);
                            if(read!=-1){
                                readCount += read;
                                buffer.flip();
                                int index = 0;
                                while (buffer.hasRemaining()) {
                                    b[index++] = buffer.get();
                                    if(index >= b.length){
                                        index = 0;
                                        sb.append(new String(b,"utf-8"));
                                    }
                                }
                                if(index>0){
                                    sb.append(new String(b,"UTF-8"));
                                }
                            }
                        }
                        System.out.println(remoteName + ":" +sb.toString());
                    }
                } catch (IOException e) {
                    System.out.println("remoteName : "+remoteName +"   断线了，连接关闭。");
                    try{
                        socketChannel.close();
                    } catch (IOException e1) {
                    }
                    break;
                }
    
    
            }
    
        }
    }
}
