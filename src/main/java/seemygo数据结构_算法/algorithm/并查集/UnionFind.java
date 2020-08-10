package seemygo数据结构_算法.algorithm.并查集;

public abstract class UnionFind {
    protected int[] parents;

    public UnionFind(int capacity) {
        if(capacity<0){
            throw new IllegalArgumentException("capacity is be > 0");
        }
        //让每个元素构成一个单元素的集合，
        // 然后按一定顺序将属于同一组的元素所在的集合合并
        parents  = new int[capacity];
        for (int i = 0; i < parents.length; i++) {
            parents[i]=i;
        }
        for (int i = 0; i < parents.length; i++) {
            System.out.print(parents[i]+"  ");
        }
    }

    /**
     * 查找v所属的集合(根节点)
     * 时间复杂度0(1)
     * @param v
     * @return
     */
    public abstract int find(int v);
    //合并v1,v2所属的结合
    //时间复杂度0(n)
    public abstract void union(int v1,int v2);

    /**
     * 检查v1、v2是否属于同一个集合
     */
    public boolean isSame(int v1,int v2){
        return find(v1)==find(v2);
    }
    protected void rangeCheck(int v){
        if(v <0 || v >= parents.length){
            throw new IllegalArgumentException("v is not bounds");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < parents.length; i++) {
            sb.append(parents[i]).append("_");
        }
        return sb.toString();
    }
}

