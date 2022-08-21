/**
 * @author 重新做人idea基础学习
 * @date 2022-mergeSort-12
 */
public class MergeSort {
    public static void main(String[] args) {

    }

    //思路不对被误导！！！
    //没有在原来数组做！！！
//    public  static  void mergeSort(int []dst,int []num,int start ,int end){
//        if(start+1>=end) return;
//        int mid = (start+end)/2;
//        mergeSort(dst,num,start,mid);
//        mergeSort(dst,num,mid,end);
//        int i = start;
//        int j = mid;
//        int k=i;
//        while (i<mid||j<end){
//            if(j==end||(i<mid&&num[i]<num[j])){
//                dst[k++]=num[i++];
//            }else{
//                dst[k++]=num[j++];
//            }
//        }
//    }


    public  void merge(int left,int mid,int right,int []arr,int []temp){
        int i=left;
        int j=mid+1;
        int k=left;
        while (i<=mid&&j<=right){
            if(arr[i]>=arr[j]){
                temp[k++]=arr[j++];
            }else{
                temp[k++]=arr[i++];
            }
        }
        while (i<=mid) temp[k++]= arr[i++];
        while (j<=right) temp[k++]= arr[j++];
        //复制回去!!
        for(int m=left;m<=right;m++){
            arr[m]=temp[m];
        }
    }

    public  void mergetSort(int []num,int start,int end,int []temp){
        if(start<end){
            int mid = (start+end)/2;
            mergetSort(num,start,mid,temp);
            mergetSort(num,mid+1,end,temp);
            merge(start,mid,end,num,temp);
        }
    }
}
