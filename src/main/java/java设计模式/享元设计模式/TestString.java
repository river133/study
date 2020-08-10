package java设计模式.享元设计模式;

public class TestString {
    public static void main(String[] args) {
        String s1="abc";
        String s2="abc";
        String s3=new String("abc");
        String s4=new String("abc");

        System.out.println(s1==s2);
        System.out.println(s3==s1);
        // String.intern() 方法可以使得所有含相同内容的字符串都共享同一个内存对象
        System.out.println(s3.intern()==s1);
    }
}
