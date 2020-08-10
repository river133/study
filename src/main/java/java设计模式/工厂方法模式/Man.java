package java设计模式.工厂方法模式;

public class Man {
    public static void main(String[] args) {

        //生产ibm电脑
        ComputerFactory ibmFactory = new IbmFactory();
        Computer ibm = ibmFactory.createComputer();
        ibm.Product();

//        //生产mac电脑
        ComputerFactory macFactory = new MacFactory();
        Computer mac = macFactory.createComputer();
        mac.Product();
    }
}
