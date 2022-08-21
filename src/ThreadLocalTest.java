import java.lang.reflect.AnnotatedArrayType;

public class ThreadLocalTest {

    static int ans =1;

    public static class MyRunnable implements Runnable {

        private static ThreadLocal<Integer> threadLocal = new ThreadLocal();

        @Override
        public void run() {
            threadLocal.set(ans);
            ans++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadLocal.get());
        }
    }

    public static void main(String[] args) {
        MyRunnable sharedRunnableInstance = new MyRunnable();
        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);
        thread1.start();
        thread2.start();
    }
}