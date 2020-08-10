package 网络编程.RPC.rpc07;

import org.example.IProductService;
import org.example.User;

public class IProductServiceImpl implements IProductService {
    @Override
    public User findUserById(Integer id) {
        return new User(id,"实现调用任意接口:IProductService");
    }
}
