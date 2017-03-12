package rootming.tjzhic.handle;

import rootming.tjzhic.utils.JSONDataUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by rootm on 2017/3/12.
 */
@WebServlet(name = "DataHandle")
public class DataHandle extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cmd;
        cmd = request.getParameter("cmd");
        if(cmd != null && cmd.equals("get_state")) {
            String data = JSONDataUtils.get_state();
            response.getWriter().write(data);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
