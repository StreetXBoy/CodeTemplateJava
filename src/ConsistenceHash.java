import java.util.*;

/**
 * 一致性Hash
 * @author zhongguangxi
 */
public class ConsistenceHash {

    // 物理节点集合
    private List<String> realNodes = new ArrayList<>();
    // 虚拟节点数，用户指定
    private int viretalNums = 100;
    // 物理节点与虚拟节点的对应关系存储
    private Map<String,List<Integer>> real2VirtualMap = new HashMap<>();
    // 排序存储结构红黑树，key是虚拟节点的hash值，value是物理节点
    private SortedMap<Long,String> sortedMap = new TreeMap<>();

    //注意啊---------------------------！

    public ConsistenceHash(int viretalNums) {
        super();
        this.viretalNums = viretalNums;
    }

    public ConsistenceHash() {
        super();
    }

    /**
     * 添加物理节点
     * @param node
     */

    //https://blog.csdn.net/tiantian929/article/details/123127303!!!


    //https://zhuanlan.zhihu.com/p/482549860本质理解！！！
    public void addService(String node){
        String vnode = null;
        int i = 0;
        for (int count=0;count<viretalNums;){
            i++;
            vnode = node+"-"+i;
            long hashValue = FNV1_32_HASH.hash(vnode);
            if (!this.sortedMap.containsKey(hashValue)){
                count++;
                this.sortedMap.put(hashValue,node);
            }
        }
        this.realNodes.add(node);
    }

    /**
     * 删除物理节点
     * @param node
     */
    public void removeService(String node){
        realNodes.remove(node);
        for(int i=0;i<viretalNums;i++){
            long hashnode = FNV1_32_HASH.hash(node+"-"+i);
            this.sortedMap.remove(hashnode);
        }
    }

    /**
     * 获取数据的存取节点
     * @param key
     * @return
     */


    //tailMap(K fromKey) 方法用于返回此映射，其键大于或等于fromKey的部分视图。返回的映射受此映射支持，因此改变返回映射反映在此映射中，反之亦然。
    //TreeMap的完美应用！！
    public String getService(String key){
        long hash = FNV1_32_HASH.hash(key);
        SortedMap<Long,String> map = this.sortedMap.tailMap(hash);
        if (map.isEmpty()){
            return this.sortedMap.get(sortedMap.firstKey());
        }else{
            return map.get(map.firstKey());
        }
    }




    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        ConsistenceHash consistenceHash = new ConsistenceHash();
        consistenceHash.addService("193.168.1.10");
        consistenceHash.addService("193.168.1.11");
        consistenceHash.addService("193.168.1.12");
        consistenceHash.removeService("193.168.1.12");
        for (int i =0;i<100;i++){
            System.out.println("a"+i+" 对应的服务器："+consistenceHash.getService("a"+i));
        }
    }






    public static  class FNV1_32_HASH {
        public static int hash(String str) {
            final int p = 16777619;
            int hash = (int) 2166136261L;
            for (int i = 0; i < str.length(); i++)
                hash = (hash ^ str.charAt(i)) * p;
            hash += hash << 13;
            hash ^= hash >> 7;
            hash += hash << 3;
            hash ^= hash >> 17;
            hash += hash << 5;

            // 如果算出来的值为负数则取其绝对值
            if (hash < 0)
                hash = Math.abs(hash);
            return hash;
        }
    }


}
