package seemygo数据结构_算法.algorithm.跳表;

import java.util.Comparator;

public class SkipList<K,V> {
    private static final int MAX_LEVEL=32;//最高层数
    private static final double P = 0.25;//随机数访问
    private int size;
    private Comparator<K> comparator;
    private int level;//有效层数
    private Node<K,V>first;//空的首节点

    public SkipList() {
        this(null);
    }

    public SkipList(Comparator<K> comparator) {
        this.comparator = comparator;
        first=new Node<>(null,null,MAX_LEVEL);
    }

    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }

    //获取对应key值
    public V get(K key){
        keyCheck(key);
        Node<K,V>node = first;
        for (int i = level-1; i >= 0;i--){
            int cmp = -1;
            while (node.nexts[i] != null && (cmp = compare(key,node.nexts[i].key)) > 0){
                node = node.nexts[i];
            }
            //找到对应元素
            if(cmp == 0)return node.nexts[i].value;
        }
        return null;
    }

    //添加
    public V put(K key,V value){
        keyCheck(key);
        Node<K,V>node = first;
        //保存每一层的前驱节点
        Node<K,V>[]prevs = new Node[level];
        for (int i = level-1; i >= 0;i--){
            int cmp = -1;
            while (node.nexts[i] != null
                    && (cmp = compare(key,node.nexts[i].key)) > 0){
                node = node.nexts[i];
            }
            //节点存在则覆盖
            if(cmp == 0){
                V oldV = node.nexts[i].value;
                node.nexts[i].value = value;
                return oldV;
            }
            prevs[i]=node;//每一层的前驱节点
        }
        //新节点层数
        int newLevel = randomLevel();
        //添加新节点
        Node<K,V> newNode = new Node<>(key,value,newLevel);
        //设置前驱和后继节点
        for (int i = 0; i < newLevel; i++) {
            if(i >= level){
                first.nexts[i] = newNode;
            }else {
                newNode.nexts[i] = prevs[i].nexts[i];
                prevs[i].nexts[i]=newNode;
            }
        }
        size++;
        level = Math.max(level,newLevel);//更新层数

        return null;
    }

    //删除
    public V remove(K key){
        keyCheck(key);
        Node<K,V>node = first;
        //保存每一层的前驱节点
        Node<K,V>[]prevs = new Node[level];
        boolean exist = false;//是否存在
        for (int i = level-1; i >= 0;i--){
            int cmp = -1;
            while (node.nexts[i] != null
                    && (cmp = compare(key,node.nexts[i].key)) > 0){
                node = node.nexts[i];
            }
            prevs[i]=node;//每一层的前驱节点
            if(cmp == 0) exist = true;//代表找到删除的节点
        }
        if(!exist)return null;//未找到节点

        //需要被删除的节点
        Node<K,V> removeNode = node.nexts[0];
        size--;
        //设置前驱和后继节点
        for (int i = 0; i < removeNode.nexts.length; i++) {
            prevs[i].nexts[i] = removeNode.nexts[i];
        }
        //更新跳表层数
        int newLevel = level;
        while (--newLevel >= 0 && first.nexts[newLevel] ==null){
            level = newLevel;
        }
        return removeNode.value;
    }
    //生成随机层数
    private int randomLevel(){
        int level = 1;
        while (Math.random() < P && level <MAX_LEVEL){
            level++;
        }
        return level;
    }

    private void keyCheck(K key){
        if(key==null){
            throw new IllegalArgumentException("key must not be null");
        }
    }

    private int compare(K k1,K k2){
        return comparator != null ? comparator.compare(k1,k2)
                : ((Comparable)k1).compareTo(k2);
    }

    //内部节点
    private static class Node<K,V>{
        K key;
        V value;
        Node<K,V>[]nexts;

        public Node(K key, V value ,int level) {
            this.key = key;
            this.value = value;
            nexts = new Node[level];
        }

        @Override
        public String toString() {
            return key+"："+value+"_层数_"+nexts.length+"   ";
        }
    }
    @Override
    public String toString() {
        StringBuilder sb =new StringBuilder();
        sb.append("总层数："+level+" ").append("\n");
        for (int i = level-1; i >=0; i--) {
            Node<K,V> node = first;
            while (node.nexts[i]!=null){
//                sb.append(node.nexts[i].key);
                sb.append(node.nexts[i]);
                sb.append(" ");
                node=node.nexts[i];
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}

