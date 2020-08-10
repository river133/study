package java设计模式.观察者设计模式.t1;

import java.util.Observable;
import java.util.Observer;

//观察者主题对象
class BeingWatched extends Observable{

    void counter(int number){
        for(; number>=0; number--){
            this.setChanged();
            this.notifyObservers(number);
        }
    }
}

//观察者1
class Watcher1 implements Observer{
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Watcher1 -> count is:"+arg);
    }
}

//观察者2
class Watcher2 implements Observer{
    @Override
    public void update(Observable o, Object arg) {
        if(((Integer)arg).intValue() <= 5){
        System.out.println("Watcher2 -> count is : "+arg);
        }
    }
}

public class TwoObservers extends Observable {
    public static void main(String[] args) {
        //主题对象
        BeingWatched watched = new BeingWatched();
        //添加观察者
        Watcher1 w1 = new Watcher1();
        Watcher2 w2 = new Watcher2();
        watched.addObserver(w1);
        watched.addObserver(w2);

        watched.counter(10);
    }
}
