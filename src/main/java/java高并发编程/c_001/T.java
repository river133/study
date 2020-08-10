package java高并发编程.c_001;

public class T {
    private int count=10;
    private Object o = new Object();

    public void m(){
        synchronized (o){//任意线程执行以下代码需获取o的锁
            count--;
            System.out.println(
                    Thread.currentThread().getName()+"  count= "+count);
        }
    }
    public static void main(String[] args) {
        T t = new T();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                t.m();
            }
        };
        for (int i = 0; i < 10; i++) {
        new Thread(runnable).start();
        }
    }
}
