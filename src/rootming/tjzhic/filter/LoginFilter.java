package rootming.tjzhic.filter;

import rootming.tjzhic.Wrapper.AuthenticationRequestWrapper;
import rootming.tjzhic.utils.LogUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by rootming on 2017/3/4.
 * 登陆过滤器
 */
@WebFilter(filterName = "LoginFilter")
public class LoginFilter implements Filter {

    @Override
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest)req;

        AuthenticationRequestWrapper authenticationRequestWrapper = new AuthenticationRequestWrapper(request);
        HttpSession session = authenticationRequestWrapper.getSession();


        if(session != null && session.getAttribute("email") != null) {
            LogUtils.log((String) session.getAttribute("email"));
            chain.doFilter(authenticationRequestWrapper, resp);
        }
        else {
            LogUtils.log("No Permission access.");
            authenticationRequestWrapper.setAttribute("message", "登陆以继续操作");
            authenticationRequestWrapper.getRequestDispatcher("login.jsp").forward(authenticationRequestWrapper, resp);
            //((HttpServletResponse)resp).sendRedirect(request.getContextPath() + "/login.jsp");
        }

    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
