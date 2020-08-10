package java设计模式.建造者模式;

/**
 * 建造者模式
 * 　　建造者模式也是一种对象创建型模式。相较于工厂模式、单例模式等创建简单类型对象的创建型模式，
 * 这种模式适合创建复杂类型的对象。比如我们要组装一辆汽车，包括许多组件，发动机、轮胎、车架等。
 * 每一个组件可以看做是一个简单类型的对象，那么整个汽车就相当于一个复杂类型的对象。
 *
 * 　　那么我们如何将这些组件构建和组合设计，建造者模式为我们提供了解决方案，
 * 我们将组件的构建和设计分离，抽象成一个构建器和一个设计器。构建器负责生产各种汽车组件，
 * 设计器负责将这些组件设计组合。下面我们开始构建和设计一辆宝马汽车。
 */
public class Main {
    public static void main(String[] args) {
        //获取宝马汽车设计器
        BwmDirector carDirector = new BwmDirector(new BwmBuilder());
        //设计组装
        Car car = carDirector.directorCar();
        //查看汽车各种组件商标
        System.out.println("汽车引擎："+car.getEngine().getName());
        System.out.println("汽车轮胎："+car.getTyre().getName());
        System.out.println("汽车车架："+car.getFrame().getName());
    }
}
