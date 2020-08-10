package java高并发编程.c_019;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class MyContainer4 {
    /*
    CountDownLatch是一种java.util.concurrent包下一个同步工具类，
    它允许一个或多个线程等待直到在其他线程中一组操作执行完成。
     */
    List lists=new ArrayList();

      public void add(Object o){
          lists.add(o);
      }
      public int size(){
          return lists.size();
      }

    public static void main(String[] args) {
        MyContainer4 c = new MyContainer4();

        CountDownLatch latch = new CountDownLatch(1);

        //线程1
        new Thread(()->{
            System.out.println("t2启动");
                if(c.size()!=3){
                    try {
                        latch.await();//线程等待通知
                        //也可以指定等待时间,超时则不等待，执行当前线程
//                        latch.await(2000,TimeUnit.MILLISECONDS);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t2结束");
        },"t2").start();


        //线程2
        new Thread(()->{
            System.out.println("t1启动");

                for (int i = 0; i < 5; i++) {
                    c.add(new Object());
                    System.out.println("add: "+i);

                    if(c.size()==3){
                        latch.countDown();
                    }
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
        },"t1").start();
    }
}
