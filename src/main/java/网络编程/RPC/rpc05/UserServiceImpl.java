package 网络编程.RPC.rpc05;

import org.example.IUserService;
import org.example.User;
//实现调用任意方法
public class UserServiceImpl implements IUserService {

    @Override
    public User findUserById(Integer id) {
        return new User(id,"zhang3");
    }
    @Override
    public User findUserById(Integer id,String name) {
        return new User(id,name);
    }

    @Override
    public void print() {
        System.out.println("print...");
    }
}
