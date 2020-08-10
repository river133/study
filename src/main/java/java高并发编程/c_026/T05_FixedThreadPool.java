package java高并发编程.c_026;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class T05_FixedThreadPool {
    public static void main(String[] args) {
        /*
        创建固定数量的线程,当线程运行完时，新加入线程可以复用，不必新开启线程
         */
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 6; i++) {
           service.execute(()->{
               try {
                   TimeUnit.MILLISECONDS.sleep(500);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               System.out.println(Thread.currentThread().getName());
           });
        }
        System.out.println(service);
//        java.util.concurrent.ThreadPoolExecutor@378bf509[Running, pool size = 5, active threads = 5, queued tasks = 1, completed tasks = 0]

        service.shutdown();//强制关闭线程
        System.out.println(service.isTerminated());//任务是否执行完，false
        System.out.println(service.isShutdown());//是否关闭线程，true
        System.out.println(service);
//        java.util.concurrent.ThreadPoolExecutor@378bf509[Shutting down, pool size = 5, active threads = 5, queued tasks = 1, completed tasks = 0]

        /* 线程池开启5个线程，当加入第六个线程时，最先完成的线程可得到复用
        pool-1-thread-2
        pool-1-thread-1
        pool-1-thread-4
        pool-1-thread-3
        pool-1-thread-5
        pool-1-thread-2*/
        //主线程等待5秒
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(service.isTerminated());
        System.out.println(service.isShutdown());
        System.out.println(service);
        //java.util.concurrent.ThreadPoolExecutor@378bf509[Terminated, pool size = 0, active threads = 0, queued tasks = 0, completed tasks = 6]
    }
}
