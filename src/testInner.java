/**
 * @author 重新做人idea基础学习
 * @date 2022-8-28
 */
public class testInner {
    public static void main(String[] args) {
        people p1 = new testInner.people(); //这样调用真的坑！！！！ 老是不会！！ 学习做！！！！
        System.out.println(p1);
        p1.data=222;
        p1.id=3;
        System.out.println(p1);
        people p2 = new testInner.people();
        System.out.println(p2);

    }


    public static class people{
        int data;
        int id;
        public people(){
            this.data=0;
            this.id=0;
        }

        @Override
        public String toString() {
            return "people{" +
                    "data=" + data +
                    ", id=" + id +
                    '}';
        }
    }
}
