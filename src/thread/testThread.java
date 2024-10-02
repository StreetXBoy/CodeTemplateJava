package thread;

public class testThread {
    //感谢你让我成长！！！！

    //分两种情况有flag 和 无 flag
    // https://www.csdn.net/tags/MtzaAgwsNzM5MzctYmxvZwO0O0OO0O0O.html 更容易理解!!!
    static final Object object = new Object();
    public static void main(String[] args) throws InterruptedException {

        new Thread(new Runnable() {
            String a[] = {"a","b"};
            @Override
            public void run() {
                for(int i=0;i< 20 ;i++){
                    //说白了就是一先一后！！！//改正错误
                    synchronized (object){
                        System.out.println(a[i%2]);
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        object.notify();
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            int a[] = {1,2,3};
            @Override
            public void run() {
                for(int i=0;i<20;i++){
                    synchronized (object){
                        System.out.println(a[i%3]);
                        object.notify();
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        }).start();
    }
}
