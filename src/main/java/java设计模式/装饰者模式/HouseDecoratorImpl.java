package java设计模式.装饰者模式;

// 房子装饰者
public class HouseDecoratorImpl extends AbstractDecorator {
    private String house = "有房+";

    public HouseDecoratorImpl(Man man) {
        super(man);
    }

    public String addHouse() {
        return house;
    }

    @Override
    public String getManDesc() {
        return super.getManDesc()+addHouse();
    }
}
