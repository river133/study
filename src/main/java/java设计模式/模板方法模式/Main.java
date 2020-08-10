package java设计模式.模板方法模式;

public class Main {
    public static void main(String[] args) {
        t();
    }
    private static void t(){

        Account account = new MoneyMarketAccount();
        System.out.println("货币市场账号的利息数额为：" + account.TemplateMethod());
        account = new CDAccount();
//        System.out.println("定期账号的利息数额为：" + account.TemplateMethod());
    }
}
