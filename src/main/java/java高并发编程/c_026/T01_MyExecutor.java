package java高并发编程.c_026;

import java.util.concurrent.Executor;

public class T01_MyExecutor implements Executor {
    @Override
    public void execute(Runnable command) {
        command.run( );
    }

    public static void main(String[] args) {
        new T01_MyExecutor().execute(()-> System.out.println("executor"));
    }
}
