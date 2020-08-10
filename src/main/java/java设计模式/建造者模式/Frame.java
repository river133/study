package java设计模式.建造者模式;

//车架类
class Frame {
    private String name;
    public Frame(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
