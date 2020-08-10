package seemygo数据结构_算法.algorithm.sort;

import seemygo数据结构_算法.util.Assert;
import seemygo数据结构_算法.util.Integers;

public class Main {
    public static void main(String[] args) {
//        t1();
        t2();//插入排序
//        t3();//归并排序

    }
    //堆排序
    static void t1(){
        Integer[] array = Integers.random(16,1,44);
        new 堆排序().sort(array);
        Assert.test(Integers.isAscOrder(array));
        Integers.println(array);
    }
    //插入排序
    static void t2(){
        Integer[] array = Integers.random(16,1,44);
        new 插入排序().sort(array);
        Assert.test(Integers.isAscOrder(array));
        Integers.println(array);
    }
    //插入排序
    static void t3(){
        Integer[] array = Integers.random(16,1,44);
        Integers.println(array);
        new 归并排序().sort(array);
        Assert.test(Integers.isAscOrder(array));
        Integers.println(array);
    }
}
