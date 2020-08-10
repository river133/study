package java设计模式.观察者设计模式.t3;

//事件类
class wakUpEvent{
    long timestamp;//哭的时间事件
    String loc;//哭的地点事件
    Child source;//事件原对象

    public wakUpEvent(long timestamp, String loc, Child source) {
        this.timestamp = timestamp;
        this.loc = loc;
        this.source = source;
    }
}
