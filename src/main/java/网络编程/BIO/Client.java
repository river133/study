package 网络编程.BIO;

import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("127.0.0.1", 8888);
        //发送数据
        s.getOutputStream().write("hello".getBytes());
        s.getOutputStream().flush();

        //读取数据
        byte[] bytes = new byte[1024];
        System.out.println("等待读取...");
        int len = s.getInputStream().read(bytes);
        System.out.println("接收服务器端数据："+new String(bytes,0,len));
        s.close();

    }
}
