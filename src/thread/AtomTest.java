package thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author 重新做人idea基础学习
 * @date 2022-9-04
 */
public class AtomTest {
    public static void main(String[] args) {
        AtomicReference<User>af = new AtomicReference<>();
        User user1 = new AtomTest.User(1,2);
        User user2 = new AtomTest.User(3,4);
        af.set(user1);
        System.out.println(af.get());
        af.compareAndSet(user1,user2);
        System.out.println(af.get());

        System.out.println("---------------------");

        AtomicInteger at = new AtomicInteger(0);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (at.get()!=100){
                    if(at.get()%3==0){
                        System.out.println("A");
                        at.incrementAndGet();
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (at.get()!=100){
                    if(at.get()%3==1){
                        System.out.println("B");
                        at.incrementAndGet();
                    }
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (at.get()!=100){
                    if(at.get()%3==2){
                        System.out.println("C");
                        at.incrementAndGet();
                    }
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();


    }

    static  class  User{
        int data;
        int x;
        public User(int data,int x){
            this.data=data;
            this.x = x;
        }

        @Override
        public String toString() {
            return "User{" +
                    "data=" + data +
                    ", x=" + x +
                    '}';
        }
    }

}
