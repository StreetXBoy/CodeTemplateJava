package algorithm;

import jdk.management.resource.internal.inst.ThreadRMHooks;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author 重新做人idea基础学习
 * @date 2022-2-23
 */
public class Kruskal {
    //相信自己
    //main方法是一个static方法，class 是一个非静态的内部类，只能被该类的非静态方法访问。否则会报错。 千万注意！！！
    public static void main(String[] args) {
        int m =6;
        int n =5;
        Edge[] e = new Edge[m];
        for(int i=0;i<m;i++){
            e[i] = new Edge();
        }
        e[0].from=0;
        e[0].to=1;
        e[0].w=2;
        e[1].from=1;
        e[1].to=3;
        e[1].w=4;
        e[2].from=0;
        e[2].to=2;
        e[2].w=3;
        e[3].from=2;
        e[3].to=3;
        e[3].w=2;
        e[4].from=0;
        e[4].to=4;
        e[4].w=1;
        e[5].from=3;
        e[5].to=4;
        e[5].w=7;
        UnionSet unionSet = new UnionSet(n);
        Arrays.sort(e,(x,y)->x.w-y.w);
        int v = 0;
        for(int i=0;i<n-1;i++){
            if(unionSet.isUnion(e[i].from,e[i].to)) continue;
            else{
                System.out.println(e[i].from+"--->"+e[i].to);
            }
            v+=e[i].w;
            unionSet.union(e[i].from,e[i].to);
        }
        System.out.println(v);
    }

    static class Edge{
        int from;
        int to;
        int w;
        public Edge(){
            this.from = 0;
            this.to  = 0;
            this.w = 0;
        }
        public Edge(int from ,int to,int w){
            this.from = from;
            this.to  = to;
            this.w = w;
        }
    }
    //为什么加static 原因！！！
    static  class UnionSet{
        int [] roots;
        public  UnionSet(int n){
            roots = new int[n];
            for(int i=0;i<n;i++){
                roots[i]=i;
            }
        }
        public int find(int x){
            if(roots[x]==x) return x;
            //路径压缩！！！
            else return  roots[x]=find(roots[x]);
            //直接find roots[x]是可以的   路径压缩！！
        }

        public boolean isUnion(int x,int y){
            return  find(x)==find(y);
        }
        public void union(int x,int y){
            //解释将x的根y的根链接！！！
            roots[find(x)]=find(y);
        }
    }

}
