package 网络编程.RPC.rpc07;

import org.example.IProductService;
import org.example.IUserService;
import org.example.User;
//采用Hessian2Output序列化
//实现调用任意接口
public class Client {
    public static void main(String[] args) throws Exception {
      t1();//测试调用接口1
//      t2();//测试调用接口2
    }
    //测试调用接口1
    public static void t1(){
        //生成代理对象
        IUserService service = (IUserService) Stub.getStub(IUserService.class);
        User user1 = service.findUserById(111);
        System.out.println(user1);

    }
    ////测试调用接口2
    public static void t2(){
        //生成代理对象
        IProductService service = (IProductService) Stub.getStub(IProductService.class);
        User user1 = service.findUserById(111);
        System.out.println(user1);

    }
}
