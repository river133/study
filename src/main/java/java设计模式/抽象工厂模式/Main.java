package java设计模式.抽象工厂模式;

public class Main {
    public static void main(String[] args) {
        //生产宝马320系列配件
        FactoryBMW320 factoryBMW320 = new FactoryBMW320();

        //生产引擎
        Engine engine320 = factoryBMW320.createEngine();
        //生产空调
        Aircondition aircondition320 = factoryBMW320.createAircondition();

        engine320.printEngine();
        aircondition320.printAircondition();

        //生产宝马523系列配件
        FactoryBMW525 factoryBMW525 = new FactoryBMW525();

        Engine engine525 = factoryBMW525.createEngine();
        Aircondition aircondition525 = factoryBMW525.createAircondition();

         engine525.printEngine();
        aircondition525.printAircondition();
    }
}
