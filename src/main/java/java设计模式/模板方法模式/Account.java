package java设计模式.模板方法模式;
//　抽象模板角色类
public abstract class Account {
    /**
     * 模板方法，计算利息数额
     * @return    返回利息数额
     */
    public final double TemplateMethod(){
        double interestRate = doCalculateInterestRate();
        String accountType = doCalculateAccountType();
        if("Money Market".equals(accountType)){
             double amount = calculateAmount( accountType);
             return amount * interestRate;
        }
       return 0;
    }
    /**
     * 基本方法留给子类实现
     */
    protected abstract String doCalculateAccountType();
    /**
     * 基本方法留给子类实现
     */
    protected abstract double doCalculateInterestRate();
    /**
     * 基本方法，已经实现
     */
    public double calculateAmount(String accountType){
        /**
         * 省略相关的业务逻辑
         */
        return 7243.00;
    }
}
