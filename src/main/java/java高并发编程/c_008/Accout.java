package java高并发编程.c_008;
import java.util.concurrent.TimeUnit;

/**
 * 对业务写方法加锁，读不加锁容易造成脏读
 */
public class Accout {
    String name;
    double balance;

    public synchronized void set(String name,Double balance){
        this.name=name;

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.balance=balance;
    }

    public double getBalance(String name){
        return this.balance;
    }

    public static void main(String[] args) {
        Accout a = new Accout();
        new Thread(()->a.set("zhang",100.0)).start();

        System.out.println(a.getBalance("zhang"));

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(a.getBalance("zhang"));
    }

}
