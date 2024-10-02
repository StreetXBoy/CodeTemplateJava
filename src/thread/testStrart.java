package thread;

/**
 * @author 重新做人idea基础学习
 * @date 2024-6-20
 */
public class testStrart {

    public  static void main(String []args){
        methoadA();
        System.out.println(methoadA());
        A a = new A();
        a.getE();
        System.out.println(a.getE());
    }



    public static String methoadA(){
        return "1";
    }



    public static class A{
        int e;
        public A(){
            this.e = 10;
        }
        public int getE(){
            return e;
        }
    }
}
