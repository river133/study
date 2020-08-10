package 网络编程.RPC.rpc03;

import org.example.User;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

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
        DataInputStream dis = new DataInputStream(in);
        DataOutputStream dos = new DataOutputStream(out);

        int id = dis.readInt();
        UserServiceImpl service = new UserServiceImpl();
        User user = service.findUserById(id);
        System.out.println("服务端读取："+user);

        dos.writeInt(user.getId());
        dos.writeUTF(user.getName());
        dos.flush();

    }

}
