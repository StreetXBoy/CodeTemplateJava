package thread;

import java.text.RuleBasedCollator;

public class Demo2 {
    private static volatile int i = 1;

    public static void main(String[] args) throws Exception {
        final Object obj = new Object();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                synchronized (obj) {
                    for (; i < 10; ) {
                        System.out.println(Thread.currentThread().getName() + " " + (i++));
                        try {
                            obj.notify();
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    obj.notifyAll();
                }
            }
        };

        Thread t1 = new Thread(runnable, "打印偶数的线程 ");
        Thread t2 = new Thread(runnable, "打印奇数的线程 ");
        t1.start();
        t2.start();

    }
}

