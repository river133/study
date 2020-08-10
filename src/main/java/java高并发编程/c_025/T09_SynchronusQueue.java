package java高并发编程.c_025;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class T09_SynchronusQueue {
    public static void main(String[] args) throws InterruptedException {

        //容量为0对象，代表生产的数据必须有消费者处理
        BlockingQueue<String> strs = new SynchronousQueue<>();
        new Thread(()->{
            try {
                System.out.println(strs.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        //如果没有消费者，阻塞等待消费者线程
        strs.put("aaa");

//        strs.add("aaa");//调用add报错，为此队列容器没有容量
        //IllegalStateException: Queue full

        System.out.println(strs.size());



    }
}
