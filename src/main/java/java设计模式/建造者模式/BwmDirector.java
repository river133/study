package java设计模式.建造者模式;

/**
 * 6.宝马汽车设计器
 * 　　这里通过有参构造器将宝马汽车构造器注入进来，
 * 在directorCar()内进行汽车组件的获取和组装等操作，
 * 最后返回一个组装设计完好的宝马汽车
 */
public class BwmDirector implements CarDirector{
    private CarBuilder builder;
    public BwmDirector(CarBuilder builder) {
        this.builder  = builder;
    }

    @Override
    public Car directorCar() {
        //获取组件
        Engine engine = builder.builderEngine();
        Tyre tyre = builder.builderTyre();
        Frame frame = builder.builderFrame();
        //组装构建bwm汽车
        Car bwmCar = new Car();
        bwmCar.setEngine(engine);
        bwmCar.setTyre(tyre);
        bwmCar.setFrame(frame);

        return bwmCar;

    }
}
