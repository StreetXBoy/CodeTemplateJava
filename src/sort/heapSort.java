package sort;

/**
 * @author 重新做人idea基础学习
 * @date 2024-9-16
 */
public class heapSort {


    public static void main(String[] args) {
        int [] num = {1,7,2,3,-1,0,100,22};
        heapSort(num);
        for(int e:num){
            System.out.println(e);
        }
    }


    public static  void  adjust(int []num ,int index,int n){
        int max = index;
        int left = 2*index+1;
        int right = 2*index+2;
        if(left<n&&num[index]<num[left]){
            max = left;
        }
        if(right<n&&num[index]<num[right]){
            max = right;
        }
        if(max!=index){
            int temp = num[max];
            num[max] = num[index];
            num[index] = temp;
            adjust(num,max,n);
        }
    }

    public static void heapSort(int []num){
        int n = num.length;
        for(int i=n/2-1;i>=0;i--){
            adjust(num,i,n);
        }
        //减少堆大小！！ 相当于冒泡出去！！！
        for(int i=n-1;i>=0;i--){
            int temp = num[0];
            num[0] = num[i];
            num[i] = temp;
            adjust(num,0,i);
        }
    }
}
