/**
 * @author 重新做人idea基础学习
 * @date 2022-2-28
 */


//为什么需要前缀和
//举个例子：给定 [公式] 个整数，然后进行 [公式] 次询问，每次询问求一个区间内值的和。
//如果用暴力写法，那每次询问都需要从区间左端点循环到区间右端点求和，时间复杂度较大。
//这种时候就可以预先求出该数组的一维前缀和。
public class preSum {
    public static void main(String[] args) {
        int []a = {1,2,3,4,5,6,7,8};
        System.out.println(preSum(a,2,5));

    }

    public  static  int preSum(int []num,int start,int end){
        //preUsm = num[0]+....+num[i]!!
        int n  = num.length;
        int []presum = new int[n];
        presum[0]=num[0];
        for(int i=0;i<n-1;i++){
            presum[i+1]=presum[i]+num[i+1];
        }
        System.out.println(presum[end]);
        System.out.println(presum[start]);
        return presum[end]-presum[start];
    }
}
