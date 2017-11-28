package demos.demo9_20171128;

/**
 * @author fangxiaobai
 * @date 2017/11/28 9:35.
 * @description SemaphoreDemo
 */
public class SemaphoreDemo {
    
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore();
        SendingThread sender = new SendingThread(semaphore);
        RecevingThread recever = new RecevingThread(semaphore);
        sender.start();
        recever.start();
        
    }
    
   static class SendingThread extends Thread{
        Semaphore semaphore = null;
        SendingThread(Semaphore semaphore){
            this.semaphore = semaphore;
        }
        
        @Override
        public void run(){
            while(true){
                System.out.println("take");
                this.semaphore.take();
                try {
                    sleep(200);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    
   static class RecevingThread extends Thread{
        Semaphore semaphore = null;
        public RecevingThread(Semaphore semaphore){
            this.semaphore = semaphore;
        }
        
        @Override
        public void run() {
            try {
                System.out.println("释放。。。。。");
                this.semaphore.release();
                sleep(200);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
