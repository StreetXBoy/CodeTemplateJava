package thread;

/**
 * @author 重新做人idea基础学习
 * @date 2022-2-12
 */
public class ThreaPractice {
    public static void main(String[] args) {
        myThread thread1 = new myThread();
        thread1.run();
    }

    static class myThread extends Thread{
        @Override
        public  void run(){
            System.out.println(Thread.currentThread());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread());
        }
    }
}
