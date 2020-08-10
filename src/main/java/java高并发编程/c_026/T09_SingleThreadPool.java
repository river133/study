package java高并发编程.c_026;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class T09_SingleThreadPool {
    public static void main(String[] args) {
        /*
        保证任务顺序执行
         */
        ExecutorService service = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            final int j=i;
            service.execute(()->{
                System.out.println(j+" "+Thread.currentThread().getName());
            });
        }
//        0 pool-1-thread-1
//        1 pool-1-thread-1
//        2 pool-1-thread-1
//        3 pool-1-thread-1
//        4 pool-1-thread-1
    }
}
