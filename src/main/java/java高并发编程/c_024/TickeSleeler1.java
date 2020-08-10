package java高并发编程.c_024;

import java.util.ArrayList;
import java.util.List;
/*
解决重复销售，超量销售问题
 */
public class TickeSleeler1 {
    static List<String> tickets = new ArrayList<>();
    static {
        for (int i = 0; i < 10000; i++) {
            tickets.add("票编号："+i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                while (tickets.size()>0){
                    System.out.println("销售了--"+tickets.remove(0));
                }
            }).start();
        }
    }
}
