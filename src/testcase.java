import java.util.*;
import java.util.zip.CheckedOutputStream;

/**
 * @author 重新做人idea基础学习
 * @date 2022-3-19
 */
public class testcase {
    public static void main(String[] args) {
        int []X={1,1,1};
        int []Y={2,2,2};
        List<Frac> list = new ArrayList<>();
        int m = X.length;
        int n = Y.length;
        for(int i=0;i<m;i++){
            list.add(new Frac(X[i],Y[i]));
        }
        Collections.sort(list,(a,b)->a.x*b.y-a.y*b.x);
        System.out.println(list);
        int size = list.size();
        int count =0;
        int start = 0;
        int end = size-1;
        System.out.println(start);
        System.out.println(end);
        for(int i=0;i<size;i++){
            for(int j=i+1;j<size;j++){
                if(jugeOne(add(list.get(i),list.get(j)))==0)
                count++;
            }
        }
        System.out.println(count%1000000007);
    }

    public  static  int test(){
        try {
            //try 里面throw 一下 抛出异常!!
            throw new RuntimeException("I am RuntimeExecption");
        }catch (Exception e){
            System.out.println(2222);
            e.printStackTrace();
        }finally {
            return  1;
        }
    }


    public  static boolean zoomtest(int n){
        //尴尬 1 既不是质数也是 树 哎。。。。。
        //千万注意了！！！
        for(int i=2;i<=n;i++)
            for(int j=2;j<=n;j++)
                for(int k=2;k<=n;k++){
                    if(i*i+j*j*j+k*k*k*k==n){
                        return  true;
                    }
                }
        return  false;
    }




        public static class Frac{
            int x;
            int y;
            public Frac(int x,int y){
                this.x =x;
                this.y =y;
            }

            @Override
            public String toString() {
                return "Frac{" +
                        "x=" + x +
                        ", y=" + y +
                        '}';
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Frac frac = (Frac) o;
                return x == frac.x && y == frac.y;
            }

            @Override
            public int hashCode() {
                return Objects.hash(x, y);
            }
        }
    public static Frac add(Frac a,Frac b){
        int x = a.x*b.y+b.x*a.y;
        int y = a.y*b.y;
        Frac res = new Frac(x,y);
        return res;
    }

        public static int jugeOne(Frac a){
            return a.x -a.y;
        }
        public  static  boolean isEqual(Frac a,Frac b){
            if(a.x==b.x&&a.y==b.y) return  true;
            else return  false;
        }



    public static  int solution1(int[] A, int X, int Y) {
        int n = A.length;
        int min = Integer.MAX_VALUE;
        for(int start=0;start<n;start++){
            int sum=0;
            for(int j=X;j>=0;j--){
                if(start+j*Y>=n){
                    sum = Integer.MAX_VALUE;
                    break;
                }
                sum+=A[start+j*Y];
            }
            min =Math.min(sum,min);
        }
        return min;
    }
}
