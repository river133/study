package java高并发编程.c_026;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class T11_WorkStealingPool {
    static class R implements Runnable{
        int time;

        public R(int time) {
            this.time = time;
        }

        @Override
        public void run() {
            try {
                TimeUnit.MILLISECONDS.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(time+" "+Thread.currentThread().getName());
        }
    }
    public static void main(String[] args) throws IOException {
        /*
        根据cpu启动多少个线程
        每个线程都维护自己的队列，当自己线程结束时它会运行别的线程池的线程，避免了再去创建线程的额外开销。
         */
        ExecutorService service = Executors.newWorkStealingPool();
        //JVM可用线程数量
//        System.out.println(Runtime.getRuntime().availableProcessors());
        service.execute(new R(1000));//延迟1秒
        service.execute(new R(2000));
        service.execute(new R(2000));
        service.execute(new R(2000));
        service.execute(new R(2000));
        service.execute(new R(2000));
        service.execute(new R(2000));
        service.execute(new R(2000));

        //当第一个线程运行完成后，第九个线程由第一个线程来运行
        service.execute(new R(2000));
        //由于产生的是精灵线程(守护线程，后台线程)  主线程不阻塞的话，看不出输出
        System.in.read();

    }
}
