package java设计模式.观察者设计模式.t2;

public interface Observable {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObserver(String content,int stopNumber);
}
