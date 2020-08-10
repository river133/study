package 网络编程.RPC.rpc04;

import org.example.IUserService;
import org.example.User;

public class Client {
    public static void main(String[] args) throws Exception {
      t1();//调用方法1：findUserById
    }
    public static void t1(){
        //生成代理对象
        IUserService service = Stub.getStub();
        User userById = service.findUserById(111);
        User user1 = service.findUserById(111);
                System.out.println(user1);

//        User user2 = service.findUserById(111,"测试调用重载的方法");
//        System.out.println(user2);
    }
}
