package java设计模式.观察者设计模式.t3;

class Dad implements Observer2{
    public void feed(){
        System.out.println("dad feeding...");
    }
    //根据事件类型处理
    @Override
    public void actionOnWakeUP(wakUpEvent event) {
        if(event.loc.equals("bed")){
            feed();
        }
    }
}
