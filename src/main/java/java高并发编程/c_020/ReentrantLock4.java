package java高并发编程.c_020;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/*
ReentrantLock使用格式底层实现获取锁释放锁公平锁与非公平锁公平锁
ReentrantLock可替代synchronized
synchronized不可重入锁

使用ReentrantLock 还可以调用lockInterruptily方法
可以对线程interrupt方法做出响应
 */

public class ReentrantLock4 {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        Thread t1 = new Thread(() -> {
            lock.lock();

            try {
                 System.out.println("t1 start");
                 TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);//模拟阻塞
                System.out.println("t1 end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            try {
//            lock.lock();
                lock.lockInterruptibly();// 可对interrupt()方法做出响应
                System.out.println("t2 start");
                TimeUnit.SECONDS.sleep(3);
                System.out.println("t2 end");
            } catch (InterruptedException e) {
                System.out.println("interrupted t2线程被打断了");
            } finally {
                lock.unlock();//未获得锁，抛异常
            }
        });
        t2.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.interrupt();//打断线程2的等待
    }
}
