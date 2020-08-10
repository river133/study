package seemygo数据结构_算法.algorithm.graph;

import java.util.List;

public interface Graph<V,E> {
    int edgesSize();//边的数量
    int verticesSize();//顶点数量

    void addVertex(V v);//顶点
    void addEdge(V from, V to);//边
    void addEdge(V from, V to, E weight);

    void removeVertex(V v);
    void removeEdge(V from, V to);

    void bfs(V begin, VertexVisitor<V>visitor);//广度优先
    void dfs(V begin, VertexVisitor<V>visitor);//深度优先_递归
    void dfs2(V begin, VertexVisitor<V>visitor);//深度优先_非递归

    interface VertexVisitor<V>{//遍历接口
        boolean visit(V v);
    }
    //拓扑排序
    List<V> topologicalSort();
}
