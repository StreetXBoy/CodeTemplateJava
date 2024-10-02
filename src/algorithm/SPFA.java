package algorithm;

import java.util.LinkedList;
import java.util.Queue;
//刷题时直接.util.*就完事！！！

/**
 * @author 重新做人idea基础学习
 * @date 2022-2-23
 */


//以后用spfa！！！更好！！！简单！！！ 其实就是bfs一种！！！
public class SPFA {
    public static void main(String[] args) {
        int [][] g =init();
        int []dis =spfa(g,0);
        for(int data :dis){
            System.out.println(data);
        }
    }

    //可以看成是bfs的一种
    public static int[]  spfa(int[][] g, int start){
        Queue<Integer> q= new LinkedList<>();
        int n = g.length;
        int []dis =new int[n];
        int []count = new int[n];
        for(int i=0;i<n;i++){
            dis[i]=3000;
        }
        //dis赋值最大
        dis[start]=0;
        q.offer(start);
        while (q.size()!=0){
            int cur = q.poll();
            System.out.println("q--->"+cur);
            for(int i=0;i<n;i++){
                if(dis[i]>dis[cur]+g[cur][i]){
                    dis[i]=dis[cur]+g[cur][i];
                    //反复更新dis[i]更新完后反复入队！！！
                    q.offer(i);
                    count[i]++;
                    //为什么最多n-1次全部看成一个换 更新最多n次也更新完了！！！
                    //判断负环
                    if(count[i]>=n){
                        System.out.println("error negative cur");
                        return  new int[]{};
                    }
                }
            }
        }
        return dis;

    }


    public  static int[][] init(){
        int MAX =3000;
        int graph[][] = {
                {0,2,3,MAX,MAX,MAX},
                {2,0,MAX,4,MAX,MAX},
                {3,MAX,0,2,MAX,MAX},
                {MAX,4,2,0,7,MAX,},
                {MAX,MAX,MAX,7,0,10},
                {MAX,MAX,MAX,MAX,10,0}
        };
        return graph;
    }



}
