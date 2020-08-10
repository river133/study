package java高并发编程.c_018;

import java.util.concurrent.TimeUnit;
public class T {
    //由于字符串常量属于同一个对象，锁的是同一个对象
    String s1 = "abc";
    String s2 = "abcef";

      void m1(){
          synchronized (s1){
              while (true){
                  try {
                      TimeUnit.SECONDS.sleep(1);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
                  System.out.println(Thread.currentThread().getName());
              }
          }
    }
    void m2(){
        synchronized (s2){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        }
    }


    public static void main(String[] args) {
        T t = new T();
        //启动线程1
        new Thread(t::m1,"t1").start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //启动线程2
        //锁定同一个对象，无法执行此线程2
         new Thread(t::m1, "t2").start();
    }
}
