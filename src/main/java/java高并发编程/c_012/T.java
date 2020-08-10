package java高并发编程.c_012;

import java.util.concurrent.TimeUnit;

/**
 * volatile 关键字：
 * 使变量在多个线程中可见
 */
public class T {
     boolean runing=true;//测试volatile的区别
//     boolean runing=true;//测试volatile的区别
    void m(){
        System.out.println("m start");
        while (runing){
            //....
        }
        System.out.println("m end!");
    }

    public static void main(String[] args) {
        T t = new T();
        new Thread(t::m,"t1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t.runing=false;
    }

}
