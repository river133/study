package java高并发编程.c_011;

import java.util.concurrent.TimeUnit;

/*
程序执行过程中出现异常，默认会释放锁
 */
public class T {
    int count=0;
    synchronized void m(){
        System.out.println(Thread.currentThread().getName()+" start");
        while (true){
            count++;
            System.out.println(Thread.currentThread().getName()+" count= "+count);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(count==3){
                //此处抛异常锁将被释放，cry catch则不会释放锁
                int i=1/0;
            }
        }
    }

    public static void main(String[] args) {
        T t = new T();
//        new Thread(()->t.m(),"t1").start();
//        new Thread(()->t.m(),"t2").start();

        Runnable r = new Runnable() {
            @Override
            public void run() {
                t.m();
            }
        };
        new Thread(r,"t1").start();
        new Thread(r,"t2").start();


    }
}
