package rootming.tjzhic.handle;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import rootming.tjzhic.Config;
import rootming.tjzhic.Wrapper.AuthenticationRequestWrapper;
import rootming.tjzhic.utils.APIUtils;
import rootming.tjzhic.utils.LogUtils;
import rootming.tjzhic.utils.SecurityUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by rootm on 2017/3/13.
 */


class JSONData {
    private String cmd;
    private String arg;

    public JSONData() {
    }

    public JSONData(String cmd, String arg) {
        this.cmd = cmd;
        this.arg = arg;
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String getArg() {
        return arg;
    }

    public void setArg(String arg) {
        this.arg = arg;
    }
}

@WebServlet(name = "APIHandle")
public class APIHandle extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String cmd;
//        String arg;
        AuthenticationRequestWrapper authenticationRequestWrapper = new AuthenticationRequestWrapper(request);

        String group;
        String data, result;
        Gson gson = new Gson();
        HttpSession session = authenticationRequestWrapper.getSession();

        LogUtils.log("Get API request.");

//        cmd = request.getParameter("cmd");
//        arg = request.getParameter("arg");
        group = (String)session.getAttribute("group");

        if (group == null) {
            LogUtils.log("No permission access API");
            response.getWriter().write(Config.JSONError);
            return;
        }
//        LogUtils.log("Post param: " + cmd + ", Group: " + group);
//        if(cmd != null) {
//            String data = null;
//
//            APIUtils api = new APIUtils();
//            try {
//                data = api.doAPI(cmd, arg, group);
//            } catch (InvocationTargetException | IllegalAccessException e) {
//                e.printStackTrace();
//            }
//
//            response.getWriter().write(data);
//        }

        BufferedReader br = new BufferedReader(new InputStreamReader(authenticationRequestWrapper.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            sb.append(line);
        }

        data = sb.toString();
        br.close();

        if (!SecurityUtils.isSql(data)) {
            if (!data.equals("")) {

                LogUtils.log("Post param: " + data + ", Group: " + group);

                JSONData jsonData = gson.fromJson(data, JSONData.class);
                APIUtils api = new APIUtils();

                try {
                    result = api.doAPI(jsonData.getCmd(), jsonData.getArg().replace("\\", ""), group);
                    response.getWriter().write(result);
                } catch (InvocationTargetException | IllegalAccessException e) {
                    e.printStackTrace();
                    LogUtils.log("Get JSON Object error");
                    response.getWriter().write(Config.JSONError);
                }
            } else {
                LogUtils.log("Post param is empty");
                response.getWriter().write(Config.JSONError);
            }
        } else {
            LogUtils.log("检测到SQL关键词");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
