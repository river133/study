package java高并发编程.c_025;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class T07_DelayQueue {
    /*
    无界队列，队列里每一个元素可以指定多长时间被消费
    使用场景：定时执行任务，谁的时间在前先执行谁
     */
    static BlockingQueue<MyTask> tasks = new DelayQueue<>();
    Random r=new Random();

    static class MyTask implements Delayed{
        long runningTime;
        String name;
        public MyTask(String name,long rt) {
            this.name=name;
            this.runningTime=rt;
        }

        @Override
        public int compareTo(Delayed o) {
            if(this.getDelay(TimeUnit.MILLISECONDS) < o.getDelay(TimeUnit.MILLISECONDS)){
                return -1;
            }else  if(this.getDelay(TimeUnit.MILLISECONDS) > o.getDelay(TimeUnit.MILLISECONDS)){
                return 1;
            }else {
                return 0;
            }
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(runningTime-System.currentTimeMillis(),TimeUnit.MILLISECONDS);
        }

        @Override
        public String toString() {
            return name+"_"+runningTime;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long now = System.currentTimeMillis();
        MyTask t1 = new MyTask("a1",now + 1000);
        MyTask t2 = new MyTask("a2",now + 2000);
        MyTask t3 = new MyTask("a3",now + 1500);
        MyTask t4 = new MyTask("a4",now + 2500);
        MyTask t5 = new MyTask("a5",now + 500);

        //要求put的元素必须实现Delayed接口
        tasks.put(t1);
        tasks.put(t2);
        tasks.put(t3);
        tasks.put(t4);
        tasks.put(t5);
        System.out.println(tasks);

        for (int i = 0; i < 5; i++) {
            //排序后打印
            System.out.println(tasks.take());
        }
        /*
        [a5_1596106346688, a1_1596106347188, a3_1596106347688, a4_1596106348688, a2_1596106348188]
        a5_1596106346688
        a1_1596106347188
        a3_1596106347688
        a2_1596106348188
        a4_1596106348688
         */
    }
}
