package java高并发编程.c_023;

import java.util.Arrays;

/*
线程安全的单例模式

既不用加锁，也能实现懒加载
 */
public class Singleton {
    private Singleton(){
        System.out.println("singleton");
    }

    private static class Inner{
        private static Singleton s=new Singleton();
    }

    public static Singleton getSingle(){
        return Inner.s;
    }

    public static void main(String[] args) {
        Thread[]ths = new Thread[200];
        for (int i = 0; i < ths.length; i++) {
            ths[i]=new Thread(()->{
               Singleton.getSingle();
            });
        }

        Arrays.asList(ths).forEach(o->o.start());
    }
}
