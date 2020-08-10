package 网络编程.RPC.rpc06;

import com.caucho.hessian.io.Hessian2Output;
import org.example.IUserService;

import java.io.*;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
//实现调用任意接口
public class Server {
    private static boolean running = true;
    public static void main(String[] args) throws Exception {

        ServerSocket ss = new ServerSocket(8888);
        while (running){
            System.out.println("服务器端等待连接...");
            Socket s = ss.accept();
            process(s);
            s.close();
        }
        ss.close();
    }

    //读取操作
    private static void process(Socket s)throws Exception{
        InputStream in = s.getInputStream();
        OutputStream out = s.getOutputStream();

        ObjectInputStream ois = new ObjectInputStream(in);

        //读取客户端发来的方法参数
        String clazzName = ois.readUTF();
        String methodName = ois.readUTF();
        Class[] parameterType  =(Class[]) ois.readObject();
        Object[] args  =(Object[]) ois.readObject();

        //从服务器注册表找到具体实现接口的类
        Class clazz = null;
//        clazz = IProductServiceImpl.class;//任意切换接口调用
        clazz = UserServiceImpl.class;//任意切换接口调用

        Method method = clazz.getMethod(methodName, parameterType);
        Object o = method.invoke(clazz.newInstance(), args);

        ObjectOutputStream oos = new ObjectOutputStream(out);
        oos.writeObject(o);//发送方法调用后的返回值
        oos.flush();
    }
}
