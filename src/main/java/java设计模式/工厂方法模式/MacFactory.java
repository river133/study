package java设计模式.工厂方法模式;

public class MacFactory implements ComputerFactory {
    @Override
    public Computer createComputer() {
        return new Mac();
    }
}
