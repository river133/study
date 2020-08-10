package java设计模式.策略模式.t2;

public class Main {
    public static void main(String[] args) {
        t1();
    }
    private static void t1(){
        //选择并创建需要使用的策略对象
//        MemberStrategy strategy = new PrimaryMemberStrategy();
        MemberStrategy strategy = new IntermediateMemberStrategy();
        //创建环境
        Price price = new Price(strategy);
        //计算价格
        double quote = price.quote(300);
        System.out.println("图书的最终价格为：" + quote);
    }
}
