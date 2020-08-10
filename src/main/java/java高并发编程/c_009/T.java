package java高并发编程.c_009;

import java.util.concurrent.TimeUnit;

/**
 * 一个同步方法可以调用另外一个同步方法
 * 一个线程已经拥有对象的锁，再次申请的时候任会得到该对象的锁，
 * 也就是说synchronized获得的锁是可以重入的
 */
public class T {
    synchronized void m1(){
        System.out.println("m1 start");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        m2();//同一个线程可以继续重入锁
    }

    synchronized void m2(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m2");
    }

    public static void main(String[] args) {
        T t = new T();
        new Thread(()->t.m1(),"t1").start();
//        m1 start
//        m2
    }
}
