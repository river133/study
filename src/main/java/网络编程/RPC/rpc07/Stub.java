package 网络编程.RPC.rpc07;

import com.caucho.hessian.io.Hessian2Input;
import org.example.IUserService;

import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

//实现调用任意接口
public class Stub {
    public static Object getStub(Class clazz){
        InvocationHandler h = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Socket s = new Socket("127.0.0.1", 8888);

                ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());

                String clazzName = clazz.getName();
                String methodName = method.getName();
                Class<?>[] parameterTypes = method.getParameterTypes();

                //将方法参数与类名发送到服务器
                oos.writeUTF(clazzName);
                oos.writeUTF(methodName);
                oos.writeObject(parameterTypes);
                oos.writeObject(args);
                oos.flush();

                //读取
                InputStream in = s.getInputStream();
                Hessian2Input input = new Hessian2Input(in);
                Object o = input.readObject();
                input.close();
                return o;
            }
        };
        //生成代理对象
        return Proxy.newProxyInstance(IUserService.class.getClassLoader()
                , new Class[]{clazz}, h);
    }
}
