package java高并发编程.c_025;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class T06_ArrayBlockingQueue {
    /*
    有界队列，容器只能装10个，
     */
    static BlockingQueue<String> strs = new ArrayBlockingQueue<>(10);
    static Random r=new Random();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            strs.put("a"+i);
        }

        strs.put("aaa");//满了会阻塞
//        strs.add("aaa");//超过容量则报错

        //不报异常，false代表未添加成功
//        System.out.println(strs.offer("aaa"));

        //不报异常，false代表未添加成功,可指定时间，超过时间则不添加
//        System.out.println(strs.offer("aaa", 1, TimeUnit.SECONDS));

        System.out.println(strs);
    }

}
