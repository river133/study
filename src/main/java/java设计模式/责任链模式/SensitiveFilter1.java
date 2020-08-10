package java设计模式.责任链模式;

public class SensitiveFilter1 implements Filter{
    @Override
    public boolean doFilter(Msg m) {
        String r = m.getMsg();
        r = r.replace("996","955");
        m.setMsg(r);
        return false;
    }
}
