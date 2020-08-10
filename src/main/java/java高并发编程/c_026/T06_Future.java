package java高并发编程.c_026;

import java.util.concurrent.*;

public class T06_Future {
    public static void main(String[] args) throws  ExecutionException, InterruptedException {

        /*
        创建未来的任务,有返回值的任务
         FutureTask<Integer> task1 =  new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return null;
            }
        });
         */
        FutureTask<Integer> task =  new FutureTask<>(()->{
            TimeUnit.MILLISECONDS.sleep(500);
            return 1000;
        });//new Callable(){Integer call()

        new Thread(task).start();
        System.out.println(task.get());//阻塞

        System.out.println("************************");
        ExecutorService service = Executors.newFixedThreadPool(5);
        Future<Integer> f = service.submit(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        });
//        System.out.println(f.get());//1
        //主线程判断isDone，返回false,因为是2个线程
        System.out.println(f.isDone());//false

    }
}
