package seemygo数据结构_算法.algorithm.并查集;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GenericUnionFind<V> {
    Map<V,Node<V>> nodes = new HashMap();

    //初始化集合
    public void makeSet(V v){
        if(nodes.containsKey(v))return;
        Node<V> node = new Node<V>(v);
        nodes.put(v,node);

    }
    //找到v的根节点
    private Node<V>findNode(V v){
        Node<V> node = nodes.get(v);
        if(node == null) return null;
        while (!Objects.equals(node.value,node.parent.value)){
            //路径压缩方式：Path Halving
            node.parent = node.parent.parent;
            node = node.parent;
        }
        return node;
    }
    //查找节点的Student属性
    public V find(V v){
        Node<V> node = findNode(v);
        return node==null?null:node.value;
    }

    //合并v1,v2所属的结合
    public void union(V v1, V v2) {
        Node<V> p1 = findNode(v1);
        Node<V> p2 = findNode(v2);
        if(p1==null || p2==null)return;
        if(Objects.equals(p1.value,p2.value)) return;
        V value = p1.value;
        V value2 = p2.value;

        //rank优化
        if(p1.rank < p2.rank){
            p1.parent = p2;
        }else if(p1.rank > p2.rank){
            p2.parent =  p1;
        }else {
            p1.parent = p2;//左边合并到右边
            p2.rank += 1;//更新高度
        }
    }
    public boolean isSame(V v1,V v2){
        return Objects.equals(find(v1),find(v2));
    }
    //内部节点
    private static class Node<V>{
        V value;
        Node<V> parent = this;
        int rank = 1;//节点高度

        public Node(V value) {
            this.value = value;
        }
    }
}
