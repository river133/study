package java设计模式.责任链模式;

public class URLFilter2 implements Filter{
    @Override
    public boolean doFilter(Msg m) {
        String r = m.getMsg();
        r = r.replace("baidu.com","goole.con");
        m.setMsg(r);
        return true;
    }
}
