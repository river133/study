package java高并发编程.c_005;

public class T implements Runnable{
    private int count=10;

    /*
    多个线程共享一个数据，不加synchronized则多个线程访问
     */
    @Override
    public /*synchronized*/ void run() {
        count--;
        System.out.println( Thread.currentThread().getName()+"  count= "+count);
    }

    public static void main(String[] args) {
        T t = new T();
        for (int i = 0; i < 22; i++) {
            new Thread(t,"  THREAD  "+i).start();
        }
    }

}
