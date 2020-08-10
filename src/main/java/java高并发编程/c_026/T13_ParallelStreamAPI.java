package java高并发编程.c_026;

import java.util.ArrayList;
import java.util.Random;

public class T13_ParallelStreamAPI {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 10000; i++) {
            //1百万-》2百万之间的数
            nums.add(1000000+r.nextInt(1000000));
        }

        //普通线程执行
        long start = System.currentTimeMillis();
        nums.forEach(v->isPrime(v));
        System.out.println(System.currentTimeMillis()-start);//2642

        //并行线程执行
          start = System.currentTimeMillis();
        nums.parallelStream().forEach(v->isPrime(v));
//        nums.parallelStream().forEach(T13_ParallelStreamAPI::isPrime);
        System.out.println(System.currentTimeMillis()-start);//574

    }
    static boolean isPrime(int num){
        for (int i = 2; i <= num/2 ; i++) {
            if (num%i==0) return false;
        }
            return true;
    }
}
