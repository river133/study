package java高并发编程.c_026;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class T10_ScheduledPool {
    /*
    定时器线程池，线程可复用
     */
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(4);
        //已固定的频率执行某个任务
        service.scheduleAtFixedRate(()->{
            try {
                TimeUnit.MILLISECONDS.sleep(new Random().nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //,0代表起始的延迟时间，500:每隔多长时间
            System.out.println(Thread.currentThread().getName());
            //如任务执行时间超过500毫秒，500毫秒后将执行下一个任务
        },0,500,TimeUnit.MILLISECONDS);


    }
}
