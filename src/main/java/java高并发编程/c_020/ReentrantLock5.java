package java高并发编程.c_020;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/*
ReentrantLock使用格式底层实现获取锁释放锁公平锁与非公平锁公平锁
ReentrantLock可替代synchronized
synchronized不可重入锁

使用ReentrantLock 还可以调用lockInterruptily方法
可以对线程interrupt方法做出响应

ReentrantLock还可以指定为公平锁
 */

public class ReentrantLock5 extends Thread{
    //true为公平锁
    private static Lock lock = new ReentrantLock(true);

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName()+"获取锁");
            } finally {
                lock.unlock();
            }
        }
    }
    public static void main(String[] args) {
        ReentrantLock5 r1 = new ReentrantLock5();
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r1);
        t1.start();
        t2.start();
        /*
        线程交替执行
        Thread-1获取锁
        Thread-2获取锁
        Thread-1获取锁
        Thread-2获取锁
         */


    }
}
