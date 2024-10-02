package tree;
//相信自己！！
/**
 * @author 重新做人idea基础学习
 * @date 2022-7-16
 */
public class Tire {
    public static void main(String[] args) {
        MyTree tree = new MyTree();
        tree.add("a");
        tree.add("ab");
        tree.add("abc");
        tree.add("abcfg");
        System.out.println(tree.query("abcfg"));
        System.out.println(tree.query("abc"));
        System.out.println(tree.startwith("abcfg"));



    }

    //相信自己可以的！！！
    public  static class  MyTree{
        private  Node Treeroot;
        public class  Node{
            char val;
            boolean end;
            Node [] child =new Node[26];
        }
        public MyTree(){
            Treeroot = new Node();
        }

        public void add(String s){
            Node root = this.Treeroot;
            char [] str = s.toCharArray();
            for(int i=0;i<str.length;i++){
                int index = str[i]-'a';
                if(root.child[index]==null){
                    root.child[index] = new Node();
                    root.child[index].val = str[i];
                }
                root =root.child[index];
            }
            root.end =true;//end的 意思在于 标志最后！！！
        }


        public  boolean search(String s){
            Node root = this.Treeroot;
            char []str = s.toCharArray();
            for(int i=0;i<str.length;i++){
                int index = str[i]-'a';
                if(root.child[index]==null) return false; //只要是空就是false！！
                root = root.child[index];
            }
            return  true;
        }

        public boolean startwith(String s){
            Node root = this.Treeroot;
            char []str = s.toCharArray();
            for(int i=0;i<str.length;i++){
                int index = str[i]-'a';
                if(root.child[index]==null) return false; //只要是空就是false！！
                root = root.child[index];
            }
            return  true;
        }


        //https://leetcode.cn/problems/longest-word-in-dictionary/!!!
        public boolean query(String s){
            Node root = this.Treeroot;
            char []str = s.toCharArray();
            for(int i=0;i<str.length;i++){
                int index = str[i]-'a';
                if(root.child[index]==null||!root.child[index].end) return false; //只要是空就是false！！ end来判断是不是逐步构成的！！！！
                root = root.child[index];
            }
            return  root!=null&&root.end;
        }



    }
}
