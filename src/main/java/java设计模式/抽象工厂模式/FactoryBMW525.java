package java设计模式.抽象工厂模式;

//为宝马320系列生产配件
public class FactoryBMW525 implements AbstractFactory{
    @Override
    public Engine createEngine() {
        return new EngineB();
    }

    @Override
    public Aircondition createAircondition() {
        return new AirconditionB();
    }
}
