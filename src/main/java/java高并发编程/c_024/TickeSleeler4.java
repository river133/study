package java高并发编程.c_024;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/*
解决重复销售，超量销售问题
 */
public class TickeSleeler4 {
    /*
    remove是原子性，判断和操作分离了
    处理的方式判断也加锁，但效率不高

    可采用高性能并发容器
     */
    static Queue<String> tickets = new ConcurrentLinkedQueue<>();
    static {
        for (int i = 0; i < 10000; i++) {
            tickets.add("票编号：" + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                  String s = tickets.poll();
                    System.out.println("null?  "+s);
                  if (s==null)break;
                  else System.out.println("销售了..."+s);
                }
            }).start();
        }
    }
}
