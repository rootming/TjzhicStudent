package rootming.tjzhic.filter;

import rootming.tjzhic.utils.LogUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by rootming on 2017/3/9.
 * SQL注入过滤器
 */
@WebFilter(filterName = "SQLFilter")
public class SQLFilter implements Filter {
    private boolean isSql(String sql) {
        sql = sql.toLowerCase();
        String badKey = "'|and|exec|execute|insert|select|delete|update|count|drop|char|mid|master|truncate|char|declare|sitename|netuser|xp_cmdshell|or|like";
        String []badKeys = badKey.split("\\|");
        for (String badKey1 : badKeys) {
            if (sql.contains(badKey1)) {
                return true;
            }
        }
        return false;
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        Enumeration params = request.getParameterNames();
        String strSql = "";
        while(params.hasMoreElements()) {
            String name = params.nextElement().toString();
            String []value = request.getParameterValues(name);
            for (String aValue : value) {
                strSql = strSql + aValue;
            }
        }
        LogUtils.log(SQLFilter.class, "Params: " + strSql);
        if(isSql(strSql)) {
            LogUtils.log(SQLFilter.class, "检测到非法SQL注入");
            response.sendRedirect("/login.jsp");
        }
        else {
            LogUtils.log(SQLFilter.class, "SQL注入检测通过");
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }


}
