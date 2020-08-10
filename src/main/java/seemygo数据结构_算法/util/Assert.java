package seemygo数据结构_算法.util;

public class Assert {
    public static void test(boolean value){
        try {
            if(!value) throw new IllegalAccessException("测试异常");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
