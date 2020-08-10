package java设计模式.责任链模式;

import java.util.ArrayList;
import java.util.List;

//过滤链
public class FilterChain implements Filter{
    List<Filter> filters = new ArrayList<>();
    public FilterChain add(Filter f){
        filters.add(f);
        return this;
    }
    public boolean doFilter(Msg msg){
        for (Filter f : filters) {
           if(!f.doFilter(msg)) return false;
        }
        return true;
    }
}
