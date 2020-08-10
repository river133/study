package java设计模式.装饰者模式;
//抽象装饰者角色
// 附加属性装饰者
public abstract class AbstractDecorator implements Man{
    private Man man;

    public AbstractDecorator(Man man) {
        this.man = man;
    }

    public String getManDesc() {
        return man.getManDesc();
    }
}
