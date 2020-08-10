package java高并发编程.c_020;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/*
ReentrantLock使用格式底层实现获取锁释放锁公平锁与非公平锁公平锁
ReentrantLock可替代synchronized
synchronized不可重入锁
 */

public class ReentrantLock2 {
      Lock lock = new ReentrantLock();
     void m1(){
         lock.lock();//类似于synchronized(this)
         try {
             for (int i = 0; i < 3; i++) {
                 TimeUnit.SECONDS.sleep(1);
                 System.out.println(i);
             }
         } catch (InterruptedException e) {
             e.printStackTrace();
         }finally {
             lock.unlock();// 必须要 手动释放锁
         }
     }

    synchronized void m2(){
        lock.lock();
        System.out.println("m2");
        lock.unlock();
    }

    public static void main(String[] args) {
        ReentrantLock2 r1 = new ReentrantLock2();
        new Thread(r1::m1).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(r1::m2).start();
    }
}
