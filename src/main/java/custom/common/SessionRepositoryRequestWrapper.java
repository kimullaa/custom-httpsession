package custom.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;


public class SessionRepositoryRequestWrapper extends HttpServletRequestWrapper {
    public SessionRepositoryRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public HttpSession getSession() {
        return getSession(true);
    }

    @Override
    public HttpSession getSession(boolean create) {
        //自作のHttpSessionをセットする
        return new HttpSessionSpy(super.getSession(create));
    }
}
