package java高并发编程.c_019;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MyContainer {
//添加volatile 另一线程则可见，能得到通知
    /*
    添加volatile 另一线程则可见，能得到通知
    但是t2线程的死循环很浪费cup，可采用wait和nootify
     */
   volatile List lists=new ArrayList();

      public void add(Object o){
          lists.add(o);
      }
      public int size(){
          return lists.size();
      }

    public static void main(String[] args) {
        MyContainer c = new MyContainer();
        new Thread(()->{
            while (true){
                if(c.size()==3){
                    break;
                }
            }
            System.out.println("t2结束");
        },"t2").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                c.add(new Object());
                System.out.println("add: "+i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t1").start();
    }
}
