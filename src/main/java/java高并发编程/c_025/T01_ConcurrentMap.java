package java高并发编程.c_025;

import java.util.Arrays;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CountDownLatch;

public class T01_ConcurrentMap {
    public static void main(String[] args) {

//    Map<String,String> map = new ConcurrentHashMap<>();//并发容器 93 129
    Map<String,String> map = new ConcurrentSkipListMap<>();//高并发 且排序

//        Map<String,String> map = new Hashtable<>();//耗时：76-93
//    Map<String,String> map = new HashMap<>();//采用Collections.synchronizedxxx加锁方式

        Random r = new Random();
        Thread[] ths = new Thread[100];

        CountDownLatch latch = new CountDownLatch(ths.length);
        long start = System.currentTimeMillis();
        for (int i = 0; i < ths.length; i++) {
            ths[i]=new Thread(()->{
                for (int j = 0; j < 10000; j++) {
                    map.put("a"+r.nextInt(100000),"a"+r.nextInt(100000));
                    latch.countDown();//线程计数器
                }
            });
        }

        Arrays.asList(ths).forEach(t->t.start());
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //计算耗时
        System.out.println(System.currentTimeMillis() - start);
    }
}
