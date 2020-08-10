package java设计模式.抽象工厂模式;
//空调以及型号
public class AirconditionB implements Aircondition{
    @Override
    public void printAircondition() {
        System.out.println("制造-->AirconditionB525");
    }
}
