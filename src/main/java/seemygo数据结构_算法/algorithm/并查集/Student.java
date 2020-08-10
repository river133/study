package seemygo数据结构_算法.algorithm.并查集;

public class Student{
    protected int age;
    protected String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return age+"_"+name;
    }
}
