package 网络编程.RPC.rpc05;

import org.example.IUserService;
import org.example.User;

import java.io.*;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
//实现调用任意方法
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

        String methodName = ois.readUTF();
        Class[] parameterType  =(Class[]) ois.readObject();
        Object[] args  =(Object[]) ois.readObject();

        //调用任意方法
        IUserService service = new UserServiceImpl();
        Method method = service.getClass().getMethod(methodName, parameterType);
        Object invoke = method.invoke(service, args);

        ObjectOutputStream oos = new ObjectOutputStream(out);
        oos.writeObject(invoke);
        oos.flush();
    }
}
