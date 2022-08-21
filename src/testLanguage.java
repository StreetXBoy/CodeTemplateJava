import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 重新做人idea基础学习
 * @date 2022-2-24
 */
public class testLanguage {

    public static void main(String[] args) {
        int [][] a= {{1,2},{3,4},{-1,9}};
        Arrays.sort(a,(x,y)->x[0]-y[0]);
        //牢记！！！！
        Arrays.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        for(int []data :a){
            System.out.println(data[0]+" "+data[1]);
        }


        System.out.println(mySqrt(1000000));
    }


    public static  int mySqrt(int x) {
        int start = 1;
        int end = x;
        while((end-start)>1){
            System.out.println(start);
            System.out.println(end);
            int mid = (start+end)/2;
            if(mid*mid ==x){
                return mid;
            }else  if(mid*mid>x){
                end--;
            }else{
                start++;
            }
        }
        return start;
    }





}
