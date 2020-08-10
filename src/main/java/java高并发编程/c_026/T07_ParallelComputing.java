package java高并发编程.c_026;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
/*
模拟并行计算，将大任务切割为多个小任务，并进行汇总

submit() 和 execute()方法的区别

execute() 参数 Runnable ；submit() 参数 (Runnable) 或 (Runnable 和 结果 T) 或 (Callable)

execute() 没有返回值；而 submit() 有返回值

submit() 的返回值 Future 调用get方法时，可以捕获处理异常
 */
public class T07_ParallelComputing {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        List<Integer> results = getPrime(1,200000);
        System.out.println(System.currentTimeMillis()-start);//2568

        final int cpuCoreNum=4;
        ExecutorService service = Executors.newFixedThreadPool(cpuCoreNum);
        MyTask t1 = new MyTask(1, 80000);
        MyTask t2 = new MyTask(80001, 130000);
        MyTask t3 = new MyTask(130001, 170000);
        MyTask t4 = new MyTask(170001, 200000);

        Future<List<Integer>> f1 = service.submit(t1);
        Future<List<Integer>> f2 = service.submit(t2);
        Future<List<Integer>> f3 = service.submit(t3);
        Future<List<Integer>> f4 = service.submit(t4);

        start = System.currentTimeMillis();
         f1.get();
         f2.get();
         f3.get();
         f4.get();
        System.out.println(System.currentTimeMillis()-start);//1210


    }
    //判断素数
    static boolean isPrime(int num){
        if(num<2)return false;
        for (int i = 2; i <=num/2; i++) {
            if(num%i==0)return false;
        }
        return true;
    }

    //返回素数的集合
    public static List<Integer> getPrime(int start,int end){
        List<Integer> results=new ArrayList<>();
        for (int i = start; i <= end; i++) {
            if(isPrime(i)){
                results.add(i);
            };
        }
        return results;
    }

    static class MyTask implements Callable<List<Integer>> {
        int startPos,endPos;

        public MyTask(int startPos, int endPos) {
            this.startPos = startPos;
            this.endPos = endPos;
        }

        @Override
        public List<Integer> call() throws Exception {
            return getPrime(startPos,endPos);
        }
    }
}
