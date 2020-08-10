package java高并发编程.c_019;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MyContainer2 {
//添加volatile 另一线程则可见，能得到通知
    /*
    添加volatile 另一线程则可见，能得到通知
    但是t2线程的死循环很浪费cup，可采用wait和nootify
    wait释放锁，notify不释放锁
     */
   volatile List lists=new ArrayList();

      public void add(Object o){
          lists.add(o);
      }
      public int size(){
          return lists.size();
      }

    public static void main(String[] args) {
        MyContainer2 c = new MyContainer2();

        final Object o = new Object();
        //线程1
        new Thread(()->{
            synchronized (o){
                if(c.size()!=3){
                    try {
                        o.wait();//线程等待通知
//                        System.out.println("aaa");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            System.out.println("t2结束");
            }
        },"t2").start();

        //相隔1秒后
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //线程2
        new Thread(()->{
            System.out.println("t1启动");

            synchronized (o){
                for (int i = 0; i < 10; i++) {
                    c.add(new Object());
                    System.out.println("add: "+i);

                    if(c.size()==5){
                        o.notify();
                    }
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        },"t1").start();
    }
}
