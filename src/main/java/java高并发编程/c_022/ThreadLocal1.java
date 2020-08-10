package java高并发编程.c_022;

import java.util.concurrent.TimeUnit;
/*
ThreadLocal 线程局部变量
它通过为每个线程提供一个独立的变量副本解决了变量并发访问的冲突问题

如果一个线程修改了变量值，不想另一个线程知道？
 */
public class ThreadLocal1 {
    static ThreadLocal<Person> tl=new ThreadLocal<>();

    volatile static Person p = new Person();

    public static void main(String[] args) {
        //线程1、
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(tl.get());//null

        }).start();

        //线程2、先执行
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Person p = new Person();
            tl.set(p);
        }).start();
    }
}
class Person{
    String name="zhang";

}
