package java设计模式.建造者模式;
//汽车组件类，声明汽车各种组件
public class Car {
    private Engine engine;//引擎
    private Tyre tyre;//轮胎
    private Frame frame;//车架

    public Engine getEngine() {
        return engine;
    }
    public void setEngine(Engine engine) {
        this.engine = engine;
    }
    public Tyre getTyre() {
        return tyre;
    }
    public void setTyre(Tyre tyre) {
        this.tyre = tyre;
    }
    public Frame getFrame() {
        return frame;
    }
    public void setFrame(Frame frame) {
        this.frame = frame;
    }
}
