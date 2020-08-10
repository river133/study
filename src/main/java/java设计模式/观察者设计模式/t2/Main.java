package java设计模式.观察者设计模式.t2;

public class Main {
    public static void main(String[] args) {
        BusDriver busDriver = new BusDriver();
        Observer xiaoHong = new PassengerXiaoHong(busDriver);
        Observer xiaoZhang = new PassengerXiaoWang(busDriver);

        busDriver.addObserver(xiaoHong);
        busDriver.addObserver(xiaoZhang);

        for (int i = 0; i < 10; i++) {
            busDriver.drive();
            busDriver.stop();
        }
    }
}
