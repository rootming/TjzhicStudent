package rootming.tjzhic.handle;

import rootming.tjzhic.utils.JSONDataUtils;
import rootming.tjzhic.utils.LogUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by rootm on 2017/3/12.
 */
@WebServlet(name = "DataHandle")
public class DataHandle extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cmd;
        String group;
        HttpSession session = request.getSession();

        cmd = request.getParameter("cmd");
        group = (String)session.getAttribute("group");

        LogUtils.log("Post param: " + cmd + ", Group: " + group);
        if(cmd != null) {
            String data = null;
            try {
                JSONDataUtils json = new JSONDataUtils();
                data = json.queryData(cmd, group);
            } catch (InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
            response.getWriter().write(data);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
