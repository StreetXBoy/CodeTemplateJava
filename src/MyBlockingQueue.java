
import java.util.LinkedList;
import java.util.Random;


//字节和米哈游都用类似的考察！！！

public class MyBlockingQueue<E> implements Queue<E> {

    private final int maxSize;
    private final LinkedList<E> elementQueue = new LinkedList<>();
    private final static int DEFAULT_MAX_SIZE = 10;

    /**
     * 阻塞队列中最多可以装入的元素数量
     * @param maxSize
     */
    public MyBlockingQueue(int maxSize) {
        this.maxSize = maxSize;
    }

    public MyBlockingQueue() {
        this(DEFAULT_MAX_SIZE);
    }

    /**
     * 如果阻塞队列内部的容器元素大于或者等于maxSize,此时等待消费者将元素
     * 取出
     * @param e 放入阻塞队列中的元素
     */
    @Override
    public void offer(E e) {
        synchronized (elementQueue) {
            if (elementQueue.size() >= maxSize) {
                try {
                    console(null, "wait");
                    //理解就是在lock 里面 wait就是阻塞 notify 就是 唤醒！！
                    elementQueue.wait();
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
            elementQueue.addLast(e);
            console(e, "offer");
            elementQueue.notifyAll();
        }
    }

    /**
     * 如果内部容器是空的,等待消费者生产元素。
     * 无论是添加还是获取元素的操作,在哪之后都需要
     * 主动调用notifyAll,让等待取消
     * @return
     */
    @Override
    public E take() {
        synchronized (elementQueue) {
            if(elementQueue.isEmpty()) {
                try {
                    console(null, "wait");
                    elementQueue.wait();
                    //达到限制之后也是wait!!1
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            E e = elementQueue.removeFirst();
            console(e, "take");
            elementQueue.notifyAll();
            return e;
        }
    }

    @Override
    public int size() {
        synchronized (elementQueue) {
            return elementQueue.size();
        }
    }

    public void console(E e, String flag) {
        System.out.println(Thread.currentThread().getName() + ":" +flag + ":" + e);
    }

    public static void main(String[] args) {
        MyBlockingQueue<Integer> blockingQueue = new MyBlockingQueue<>();
        new Thread(() -> {
            for(;;) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                blockingQueue.offer(new Random().nextInt());
            }
        }, "product1").start();

        new Thread(() -> {
            for(;;) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                blockingQueue.offer(new Random().nextInt());
            }
        }, "product2").start();

        new Thread(() -> {
            for(;;) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                blockingQueue.offer(new Random().nextInt());
            }
        }, "product3").start();

        new Thread(() -> {
            for(;;) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                blockingQueue.take();
            }
        }, "consumer").start();
    }
}
