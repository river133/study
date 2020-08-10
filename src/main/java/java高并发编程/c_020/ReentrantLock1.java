package java高并发编程.c_020;

import java.util.concurrent.TimeUnit;
/*
ReentrantLock使用格式底层实现获取锁释放锁公平锁与非公平锁公平锁
synchronized不可重入锁
 */

public class ReentrantLock1 {
    synchronized void m1(){
        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
    }

    synchronized void m2(){
        System.out.println("m2");
    }

    public static void main(String[] args) {
        ReentrantLock1 r1 = new ReentrantLock1();
        new Thread(r1::m1).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(r1::m2).start();
    }
}
