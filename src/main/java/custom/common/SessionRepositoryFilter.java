package custom.common;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@WebFilter("/*")
public class SessionRepositoryFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        SessionRepositoryRequestWrapper customRequest = new SessionRepositoryRequestWrapper(httpServletRequest);
        filterChain.doFilter(customRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
