package java高并发编程.c_025;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class T04_ConcurrentQueue {
    public static void main(String[] args) {
        Queue<String>strs = new ConcurrentLinkedQueue<>();

        for (int i = 0; i < 10; i++) {
            boolean offer = strs.offer("a" + i);
        }

        System.out.println(strs);
        System.out.println(strs.size());

        System.out.println(strs.poll());//a0
        System.out.println(strs.size());//9

        System.out.println(strs.peek());//a1
        System.out.println(strs.size());//9



    }
}
