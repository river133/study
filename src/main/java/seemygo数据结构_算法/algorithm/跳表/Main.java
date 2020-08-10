package seemygo数据结构_算法.algorithm.跳表;

import seemygo数据结构_算法.util.Assert;

public class Main {
    public static void main(String[] args) {

        SkipList<Integer, Integer> list = new SkipList<>();
        test(list,30,10);
    }
    private static void test(SkipList<Integer,Integer> list, int count,int delta){
        //测试添加
        for (int i = 0; i < count; i++) {
            list.put(i,i+delta);
        }
        System.out.println(list);
        //测试获取
        for (int i = 0; i < count; i++) {
            Assert.test(list.get(i) == i+delta);
        }
        Assert.test(list.size() == count);
        //测试删除
        for (int i = 0; i < count; i++) {
            Assert.test(list.remove(i) == i+delta);
        }
        Assert.test(list.size() == 0);
    }
}

