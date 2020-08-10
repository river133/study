package seemygo数据结构_算法.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Times {
    private static final SimpleDateFormat fmt = new SimpleDateFormat("HH:mm:ss.SSS");
    public interface Task{
        void excute();
    }
    //测试耗时
    public static void test(String title,Task task){
        if(task==null)return;
        System.out.println(title);
        System.out.println("开始："+fmt.format(new Date()));
        long begin = System.currentTimeMillis();
        task.excute();
        long end = System.currentTimeMillis();
        System.out.println("结束："+fmt.format(new Date()));
        double delta = (end-begin)/1000.0;
        System.out.println("耗时："+delta+"秒");
        System.out.println("----------------");
    }
}
