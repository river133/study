package seemygo数据结构_算法.algorithm.并查集;

public class UnionFind_QF extends UnionFind {
    public UnionFind_QF(int capacity) {
        super(capacity);
    }
    //查找v所属的集合(根节点)
    public int find(int v){
        rangeCheck(v);
        return parents[v];
    }

    //合并v1,v2所属的结合
    @Override
    public void union(int v1, int v2) {
        int p1 = find(v1);
        int p2 = find(v2);
        if(p1==p2)return;

        for (int i = 0; i < parents.length; i++) {
            if(parents[i] == p1){
                parents[i] = p2;
            }
        }

    }
}
