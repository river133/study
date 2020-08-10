package java高并发编程.c_025;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class T02_CopyOnWriteList {
    public static void main(String[] args) {
        List<String> lists =
//        new ArrayList<>();//这个会并发问题
//        new Vector<>();//结果保证100000 耗时：145
//        写时复制容器,写的效率低，读的效率高
        new CopyOnWriteArrayList<>();//结果保证100000 耗时：6535

        Random r = new Random();
        Thread[] ths = new Thread[100];

        for (int i = 0; i < ths.length; i++) {
            Runnable task =new Runnable(){
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++)
                        lists.add("a"+r.nextInt(10000));
                }
            };
            ths[i]=new Thread(task);
        }
        runAndCoputeTime(ths);
        System.out.println(lists.size());
    }
    //计算时间
    public static void runAndCoputeTime(Thread[] ths){
        long start = System.currentTimeMillis();

        Arrays.asList(ths).forEach(t->t.start());
        Arrays.asList(ths).forEach(t->{
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(System.currentTimeMillis()-start);

    }
}
