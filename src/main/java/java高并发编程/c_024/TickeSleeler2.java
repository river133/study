package java高并发编程.c_024;

import java.util.Vector;
import java.util.concurrent.TimeUnit;

/*
解决重复销售，超量销售问题
 */
public class TickeSleeler2 {
//    static List<String> tickets = new ArrayList<>();
    /*
    remove是原子性，判断和操作分离了
     */
    static Vector<String> tickets=new Vector<>();
    static {
        for (int i = 0; i < 10000; i++) {
            tickets.add("票编号："+i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                while (tickets.size()>0){
                    try {
                        TimeUnit.MILLISECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("销售了--"+tickets.remove(0));
                }
            }).start();
        }
    }
}
