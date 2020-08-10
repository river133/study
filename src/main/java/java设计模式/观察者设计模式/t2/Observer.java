package java设计模式.观察者设计模式.t2;

public interface Observer {
    /**
     * 根据具体场景执行不同动作
     * @param action 动作
     * @param stopNumber 站名
     */
    boolean update(String action,int stopNumber);
}
