import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 重新做人idea基础学习
 * @date 2022-4-14
 */
public class test {
    public static void main(String[] args) {
        AtomicInteger ato = new AtomicInteger();
        System.out.println(Solution.partition("aab"));

    }

    static  class Solution {
        static List<List<String>> res = new ArrayList<>();
        public static List<List<String>> partition(String s) {
            int n = s.length();
            List<String> temp = new ArrayList<>();
            dfs(s,0,n,temp);
            return res;
        }

        public static synchronized void dfs(String s, int index, int length, List<String> temp){
            if(index==length){
                res.add(new ArrayList<>(temp));
                return;
            }

            for(int i=index;i<length;i++){
                int start = index;
                int end = i;
                String tempstr = s.substring(start,end+1);
                temp.add(tempstr);
                if(!juge(tempstr)) continue;
                dfs(s,i+1,length,temp);
                temp.remove(temp.size()-1);
            }

        }

        public static boolean juge(String s){
            int n =s.length();
            int start = 0;
            int end = n-1;
            if(end>start) return  false;
            if (start==end) return  true;
            while(start!=end){
                if(s.charAt(start)!=s.charAt(end)) return false;
                start++;
                end--;
            }
            return true;
        }
    }
}
