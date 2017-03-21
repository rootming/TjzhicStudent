package rootming.tjzhic.handle;

import rootming.tjzhic.model.User;
import rootming.tjzhic.utils.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;

/**
 * Created by rootming on 2017/2/25.
 */
@WebServlet(name = "LoginHandle")
public class LoginHandle extends HttpServlet {

    private static HashSet<String> map = new HashSet<>();

    public static int getActiveSessions() {
        return map.size();
    }

    public static void remove(String email) {
        map.remove(email);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email;
        String password;
        HttpSession session = request.getSession();
        //request.setCharacterEncoding("UTF-8");

        LogUtils.log("LoginHandle");
        email = request.getParameter("email");
        password = request.getParameter("password");
        if(email != null && password != null) {
            password = RegisterUtils.getEnPassword(password);
            User user = null;
            System.out.println(email);
            System.out.println(password);
            try {
                user = (User) ModelUtils.queryObject(User.class, email);
            } catch (NoSuchMethodException | InvocationTargetException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
            }


            if (user != null && user.getPassword().equals(password)) {
                LogUtils.log(request.getRemoteAddr(), "Login successful");
                session.setAttribute("email", user.getEmail());
                session.setAttribute("name", user.getName());
                session.setAttribute("group", user.getGroup());
                session.setAttribute("regTime", user.getRegTime());
                map.add(user.getEmail());
                LogUtils.addLoginInfo(user, request.getRemoteAddr());
                response.sendRedirect("console.jsp");
            }
        }
        else {
            LogUtils.log(request.getRemoteAddr(),"Login failed");
            request.setAttribute("message", "没有找到该邮箱或密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
//
//        if(UserUtils.find(email)) {
//            if(RegisterUtils.passwordCheck(RegisterUtils.getEnPassword(password), UserUtils.getAdminStorePasswordFromEmail(email))) {
//                LogUtils.log("Login successful");
//                session.setAttribute("email", email);
//                session.setAttribute("password", password);
//                response.sendRedirect("console.jsp");
//            }
//            else {
//                LogUtils.log("Login failed");
//                LogUtils.log("Password wrong");
//                LogUtils.log(password);
//                LogUtils.log(RegisterUtils.getEnPassword(password));
//                LogUtils.log(UserUtils.getAdminStorePasswordFromEmail(email));
//                request.setAttribute("message", "没有找到该用户或密码错误");
//                request.getRequestDispatcher("login.jsp").forward(request, response);
//            }
//        }
//        else {
//            LogUtils.log("Login failed");
//            LogUtils.log("User not found");
//            request.setAttribute("message", "没有找到该用户或密码错误");
//            request.getRequestDispatcher("login.jsp").forward(request, response);
//        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LogUtils.log(request.getRemoteAddr(), "Wrong method access.");
        request.setAttribute("message", "登陆以继续操作");
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
