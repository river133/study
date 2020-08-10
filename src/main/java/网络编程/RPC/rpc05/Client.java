package 网络编程.RPC.rpc05;

import org.example.IUserService;
import org.example.User;
//实现调用任意方法
public class Client {
    public static void main(String[] args) throws Exception {
        t2();//调用无参方法
    }
    public static void t1(){
        //生成代理对象
        IUserService service = Stub.getStub();
        User user1 = service.findUserById(111);
                System.out.println(user1);

        User user2 = service.findUserById(111,"测试调用重载的方法");
        System.out.println(user2);
    }
    //调用无返回方法
    public static void t2(){
        //生成代理对象
        IUserService service = Stub.getStub();
        service.print();
    }
}
