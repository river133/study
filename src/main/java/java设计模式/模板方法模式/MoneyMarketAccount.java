package java设计模式.模板方法模式;
//具体模板角色类
public class MoneyMarketAccount extends Account{
    @Override
    protected String doCalculateAccountType() {
        return "Money Market";
    }

    @Override
    protected double doCalculateInterestRate() {
        return 0.045;
    }
}
