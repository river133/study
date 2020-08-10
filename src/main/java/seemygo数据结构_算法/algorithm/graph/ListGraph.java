package seemygo数据结构_算法.algorithm.graph;

import java.util.*;

public class ListGraph<V,E>  implements Graph<V,E> {
    //顶点
    private static class Vertex<V,E>{
        V value;//顶点参数
        Set<Edge<V,E>> inEdges = new HashSet<>();//(入度)
        Set<Edge<V,E>> outEdges = new HashSet<>();//(出度)

        public Vertex(V value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            return Objects.equals(value,((Vertex<V,E>)obj).value);
        }

        @Override
        public int hashCode() {
            return value == null ? 0 : value.hashCode();
        }

        @Override
        public String toString() {
            return value==null?"null":value.toString();
        }
    }
    //边
    private static class Edge<V,E>{
        Vertex<V,E> from; //边上的顶点
        Vertex<V,E> to;//边上的顶点
        E weight;//边的权值

        public Edge(Vertex<V, E> from, Vertex<V, E> to) {
            this.from = from;
            this.to = to;
        }

        //起点 - 终点 比较
        @Override
        public boolean equals(Object obj) {
            Edge<V,E> edge = (Edge<V,E>)obj;
            return Objects.equals(from,edge.from) && Objects.equals(to,edge.to);
        }

        @Override
        public int hashCode() {
            return from.hashCode() * 31 + to.hashCode();
        }

        @Override
        public String toString() {
            return "Edge{" + "from=" + from +
                    ", to=" + to + ", weight=" + weight + '}';
        }
    }

    private Map<V,Vertex<V,E>> vertices = new HashMap<>();//存放所有顶点
    private Set<Edge<V,E>> edges = new HashSet<>();//存放所有边

    //打印
    public void print(){
        vertices.forEach((V v,Vertex<V,E> vertex) -> {
            System.out.println(v);
            System.out.println("out--------------");
            System.out.println(vertex.outEdges);
            System.out.println("in-------------");
            System.out.println(vertex.inEdges);
        });
        edges.forEach(System.out::println);
    }
    @Override
    public int edgesSize() {
        return edges.size();
    }

    @Override
    public int verticesSize() {
        return vertices.size();
    }

    //添加顶点
    @Override
    public void addVertex(V v) {
        if(vertices.containsKey(v)) return;
        vertices.put(v,new Vertex<>(v));
    }

    @Override
    public void addEdge(V from, V to) {
        addEdge(from,to,null);
    }

    //添加边
    @Override
    public void addEdge(V from, V to, E weight) {
        Vertex<V, E> fromVertex = vertices.get(from);
        if(fromVertex == null){ //添加起点
            fromVertex = new Vertex<>(from);
            vertices.put(from,fromVertex);
        }

        Vertex<V, E> toVertex = vertices.get(to);
        if(toVertex == null){ //添加终点
            toVertex = new Vertex<>(to);
            vertices.put(to,toVertex);
        }

        //创建边
        Edge<V, E> edge = new Edge<>(fromVertex,toVertex);
        edge.weight = weight;
        //删除以前相同edge的边，再重新创建新的边
        if (fromVertex.outEdges.remove(edge)) {
            toVertex.inEdges.remove(edge);
            edges.remove(edge);
        }

        //添加边
        fromVertex.outEdges.add(edge);
        toVertex.inEdges.add(edge);
        edges.add(edge);
    }

    //删除边
    @Override
    public void removeEdge(V from, V to) {
        Vertex<V, E> fromVertex = vertices.get(from);
        if(fromVertex == null)return;
        Vertex<V, E> toVertex = vertices.get(to);
        if(toVertex == null)return;

        Edge<V, E> edge = new Edge<>(fromVertex,toVertex);
        if (fromVertex.outEdges.remove(edge)) {
            toVertex.inEdges.remove(edge);
            edges.remove(edge);
        }

    }

