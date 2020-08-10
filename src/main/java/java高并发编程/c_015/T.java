package java高并发编程.c_015;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class T {
    //AtomicInteger  即保证可见性，又保证原子性,效率高于synchronized
//    由于count++不保证原子性，此方法可保证原子性
      AtomicInteger count =  new AtomicInteger(1);

    /*synchronized*/ void m(){
        for (int i = 0; i < 100; i++){
            count.incrementAndGet();//返回的是加1后的值
        };
    }

    public static void main(String[] args) {
        T t = new T();
        List<Thread> thread = new ArrayList<>();

        //创建10个线程
        for (int i = 0; i < 10; i++) {
            thread.add(new Thread(t::m,"thread ->"+i));
        }

        thread.forEach((o)->o.start());
        //结果不稳定

        thread.forEach((o)->{
            try {
                o.join();//加入线程
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
            System.out.println(t.count);
    }
}
