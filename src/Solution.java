import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 重新做人idea基础学习
 * @date 2022-8-06
 */
public class Solution {
        public static int solution(String S, int B) {
            int n = S.length();
            List<Integer> list =new ArrayList<>();
            for(int i=0;i<n;i++){
                int start =i;
                while(i<n&&S.charAt(i)=='X'){
                    i++;
                }
                int end = i;
                if(start!=end){
                    list.add(end-start+1);
                }
            }
            Collections.sort(list);
            System.out.println(list);
            if(list.size()==0) return 0;
            int ans = 0;
            for(int i=list.size()-1;i>=0;i--){
                if(B>=list.get(i)){
                    B -=list.get(i);
                    ans+=list.get(i)-1;
                }else{
                    ans +=B-1;
                    break;
                }
            }
            return ans;
        }

    public static void main(String[] args) {
        System.out.println(solution("X.X.XX", 4));
    }
}
