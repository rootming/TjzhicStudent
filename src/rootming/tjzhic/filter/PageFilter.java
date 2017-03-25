package rootming.tjzhic.filter;

import rootming.tjzhic.model.Menu;
import rootming.tjzhic.model.User;
import rootming.tjzhic.utils.LogUtils;
import rootming.tjzhic.utils.ModelUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;

/**
 * Created by rootming on 2017/3/6.
 * 页面访问权限过滤器
 */
@WebFilter(filterName = "PageFilter")
public class PageFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest)req;
        HttpSession session = request.getSession();
        if(     session != null &&
                session.getAttribute("email") != null &&
                session.getAttribute("group") != null) {
            try {
                LinkedList<Object> data = ModelUtils.queryObject(Menu.class, "menu_group", (String)session.getAttribute("group"));
                for(Object aData : data) {
                    String path = ((Menu)aData).getMenuUrl();
//                    System.out.println(path);
//                    System.out.println("req" + ((HttpServletRequest) req).getRequestURI());
                    if(path.equals(((HttpServletRequest) req).getRequestURI().substring(1))) {  //去除一个'/'
                        chain.doFilter(req, resp);
                        return;
                    }
                }
            } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
//            LogUtils.log((String)session.getAttribute("email"));
//            chain.doFilter(req, resp);
        }
//        else {
        LogUtils.log(PageFilter.class, "No Permission access.");
            ((HttpServletResponse)resp).sendRedirect(request.getContextPath() + "/login.jsp");
//        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
