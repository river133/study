package java设计模式.建造者模式;

/**
 *  汽车构建器接口
 */
public interface CarBuilder {
    //构建汽车引擎
    public Engine builderEngine();
    //构建汽车轮胎
    public Tyre builderTyre();
    //构建汽车车架
    public Frame builderFrame();
}
