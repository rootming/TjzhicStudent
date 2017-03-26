package rootming.tjzhic.filter;

import rootming.tjzhic.Wrapper.AuthenticationRequestWrapper;
import rootming.tjzhic.utils.LogUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by rootming on 2017/3/4.
 * 编码过滤器
 */
public class EncodeFilter implements Filter {

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        servletRequest.setCharacterEncoding("utf-8");

        AuthenticationRequestWrapper authenticationRequestWrapper = new AuthenticationRequestWrapper((HttpServletRequest) servletRequest);

        LogUtils.log("Set Character Encoding");
        authenticationRequestWrapper.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        filterChain.doFilter(authenticationRequestWrapper, servletResponse);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }
}
