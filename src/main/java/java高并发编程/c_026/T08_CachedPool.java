package java高并发编程.c_026;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class T08_CachedPool {
    public static void main(String[] args) throws InterruptedException {
        /*
        缓存线程池：来一个任务启一个线程，线程超过60秒会消失
         */
    ExecutorService service = Executors.newCachedThreadPool();
        System.out.println(service);

        for (int i = 0; i < 2; i++) {
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
        TimeUnit.SECONDS.sleep(80);
        System.out.println(service);

//        java.util.concurrent.ThreadPoolExecutor@330bedb4[Running, pool size = 0, active threads = 0, queued tasks = 0, completed tasks = 0]
//        java.util.concurrent.ThreadPoolExecutor@330bedb4[Running, pool size = 2, active threads = 2, queued tasks = 0, completed tasks = 0]
//        pool-1-thread-1
//        pool-1-thread-2
//        java.util.concurrent.ThreadPoolExecutor@330bedb4[Running, pool size = 0, active threads = 0, queued tasks = 0, completed tasks = 2]

    }

}
