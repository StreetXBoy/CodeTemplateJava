import java.util.concurrent.locks.LockSupport;

//LOCK SUPPORT D的完美实践！！
public class LockSupportTest {
    public static  Thread a = null;
    public static  Thread b = null;
    public static  Thread c = null;

    public static void main(String[] args) {
        lockSupport();
    }
//LockSupport提供两类静态函数分别是park和unpark，即阻塞与唤醒线程
    // 比sychornized 和 wait notify 更简单的!!!
    // https://cloud.tencent.com/developer/article/1778878 原理 unsafe
    //park 阻碍当前 unpark释放
    // AQS https://tech.meituan.com/2019/12/05/aqs-theory-and-apply.html
    public  static  void  lockSupport(){
        char [] dataOne = "123456".toCharArray();
        char [] dataTwo = "ABCDEF".toCharArray();
        char [] dataThree= "~~~~~~".toCharArray();
        //关键在于先阻塞其他！！！
        a = new Thread(()->{
            for (char val : dataOne){
                System.out.println(Thread.currentThread().getName()+":"+val);
                LockSupport.unpark(b);
                LockSupport.park();
            }
        },"T1");
        b = new Thread(()->{
            for (char val : dataTwo) {
                LockSupport.park();
                System.out.println(Thread.currentThread().getName()+":"+val);
                LockSupport.unpark(c);
            }
        },"T2");

        c= new Thread(()->{
            for (char val : dataThree) {
                LockSupport.park();
                System.out.println(Thread.currentThread().getName()+":"+val);
                LockSupport.unpark(a);
            }
        },"T3");

        a.start();
        b.start();
        c.start();
    }

}