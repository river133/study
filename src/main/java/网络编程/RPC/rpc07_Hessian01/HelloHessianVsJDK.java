package 网络编程.RPC.rpc07_Hessian01;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;
import org.example.User;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;

public class HelloHessianVsJDK {
    public static void main(String[] args) throws Exception{
        User u = new User(1, "a");
        System.out.println("hessian: "+hessianSerialIze(u).length);//31
        System.out.println("jdk:"+jdkSerialize(u).length);//173
    }
    //hessian序列化字节数组
    public static byte[] hessianSerialIze(Object o) throws Exception{
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Hessian2Output output = new Hessian2Output(baos);
        output.writeObject(o);
        output.flush();

        byte[] bytes = baos.toByteArray();
        baos.close();
        output.close();
        return bytes;
    }
    //反序列化
    public static Object hessianDeSerialIze(byte[]bytes)throws Exception{
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        Hessian2Input input = new Hessian2Input(bais);
        Object o = input.readObject();
        bais.close();
        input.close();
        return o;
    }
    //JDK序列化字节数组
    public static byte[] jdkSerialize(Object o)throws Exception{
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream output = new ObjectOutputStream(baos);
        output.writeObject(o);
        output.flush();

        byte[] bytes = baos.toByteArray();
        baos.close();
        output.close();
        return bytes;
    }
}