    //删除顶点
    @Override
    public void removeVertex(V v) {
        Vertex<V, E> vertex = vertices.remove(v);
        if(vertex==null)return;

        //删除出度
        for(Iterator<Edge<V, E>> iterator = vertex.outEdges.iterator();iterator.hasNext();){
            Edge<V, E> edge = iterator.next();
            //删除入度(边)
            edge.to.inEdges.remove(edge);
            //从outEdges集合删除当前迭代对象edge
            iterator.remove();
            edges.remove(edge);
        }

        //删除入度
        for(Iterator<Edge<V, E>> iterator = vertex.inEdges.iterator();iterator.hasNext();){
            Edge<V, E> edge = iterator.next();
            edge.from.outEdges.remove(edge);
            //从inEdges集合删除当前迭代对象edge
            iterator.remove();
            edges.remove(edge);
        }
    }
    //广度优先遍历
    @Override
    public void bfs(V begin, Graph.VertexVisitor<V> visitor) {
        if(visitor==null)return;
        Vertex<V, E> beginVertex = vertices.get(begin);
        if(beginVertex ==  null)return;

        //存放已遍历的节点
        Set<Vertex<V,E>> visitedVertices = new HashSet<>();
        Queue<Vertex<V,E>> queue = new LinkedList<>();
        queue.offer(beginVertex);
        visitedVertices.add(beginVertex);

        while (!queue.isEmpty()) {
            Vertex<V, E> vertex = queue.poll();
            if(visitor.visit(vertex.value))return;

            for(Edge<V,E>edge : vertex.outEdges ){
                if(visitedVertices.contains(edge.to))continue;
                queue.offer(edge.to);
                visitedVertices.add(edge.to);
            }
        }
    }

    //深度优先遍历  _递归
    @Override
    public void dfs(V begin, Graph.VertexVisitor<V> visitor) {
        if(visitor==null)return;
        Vertex<V, E> beginVertex = vertices.get(begin);
        if(beginVertex ==  null)return;
        dfs(beginVertex,new HashSet<>(),visitor);
    }
    public void dfs(Vertex<V,E> vertex, Set<Vertex<V,E>> visitedVertices, Graph.VertexVisitor<V> visitor) {
        if(visitor.visit(vertex.value))return;
        visitedVertices.add(vertex);//存储已访问的节点

        for (Edge<V,E> edge: vertex.outEdges){
            if(visitedVertices.contains(edge.to)) continue;
            dfs(edge.to, visitedVertices,visitor);
        }
    }

    //深度优先遍历  _非递归
    @Override
    public void dfs2(V begin, Graph.VertexVisitor<V> visitor) {
        if(visitor==null)return;
        Vertex<V, E> beginVertex = vertices.get(begin);
        if(beginVertex==null)return;

        Set<Vertex<V,E>> visiteVertices = new HashSet<>();
        Stack<Vertex<V,E>> stack = new Stack<>();

        //先访问起点
        stack.push(beginVertex);
        visiteVertices.add(beginVertex);
        System.out.println();
        if(visitor.visit(beginVertex.value))return;

        while (!stack.isEmpty()) {
            Vertex<V, E> vertex = stack.pop();

            for (Edge<V,E> edge: vertex.outEdges){
                if(visiteVertices.contains(edge.to))continue;
                stack.push(edge.from);
                stack.push(edge.to);
                visiteVertices.add(edge.to);
                if(visitor.visit(edge.to.value))return;
                break;
            }
        }
    }

    //拓扑排序
    @Override
    public List<V> topologicalSort() {
        List<V> list = new ArrayList<>();
        Queue<Vertex<V,E>> queue = new LinkedList<>();
        Map<Vertex<V,E>,Integer> ins = new HashMap();//保存入度信息

        //初始化 (将入度为0的节点都放入队列)
        vertices.forEach((V v,Vertex<V,E> vertex)->{
            int in = vertex.inEdges.size();
            System.out.println(vertex.inEdges+"->"+in+"_");
            if(in == 0){
                queue.offer(vertex);
                System.out.println(vertex.value+"__");
            }else {
                ins.put(vertex,in);   //保存入度值
            }
        });

        while (!queue.isEmpty()) {
            Vertex<V, E> vertex = queue.poll();
            list.add(vertex.value);

            for(Edge<V,E> edge : vertex.outEdges){
                int toIn = ins.get(edge.to)-1;//更新入度
                if(toIn==0){
                    queue.offer(edge.to);
                }else {
                    ins.put(edge.to,toIn);
                }
            }
        }
        return list;
    }
}
