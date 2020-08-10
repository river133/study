package 网络编程.RPC.rpc03;

import org.example.IUserService;
import org.example.User;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

public class Stub {
    public static IUserService getStub(){
        InvocationHandler h = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Socket s = new Socket("127.0.0.1", 8888);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                DataOutputStream dos = new DataOutputStream(baos);
                System.out.println((int) args[0]);
                dos.writeInt((int) args[0]);

                //输出,int转为字节数组
                s.getOutputStream().write(baos.toByteArray());
                s.getOutputStream().flush();

                //读取
                DataInputStream dis = new DataInputStream(s.getInputStream());
                int id = dis.readInt();
                String name = dis.readUTF();
                User user = new User(id, name);

                dos.close();
                s.close();
                return user;
            }
        };
        //生成代理对象
        Object o = Proxy.newProxyInstance(IUserService.class.getClassLoader()
                , new Class[]{IUserService.class}, h);
        return (IUserService)o;
    }
}
