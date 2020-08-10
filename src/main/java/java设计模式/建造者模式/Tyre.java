package java设计模式.建造者模式;

//轮胎类
class Tyre {
    private String name;
    public Tyre(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}