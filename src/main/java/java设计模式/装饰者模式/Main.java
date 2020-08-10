package java设计模式.装饰者模式;

public class Main {
    public static void main(String[] args) {
        Man man = new NormalMan("张三");
        Man man1 = new CarDecoratorImpl(man);
        Man man2 = new HouseDecoratorImpl(man1);
        System.out.println(man2.getManDesc());

    }
}
