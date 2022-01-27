/**
 * @author 重新做人idea基础学习
 * @date 2022-2-27
 */


//关键理解next数组和记忆！！！
public class Kmp {
    public static void main(String[] args) {
        String s = "abbabbbbcab";
        String ss = "babbb";
        System.out.println(kmp(s,ss));

    }


    public  static  int kmp(String str1,String str2){
        int []next = getNext(str2);
        int i=0;
        int j=0;
        while (i<str1.length()&&j<str2.length()) {
            if(j==-1||str1.charAt(i)==str2.charAt(j)){
                i++;
                j++;
            }else{
                j = next[j];
            }
        }
        if(j<str2.length()) return -1;
        else  return i-str2.length();//开始的位置!!!

    }

    public static  int []getNext(String str){
        int []next = new int[str.length()];
        next[0]=-1;
        int i=0;
        int j=-1;
        //这里的ij含义 : i 后缀 j是前缀
        while(i<str.length()-1){
            if(j==-1||str.charAt(i)==str.charAt(j)){
                i++;
                j++;
                next[i]=j;
                //why?str.length-1!!因为这个地方越界！！
            }else{
                j = next[j];
            }
        }
        return  next;
    }






}
