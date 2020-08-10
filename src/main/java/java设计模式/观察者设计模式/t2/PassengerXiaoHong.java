package java设计模式.观察者设计模式.t2;

public class PassengerXiaoHong implements Observer{
    private BusDriver busDriver;

    public PassengerXiaoHong(BusDriver busDriver) {
        this.busDriver = busDriver;
    }

    @Override
    public boolean update(String content,int stopNumber) {
        if("start".equals(content)&& stopNumber<3){
            System.out.println("小红：坐好");
        }
        if("stop".equals(content)&& stopNumber == 3){
            System.out.println("====小红：下车=====");
            return true;
        }
        return false;
    }
}
