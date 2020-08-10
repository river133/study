package 网络编程.RPC.rpc07;

import com.caucho.hessian.io.Hessian2Output;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
//采用Hessian2Output序列化
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

        //序列化
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Hessian2Output output = new Hessian2Output(baos);
        output.writeObject(o);
        output.flush();

        byte[] bytes = baos.toByteArray();
        OutputStream outt = s.getOutputStream();
        outt.write(bytes);
    }
}
