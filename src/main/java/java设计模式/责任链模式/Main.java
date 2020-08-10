package java设计模式.责任链模式;

public class Main {
    public static void main(String[] args) {
        Msg msg = new Msg();
        msg.setMsg("大家好:) <script>,欢迎baidu.com，大家都是996");

        //过滤链1
        FilterChain fc1 = new FilterChain();
        fc1.add(new HTMLFilter1())
                .add(new SensitiveFilter1());

        //过滤链2
        FilterChain fc2 = new FilterChain();
        fc2.add(new FaceFilter2())
                .add(new URLFilter2());

//        fc1.doFilter(msg);
//        fc2.doFilter(msg);
        fc1.add(fc2);
        fc1.doFilter(msg);

        System.out.println(msg);
    }
}
