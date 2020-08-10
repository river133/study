package 网络编程.RPC.rpc05;

import org.example.IUserService;
import org.example.User;

import java.io.DataInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;
//实现调用任意方法
public class Stub {
    public static IUserService getStub(){
        InvocationHandler h = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Socket s = new Socket("127.0.0.1", 8888);

                ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());

                String methodName = method.getName();
                Class<?>[] parameterTypes = method.getParameterTypes();

                oos.writeUTF(methodName);
                oos.writeObject(parameterTypes);
                oos.writeObject(args);
                oos.flush();

                //读取
                ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
                Object o = ois.readObject();
                System.out.println(o);

                oos.close();
                s.close();
                return o;
            }
        };
        //生成代理对象
        Object o = Proxy.newProxyInstance(IUserService.class.getClassLoader()
                , new Class[]{IUserService.class}, h);
        return (IUserService)o;
    }
}
