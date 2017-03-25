package rootming.tjzhic.filter;

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
        HttpSession session = request.getSession();
        if(session != null && session.getAttribute("email") != null) {
            LogUtils.log(LoginFilter.class, (String) session.getAttribute("email"));
            chain.doFilter(req, resp);
        }
        else {
            LogUtils.log(LoginFilter.class, "No Permission access.");
            req.setAttribute("message", "登陆以继续操作");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
            //((HttpServletResponse)resp).sendRedirect(request.getContextPath() + "/login.jsp");
        }

    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
