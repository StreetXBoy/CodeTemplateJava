import com.sun.org.apache.bcel.internal.generic.DMUL;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author 重新做人idea基础学习
 * @date 2022-2-04
 */


//大致知道了！！！
public class k_means_java {
    public static void main(String[] args) {
        K_means(5,3,20);

    }

    public  static  void K_means(int k,int dim,int N){
        Point [] p = new Point[N];
        Cluster[] cls = new Cluster[k];
        for(int i=0;i<N;i++){
            p[i] =new Point(dim);
            for(int j=0;j< dim;j++){
                p[i].arr[j]= Math.random()*10;
            }
        }
        for(int i=0;i<k;i++){
            cls[i] =new Cluster(i,dim);
        }
        for(int i=0;i<k;i++){
            cls[i].center = p[i];
        }

        int count = 0;
        while (true){
            Cluster oldOne = cls[0];
            for(int i=0;i<N;i++){
                int index = -1;
                double mins = 99999;
                for(int j=0;j<k;j++){
                    if(mins>dis(p[i],cls[j].center)){
                        mins = dis(p[i],cls[j].center);
                        index = cls[j].id;
                    }
                }
                if(index == -1) continue;
                int oldid = p[i].cluster_id;
                cls[oldid].del_point(p[i]);
                cls[index].add_point(p[i]);
            }

            for(int j=0;j<k;j++){
                cls[j].countCenter();
            }
            Cluster newOne = cls[0];
//            if(juge(oldOne,newOne)){
//                break;
//            }
            count++;
            if(count>1000) break;
        }
        System.out.println(count);
        for(Cluster c:cls){
            print_Cluster(c);
        }
    }


    static  class Point{
        int dim;
        double []arr;
        int cluster_id=0;
        public  Point(int dim){
            this.dim  = dim;
            this.arr = new double[dim];
        }
        @Override
        public String toString(){
            String str="";
            for(int i=0;i<arr.length;i++)
                str  +=" "+String.valueOf(arr[i]);
            return  str;
        }
    }

    static class Cluster{
        int id;
        Point center;
        List<Point> cl;
        int dim;
        public Cluster(int id,int dim){
            this.id =id;
            cl = new ArrayList<>();
            this.dim = dim;
            center = new Point(dim);
        }
        public void countCenter(){
            int len = cl.size();
            for(int i=0;i<dim;i++){
                double sum = 0;
                for(int j=0;j<len;j++){
                    sum+=cl.get(j).arr[i];
                }
                this.center.arr[i]=sum/len;
            }
        }
        public void add_point(Point x){
            cl.add(x);
            x.cluster_id = id;
        }
        public void del_point(Point x){
            cl.remove(x);
        }

        public void setId(Point x){
            x.cluster_id = id;
        }
    }

    public  static double  dis(Point x, Point y){
        int n = x.arr.length;
        double sum = 0;
        for(int i=0;i<n;i++){
            sum += (double)(x.arr[i]*x.arr[i]+y.arr[i]*y.arr[i]);
        }
        return  Math.sqrt(sum);
    }

    public  static  double diff_arr(List<Point>x,List<Point>y){
        int n = x.size();
        int dim = x.get(0).dim;
        double sum = 0;
        for(int i=0;i<dim;i++)
            for(int j = 0;j<n;j++){
                sum += (x.get(j).arr[i]-y.get(j).arr[i])*(x.get(j).arr[i]-y.get(j).arr[i]);
            }
        return  sum;
    }

    public  static  boolean juge(Cluster oldOne,Cluster newOne){
        if(diff_arr(oldOne.cl,newOne.cl)<0.01){
            return true;
        }else{
            return  false;
        }
    }

    public static void  print_Cluster(Cluster x){
        System.out.println("id: "+x.id);
        System.out.println("Center is: "+x.center);
        for(int i =0;i<x.cl.size();i++){
            System.out.println("-----  "+x.cl.get(i));
        }
    }



}
