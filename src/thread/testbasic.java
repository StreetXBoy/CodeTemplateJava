package thread;

/**
 * @author 重新做人idea基础学习
 * @date 2024-8-10
 */

// 挑战自己
public class testbasic {
    public static  int count =0;
    public static void main(String[] args) {

        String s ="12324";

        char[] str =s.toCharArray();


        Object obj = new Object();

        Thread t1 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    synchronized (obj) {
                        System.out.println("x1:"+count);
                        count++;
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        obj.notifyAll();
                    }
                }
            }
        }; //交互!!!
        Thread t2 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    synchronized (obj) {
                        System.out.println("x2:"+count);
                        count++;
                        obj.notifyAll();
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        t1.start();
        t2.start();
    }
}
