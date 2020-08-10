package java设计模式.建造者模式;

//引擎类
class Engine {
    private String name;
    public Engine(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}