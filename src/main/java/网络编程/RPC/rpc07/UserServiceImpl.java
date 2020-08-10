package 网络编程.RPC.rpc07;

import org.example.IUserService;
import org.example.User;

//实现调用任意接口
public class UserServiceImpl implements IUserService {

    @Override
    public User findUserById(Integer id) {
        return new User(id,"实现调用任意接口：IUserService");
    }
    @Override
    public User findUserById(Integer id,String name) {
        return new User(id,name);
    }

    @Override
    public void print() {

    }
}
