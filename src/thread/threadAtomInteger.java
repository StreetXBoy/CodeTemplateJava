package thread;

import java.util.concurrent.atomic.AtomicInteger;

public class threadAtomInteger {

    private int count = 1;
    private final Object lock = new Object();
    private AtomicInteger a = new AtomicInteger(0);

    // 线程A
    private class PrinterA implements Runnable {
        @Override
        public void run() {
            while (a.get()<=10){
                if(a.get()%3==0){
                    System.out.println("thread a is:"+a.get());
                    a.incrementAndGet();
                }
            }
        }
    }

    // 线程B
    private class PrinterB implements Runnable {
        @Override
        public void run() {
            while (a.get()<=10){
                if(a.get()%3==1){
                    System.out.println("thread b is:"+a.get());
                    a.incrementAndGet();
                }
            }
        }
    }

    // 线程C
    private class PrinterC implements Runnable {
        @Override
        public void run() {
            while (a.get()<=10){
                if(a.get()%3==2){
                    System.out.println("thread c is:"+a.get());
                    a.incrementAndGet();
                }
            }
        }
    }

    public static void main(String[] args) {
        threadAtomInteger threadSynchnorized = new threadAtomInteger();

        Thread threadA = new Thread(threadSynchnorized.new PrinterA());
        Thread threadB = new Thread(threadSynchnorized.new PrinterB());
        Thread threadC = new Thread(threadSynchnorized.new PrinterC());

        threadA.start();
        threadB.start();
        threadC.start();
    }
}