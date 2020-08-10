package 网络编程.RPC.rpc03;

import org.example.IUserService;
import org.example.User;

public class Client {
    public static void main(String[] args) throws Exception {
//      t1();
    }
    public static void t1(){
        //生成代理对象
        IUserService service = Stub.getStub();
        User user = service.findUserById(456);
        System.out.println(user);
    }
}
