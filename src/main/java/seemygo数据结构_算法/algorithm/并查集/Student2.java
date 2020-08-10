package seemygo数据结构_算法.algorithm.并查集;

public class Student2 {
    protected int age;
    protected String name;

    public Student2(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return age+"_"+name;
    }
}
