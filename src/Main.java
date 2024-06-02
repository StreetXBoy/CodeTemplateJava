import java.util.*;
public class Main{
    static int max =Integer.MAX_VALUE;
    public static void main(String []args){
        Scanner in = new Scanner(System.in);
        String s = "?12?0?9??";
        StringBuilder sb =new StringBuilder();
        dfs(s,0,sb);
        System.out.println(max);

    }
    public static void dfs(String s,int index,StringBuilder sb){
        if(index==s.length()){
            String str = String.valueOf(sb);
            int flag=1;
            for(int i=0;i<str.length();i++){
                if(i<str.length()-1&&str.charAt(i)==str.charAt(i+1)){
                    flag=0;
                    break;
                }
            }
            if(flag==1){
                int num = Integer.parseInt(str);
                System.out.println(num);
                if(num%3==0) max = Math.min(max,num);
            }
            sb = new StringBuilder();
            return;
        }
        if(s.charAt(index)=='?'){
            for(int i=1;i<=9;i++){
                sb.append(i);
                dfs(s,index+1,sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }
        else{
            sb.append(s.charAt(index));
            dfs(s,index+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }


    }


}