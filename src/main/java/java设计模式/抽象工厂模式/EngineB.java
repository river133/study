package java设计模式.抽象工厂模式;
//发动机以及型号
public class EngineB implements Engine{
    @Override
    public void printEngine() {
        System.out.println("制造-->EngineB525");
    }
}
