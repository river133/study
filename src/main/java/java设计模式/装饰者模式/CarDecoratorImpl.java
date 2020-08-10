package java设计模式.装饰者模式;

// 小车装饰者
public class CarDecoratorImpl extends AbstractDecorator {
    private String car = "有车+";

    public CarDecoratorImpl(Man man) {
        super(man);
    }

    public String addCar() {
        return car;
    }

    @Override
    public String getManDesc() {
        return super.getManDesc()+addCar();
    }
}
