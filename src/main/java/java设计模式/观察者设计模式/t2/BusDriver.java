package java设计模式.观察者设计模式.t2;

import java.util.ArrayList;
import java.util.List;

public class BusDriver implements Driver,Observable{
    int i=0;//站点
    private List<Observer> observers =new ArrayList<>();

    @Override
    public void drive() {
        System.out.println("司机说：车启动了...");
        i++;
        notifyObserver("start",i);
    }

    @Override
    public void stop() {
        System.out.println("司机说：到"+i+"站了，下一站："+(i+1));
        notifyObserver("stop",i);
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObserver(String action, int stopNumber) {
        for(Observer o:observers){
            o.update(action,stopNumber);
        }
    }
}
