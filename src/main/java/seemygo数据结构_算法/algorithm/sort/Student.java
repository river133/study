package seemygo数据结构_算法.algorithm.sort;


public class Student implements Comparable<Student>{
    protected int score;
    protected int age;

    public Student(int score, int age) {
        this.score = score;
        this.age = age;
    }

    @Override
    public int compareTo(Student o) {
        return this.score-o.score;
    }
}
