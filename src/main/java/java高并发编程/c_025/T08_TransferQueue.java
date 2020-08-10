package java高并发编程.c_025;

import java.util.concurrent.LinkedTransferQueue;

public class T08_TransferQueue {
    public static void main(String[] args) throws InterruptedException {
        /*
        为了提高效率
        例：消费者先启动，生产者不先往队列放数据，而是直接找消费者
         */
        LinkedTransferQueue<String> strs = new LinkedTransferQueue<>();

//        new Thread(()->{
//            try {
//                //消费者先启动等待...
//                System.out.println(strs.take());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();

        // 如果先启动生产者，由于没有找到消费者线程，则阻塞
        //使用场景：如实时消息处理
        strs.transfer("aaa");//启动生产者

        //3个都不会阻塞
//        strs.put("aaa");
//        strs.add("aaaa");
//        strs.offer("aaa");

        new Thread(()->{
            try {
                System.out.println(strs.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


    }
}
