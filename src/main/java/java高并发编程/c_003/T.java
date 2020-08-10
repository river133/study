package java高并发编程.c_003;

public class T {
    private int count=10;

    //锁定当前对象，等同于synchronized (this)
    public synchronized void m(){
//        synchronized (this){
            count--;
            System.out.println(
                    Thread.currentThread().getName()+"  count= "+count);
//        }
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
