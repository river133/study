package java高并发编程.c_013;

import java.util.ArrayList;
import java.util.List;

public class T {
    //volatile: 保证参数可见性
    //synchronized:  即保证可见性，又保证原子性
    volatile int count=0;

    void m(){
        for (int i = 0; i < 100; i++)count++;
    }

    public static void main(String[] args) {
        T t = new T();
        List<Thread> thread = new ArrayList<>();

        //创建10个线程
        for (int i = 0; i < 10; i++) {
            thread.add(new Thread(t::m,"thread ->"+i));
        }

        thread.forEach((o)->o.start());
        System.out.println(t.count);
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
