package rootming.tjzhic.handle;

import rootming.tjzhic.Config;
import rootming.tjzhic.model.User;
import rootming.tjzhic.utils.LogUtils;
import rootming.tjzhic.utils.ModelUtils;
import rootming.tjzhic.utils.RegisterUtils;
import rootming.tjzhic.utils.UserUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by rootming on 2017/2/27.
 */
@WebServlet(name = "RegisterHandle")
public class RegisterHandle extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name;
        String email;
        String password;
        String confirmPassword;
        String code;


        HttpSession session = request.getSession();
        request.setCharacterEncoding("UTF-8");

        LogUtils.log(RegisterHandle.class, "RegisterHandle");

        name = request.getParameter("username");
        email = request.getParameter("email");
        password = request.getParameter("password");
        confirmPassword = request.getParameter("confirmpassword");
        code = request.getParameter("code");

        if(code == null || code.equals("")) {
            LogUtils.log(RegisterHandle.class, "Code is empty");
            request.setAttribute("message", "请输入验证码");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        if(UserUtils.isExistedEmail(email)) {
            LogUtils.log(RegisterHandle.class, "Email address is existed");
            LogUtils.log(RegisterHandle.class, "Email address: " + email);
            request.setAttribute("message", "邮箱已存在");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

//        if(UserUtils.isExistedName(name)) {
//            LogUtils.log("Name is existed");
//            LogUtils.log("Name : " + name);
//            request.setAttribute("message", "昵称已存在");
//            request.getRequestDispatcher("register.jsp").forward(request, response);
//            return;
//        }

        if(!password.equals(confirmPassword)) {
            LogUtils.log(RegisterHandle.class, "Password is different");
            LogUtils.log(RegisterHandle.class, "Password1 : " + password);
            LogUtils.log(RegisterHandle.class, "Password2 : " + confirmPassword);
            request.setAttribute("message", "两次输入的密码不同");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            return;
        }

        if(!name.matches(Config.usernamePattern)) {
            LogUtils.log(RegisterHandle.class, "Username not Valid");
            request.setAttribute("message", "用户名不合法");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            return;
        }

        if(!email.matches(Config.emailPattern)) {
            LogUtils.log(RegisterHandle.class, "Email not Valid");
            request.setAttribute("message", "email不合法");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            return;
        }

        if(!password.matches(Config.passwordPattern)) {
            LogUtils.log(RegisterHandle.class, "Password not Valid");
            request.setAttribute("message", "密码不合法");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            return;
        }

        //admin = new Admin()
        User user = new User(email, name, password);
        if(ModelUtils.addObject(user)) {
            LogUtils.log(RegisterHandle.class, "Register success");
            LogUtils.log(RegisterHandle.class, "Name : " + name);
            LogUtils.log(RegisterHandle.class, "Email address: " + email);
            request.setAttribute("message", "注册成功, 登陆以继续操作");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
        else {
            LogUtils.log(RegisterHandle.class, "Register failed");
            LogUtils.log(RegisterHandle.class, "Name : " + name);
            LogUtils.log(RegisterHandle.class, "Email address: " + email);
            request.setAttribute("message", "注册失败, 系统错误");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("message", "注册信息有误");
        request.getRequestDispatcher("/register.jsp").forward(request, response);
    }

}
