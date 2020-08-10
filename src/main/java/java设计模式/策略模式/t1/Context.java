package java设计模式.策略模式.t1;
//用一个context类来维护对抽象算法类Strategy对象的引用(重点)
public class Context {
    Strategy strategy;
    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public void ContrxtInterface(){
        strategy.AlgorithmInterface();
    }
}
