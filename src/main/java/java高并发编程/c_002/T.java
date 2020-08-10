package java高并发编程.c_002;

public class T {
    private int count=10;

    public void m(){
        //任意线程执行以下代码需获取当前对象的锁
        synchronized (this){
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
