package map;

/**
 * @author 重新做人idea基础学习
 * @date 2022-2-24
 */


//相信Floyd！！！！！
public class Flyord {
    public static void main(String[] args) {

        int [][] g =init();
        int [][] res = flyord(g);
        System.out.println(res[0][5]);
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

    public  static  int[][] flyord(int [][] graph){
        int n =graph.length;
        int MAX =3000;
        for(int k=0;k<n;k++)
            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++){
                    graph[i][j]=Math.min(graph[i][j],graph[i][k]+graph[k][j]);//原理就是固定中间节点池化！！！
                }
        return  graph;
    }
}
