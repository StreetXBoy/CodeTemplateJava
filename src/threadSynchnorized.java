public class threadSynchnorized {

    private int count = 1;
    private final Object lock = new Object();
    //spring 最大并发 200
    //https://www.cnblogs.com/javastack/p/17756325.html
    // 线程A
    // 加判断条件的交替！！
    private class PrinterA implements Runnable {
        @Override
        public void run() {
            while (count <= 9) { // 假设打印到9
                synchronized (lock) {
                    while (count % 3 != 1) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("thread A: " + count++);
                    lock.notifyAll();
                }
            }
        }
    }

    // 线程B
    private class PrinterB implements Runnable {
        @Override
        public void run() {
            while (count <= 9) {
                synchronized (lock) {
                    while (count % 3 != 2) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("thread B: " + count++);
                    lock.notifyAll();
                }
            }
        }
    }

    // 线程C
    private class PrinterC implements Runnable {
        @Override
        public void run() {
            while (count <= 9) {
                synchronized (lock) {
                    while (count % 3 != 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("thread C: " + count++);
                    lock.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) {
        threadSynchnorized threadSynchnorized = new threadSynchnorized();

        Thread threadA = new Thread(threadSynchnorized.new PrinterA());
        Thread threadB = new Thread(threadSynchnorized.new PrinterB());
        Thread threadC = new Thread(threadSynchnorized.new PrinterC());

        threadA.start();
        threadB.start();
        threadC.start();
    }
}