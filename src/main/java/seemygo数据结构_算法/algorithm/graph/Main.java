package seemygo数据结构_算法.algorithm.graph;

import java.util.List;

public class Main {
    public static void main(String[] args) {

//        testBfs();//广度优先
//        testDfs();//深度优先
        testTopo();//拓扑排序
    }

    //广度优先遍历
    static void testBfs(){
        Graph<Object, Double> graph = undirectedGraph(Data.BFS_01);//无向图
        graph.bfs("a",(Object v)->{
            System.out.print(v+"_");
            return v.equals("c");//a_b_f_c
        });
        // a_b_f_c_g_i_e_d_h_
        System.out.println("-------------");

        Graph<Object, Double> graph2 = directedGraph(Data.BFS_02);//有向图
        System.out.println();
        graph2.bfs(0, (Object v) -> {
            System.out.print(v+"+");
            return v.equals(2);//0_1_4_2_
        });
        // 0_1_4_2_6_7_5_3_
    }
    //深度优先遍历
    static void testDfs(){
        Graph<Object, Double> graph = undirectedGraph(Data.DFS_01);//无向图
        graph.dfs(1,(Object v)->{
            System.out.print(v+"_");
            return false;
        });
        //1_2_4_3_7_5_6_0_

        System.out.println();

        Graph<Object, Double> graph2 = directedGraph(Data.DFS_02);//无向图
        graph2.dfs("a",(Object v)->{
            System.out.print(v+"_");
            return false;
        }); //递归
        //a_b_e_f_c_

        graph2.dfs2("a",v->{
            System.out.print(v+"+");
            return false;
        }); //非递归
        //a_b_e_f_c_
    }
    //拓扑排序 有向无环图
    static void testTopo(){
        Graph<Object, Double> graph = directedGraph(Data.TOPO);
        List<Object> list = graph.topologicalSort();
        System.out.println(list);

    }

    //有向图
    private static Graph<Object,Double>directedGraph(Object[][]data){
        Graph<Object,Double> graph =  new ListGraph<>();
        for (Object[] edge: data){
            if(edge.length == 1){
                graph.addVertex(edge[0]);
            }else if(edge.length == 2){
                graph.addEdge(edge[0],edge[1]);
            }else if(edge.length == 3){
                double weight = Double.parseDouble(edge[2].toString());
                graph.addEdge(edge[0],edge[1],weight);
            }
        }
        return graph;
    }
    //无向图
    private static Graph<Object,Double>undirectedGraph(Object[][]data){
        Graph<Object,Double> graph = new ListGraph<>();
        for (Object[] edge: data){
            if(edge.length == 1){
                graph.addVertex(edge[0]);
            }else if(edge.length == 2){
                graph.addEdge(edge[0],edge[1]);
                graph.addEdge(edge[1],edge[0]);
            }else if(edge.length == 3){
                double weight = Double.parseDouble(edge[2].toString());
                graph.addEdge(edge[0],edge[1],weight);
                graph.addEdge(edge[1],edge[0],weight);
            }
        }
        return graph;
    }
}
