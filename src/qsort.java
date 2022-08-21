import java.util.Arrays;
import java.util.LinkedHashMap;

/**
 * @author 重新做人idea基础学习
 * @date 2022-2-10
 */
public class qsort {
    public static void main(String[] args) {
        int [] a={-1,8,-2,88,100,3,4,6,-9};
        sort(a,0,a.length-1);
        for(int aa:a){
            System.out.println(aa);
        }

    }
    //记忆！！！！
    public  static  void QKSourt(int[] a, int start, int end) {
        if (a.length < 0){
            return ;
        }
        if (start >= end){
            return ;
        }
        int left = start;
        int right = end;
        int temp = a[left];
        while (left < right){
            while (left < right && a[right] >= temp){
                right -- ;
            }
            a[left] = a[right];
            while (left < right && a[left] <= temp){
                left ++ ;
            }
            a[right] = a[left];
        }
        a[left] = temp;
        QKSourt(a, start, left -1);
        QKSourt(a,left+1,end);
    }

    public  static  int partition(int []num ,int start,int end){
        int key = num[start];
        int i = start;
        int j = end;
        while (i<j){
            while (i<j&&num[j]>=key) j--;
            num[i]=num[j];
            while (i<j&&num[i]<=key) i++;
            num[j]=num[i];
        }
        num[i]=key;
        return i;
    }


    public  static void sort(int []num,int start,int end){
        if(start<end){
            int key =  partition(num,start,end);
            sort(num,start,key-1);
            sort(num,key+1,end);
        }
    }








}
