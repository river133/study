package 网络编程.RPC.rpc02;

import org.example.User;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        Stub stub = new Stub();
        User user = stub.findUserById(123);
        System.out.println(user);
    }
}
