/**
 * @author 重新做人idea基础学习
 * @date 2022-2-23
 */

//dijsrka 惊人的一致但是不同在于 池化的更新和lowcost的定义！！！
public class Prim {
    public static void main(String[] args) {
        int [][] g =init();
        System.out.println(prim(g));
    }

    public static  int prim(int [][]g){
        int n = g.length;
        int []lowcost = new int[n];
        for(int i=0;i<n;i++){
            lowcost[i]=g[0][i];
        }
        int res = 0;
        for (int k =0;k<n;k++){
            int index = -1;
            int mins = Integer.MAX_VALUE;
            for(int i=0;i<n;i++){
                //大于0必备！！！
                if(mins>lowcost[i]&&lowcost[i]>0){
                    index = i;
                    mins = lowcost[i];
                }
            }
            System.out.println("index"+index);
            if(index == -1) break;
            res +=lowcost[index];
            lowcost[index]=0;
            //称为内部！！！
            for (int j=0;j<n;j++){
                //dij这里是lowcost[j]+g[index][j]
                lowcost[j]=Math.min(lowcost[j],g[index][j]);
            }
        }
        return  res;
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
