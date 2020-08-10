package seemygo数据结构_算法.algorithm.并查集;


import seemygo数据结构_算法.util.Assert;

public class Main {
    public static void main(String[] args) {
//        t3();//存储对象
        t4();//存储整数
    }
    //并查集3 对象比较
    static void t3(){
        GenericUnionFind<Student> uf = new GenericUnionFind<>();
        Student s1 = new Student(1, "张1");
        Student s2 = new Student(2, "王2");
        Student s3 = new Student(3, "刘3");
        Student s4 = new Student(4, "陈4");
        uf.makeSet(s1);
        uf.makeSet(s2);
        uf.makeSet(s3);
        uf.makeSet(s4);

        uf.union(s1,s2);
        uf.union(s3,s4);
        uf.union(s1,s4);
        Assert.test(uf.isSame(s1,s2));
        Assert.test(uf.isSame(s3,s4));
        Assert.test(uf.isSame(s2,s3));
    }
    //并查集4 整数比较
    static void t4(){
        GenericUnionFind<Integer> uf = new GenericUnionFind<>();
        for (int i = 0; i < 10000; i++) {
            uf.makeSet(i);
        }
        uf.union(0,1);
        uf.union(0,3);
        uf.union(6,7);
        uf.union(0,7);

        Assert.test(uf.isSame(0,1));
        Assert.test(uf.isSame(0,6));
        Assert.test(uf.isSame(3,7));
    }

}
