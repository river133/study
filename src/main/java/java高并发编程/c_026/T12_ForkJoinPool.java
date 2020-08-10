package java高并发编程.c_026;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class T12_ForkJoinPool {
    /*
    将一个计算量特别大的任务拆分为多个小任务执行
     */
//    static int[] nums = new int[1000000];
//    static final int MAX_NUM=50000;//拆分的数量

    static int[] nums = new int[20];
    static final int MAX_NUM=5;//拆分的数量

    static Random r=new Random();
    
    static {
        for (int i = 0; i < nums.length; i++) {
//            nums[i]=r.nextInt(100);
            nums[i]=1;
        }
        //采用流的方式计数总和
        System.out.println(Arrays.stream(nums).sum());
    }

   // RecursiveAction没有返回值
/*
   static class AddTask extends RecursiveAction {
        int start,end;

        public AddTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {
            //小于50000，无需拆分线程
            if(end-start <= MAX_NUM){
                long sum =0l;
                for (int i = start; i < end; i++) {
                    sum+=nums[i];
                }
                System.out.println("from: "+start+" to: "+end +" = "+sum);
            }else {
                //拆分线程
                int middle =start + (end-start)/2;

                AddTask subTask1 = new AddTask(start, middle);
                AddTask subTask2 = new AddTask(middle, end);
                subTask1.fork();
                subTask2.fork();
            }
        }
    }
*/

    //RecursiveAction 有返回值

    static class AddTask extends RecursiveTask<Long> {
        int start, end;

        public AddTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public AddTask() {
            super();
        }

        @Override
        protected Long compute() {
            //小于50000，无需拆分线程
            if (end - start <= MAX_NUM) {
                long sum = 0l;
                for (int i = start; i < end; i++) {
                    sum += nums[i];
                }
                return sum;
            } else {
                //拆分线程
                int middle = start + (end - start) / 2;

                AddTask subTask1 = new AddTask(start, middle);
                AddTask subTask2 = new AddTask(middle, end);
                subTask1.fork();
                subTask2.fork();

                return subTask1.join() + subTask2.join();

            }
        }
    }

    public static void main(String[] args) throws IOException {

//        t1();//有返回值
        t2();//无返回值
    }
    private static void t1()throws IOException{
        ForkJoinPool fjp = new ForkJoinPool();
        AddTask task = new AddTask(0, nums.length);
        fjp.execute(task);
        System.in.read();

        /*
        20
        from: 15 to: 20 = 5
        from: 10 to: 15 = 5
        from: 0 to: 5 = 5
        from: 5 to: 10 = 5
         */
    }
    private static void t2(){
        ForkJoinPool fjp = new ForkJoinPool();
        AddTask task = new AddTask(0, nums.length);
        fjp.execute(task);
//        long result = task.join();
//        System.out.println(result);
    }
}
