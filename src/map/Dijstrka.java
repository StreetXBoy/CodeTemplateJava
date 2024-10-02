package map;

/**
 * @author 重新做人idea基础学习
 * @date 2022-2-23
 */

//不同模板有不同的写法！！！！
public class Dijstrka {
    public static void main(String[] args) {
        int [][] graph = init();
        int []dis = dij(graph,0);
        for(int data :dis){
            System.out.println(data);
        }

    }
    public  static  int[] dij(int [][] graph,int start){
        int n  = graph.length;
        int [] visited = new int[n];
        int [] dis = new int[n];
        for(int i=0;i<n;i++){
            dis[i]=graph[start][i];
        }
        dis[start]=0;
        visited[start]=1;
        for(int k=1;k<n;k++){
            int index = -1;
            int mins = Integer.MAX_VALUE;//千万注意这个max和外面max代表不同切记不能乱来！！！
            for(int i =0;i<n;i++){
                if(dis[i]<mins&&visited[i]==0){
                    index = i;
                    mins = dis[i];
                }
            }
            System.out.println("index   :"+index);
            //dis[index]=mins;没关系的！！！
            visited[index]=1;
            for(int j=0;j<n;j++){
                if(visited[j]==0){
                    dis[j]=Math.min(dis[index]+graph[index][j],dis[j]);//引入dis数组这里必须更新dis数组，否则直接更新矩阵！！！以及大小max的坑点！！！
                }
            }
        }
        return  dis;
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
