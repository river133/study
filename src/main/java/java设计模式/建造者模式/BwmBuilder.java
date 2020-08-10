package java设计模式.建造者模式;

/**
 * 4.宝马汽车构建器
 *这里构建的汽车各种组件对象也可以结合工厂模式、
 * 单例模式或者其他创建简单类型对象的模式进行创建。
 */
public class BwmBuilder implements CarBuilder {

    @Override
    public Engine builderEngine() {
        //也可通过工厂模式,单例模式等创建
        return new Engine("宝马发动机！");
    }
    @Override
    public Tyre builderTyre() {
        return new Tyre("宝马轮胎");
    }
    @Override
    public Frame builderFrame() {
        return new Frame("宝马车架");
    }
}