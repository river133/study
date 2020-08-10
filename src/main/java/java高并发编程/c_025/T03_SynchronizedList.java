package java高并发编程.c_025;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class T03_SynchronizedList {
    public static void main(String[] args) {
    List<String> strs =  new ArrayList();
        List<String> strSync = Collections.synchronizedList(strs);

    }
}
