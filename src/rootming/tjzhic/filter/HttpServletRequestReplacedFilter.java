package rootming.tjzhic.filter;

import rootming.tjzhic.utils.BodyReaderHttpServletRequestWrapper;
import rootming.tjzhic.utils.HttpHelper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by rootm on 2017/3/25.
 */
@WebFilter(filterName = "HttpServletRequestReplacedFilter")
public class HttpServletRequestReplacedFilter implements Filter {
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain) throws IOException, ServletException {


        ServletRequest requestWrapper = new BodyReaderHttpServletRequestWrapper((HttpServletRequest) req);
        String body = HttpHelper.getBodyString(requestWrapper);

        chain.doFilter(requestWrapper, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
