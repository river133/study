package java设计模式.适配器模式;

public class Main {
    public static void main(String[] args) {
//     t1();
     t2();
    }
    private static void t1(){
        //创建源对象（被适配的对象）
        Adaptee adaptee = new Adaptee();
        //利用源对象创建一个适配器对象，提供客户端调用的方法
        Adapter adapter = new Adapter(adaptee);
        System.out.println("客户端调用适配器中的方法......");
        adapter.request();
    }
    private static void t2(){
        Target target =(Target) ReadXML.getObject();
        target.request();
    }
}
