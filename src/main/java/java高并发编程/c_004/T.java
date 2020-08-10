package java高并发编程.c_004;

public class T {
    private static int count=10;

    //锁定T.class
    public static synchronized void m(){
        count--;
        System.out.println( Thread.currentThread().getName()+"  count= "+count);
    }
    public static void mm(){
        /*这里写synchronized(this)是否可以
        静态不需要对象，没有this引用的存在*/
        synchronized (T.class){
            count--;
            System.out.println( Thread.currentThread().getName()+"  count= "+count);
        }
    }
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
               T.m();
//                T.mm();
            }
        };
        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }
    }
}
