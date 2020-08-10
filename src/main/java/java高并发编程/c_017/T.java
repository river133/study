package java高并发编程.c_017;

import java.util.concurrent.TimeUnit;
/*
锁定对象，对象属性发生改变时不影响锁的使用
但是o变成另外一个对象，则锁定对象发生改变
应避免锁定对象的引用变成另外的对象

 */
public class T {
    Object o = new Object();

      void m1(){
          synchronized (o){
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
        Thread t2 = new Thread(t::m1, "t2");
        //该对象发生改变，t2线程能执行，如释放这句话，对象不变则无法执行
//        t.o=new Object();
        t2.start();
    }
}
