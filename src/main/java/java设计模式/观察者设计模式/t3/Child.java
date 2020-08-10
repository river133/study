package java设计模式.观察者设计模式.t3;

import java.util.ArrayList;
import java.util.List;

/**
 * 分离观察者与被观察者
 */
class Child{
    private boolean cry=false;
    private List<Observer2> observers=new ArrayList<>();
    {
        observers.add(new Dad());
        observers.add(new Mum());
    }

    public boolean isCry(){return cry;}

    //发出醒来提醒
    public void wakeUp(){
        cry=true;
        //哭的具体事件
        wakUpEvent event = new wakUpEvent(System.currentTimeMillis(),"bed",this);

        for(Observer2 o:observers){
            o.actionOnWakeUP(event);
        }
    }
}
