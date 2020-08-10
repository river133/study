package java设计模式.观察者设计模式.t3;

class Mum implements Observer2{
    public void feed(){
        System.out.println("mun feeding...");
    }
    @Override
    public void actionOnWakeUP(wakUpEvent event) {
        feed();
    }
}
