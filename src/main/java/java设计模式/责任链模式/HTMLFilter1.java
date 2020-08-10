package java设计模式.责任链模式;

public class HTMLFilter1 implements Filter{
    @Override
    public boolean doFilter(Msg m) {
        String r = m.getMsg();
        r = r.replace('<','[');
        r = r.replace('>',']');
        m.setMsg(r);
        return true;
    }
}
