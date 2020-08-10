package java设计模式.装饰者模式;
//具体构件角色,普通男人
public class NormalMan implements Man{
    private String name = null;

    public NormalMan(String name) {
        this.name = name;
    }

    @Override
    public String getManDesc() {
        return name+":";
    }
}
