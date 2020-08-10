package java设计模式.策略模式.t1;

public class Main {
    public static void main(String[] args) {
        t1();
    }
    private static void t1(){
        Context context = null;
        context = new Context(new AlgorithmA());
        context.ContrxtInterface();

        context = new Context(new AlgorithmB());
        context.ContrxtInterface();
    }
}
