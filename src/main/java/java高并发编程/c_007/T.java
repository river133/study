package java高并发编程.c_007;
//非同步方法是否可以同步调用
public class T {
    public synchronized void m1(){
        System.out.println(Thread.currentThread().getName()+" m1 start...");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" m1 end");
    }

    public void m2(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" m2");
    }

    public static void main(String[] args) {
        T t = new T();
        new Thread(()->t.m1(),"t1").start();
        new Thread(()->t.m2(),"t2").start();
        /*
        执行结果
        t1 m1 start...
        t2 m2
        t1 m1 end
         */

//        new Thread(t::m1,"t1").start();
//        new Thread(t::m2,"t2").start();
    }
}
