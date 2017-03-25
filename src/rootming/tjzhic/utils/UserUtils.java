package rootming.tjzhic.utils;

import org.jetbrains.annotations.Contract;
import rootming.tjzhic.model.User;

import java.util.List;

/**
 * Created by rootming on 2017/2/27.
 */

public class UserUtils {
    //  检查user的邮箱是否存在
    @Contract("null -> false")
    public static boolean isExistedEmail(String email){
        if(email == null) {
            return false;
        }

        final String sqlStr = "SELECT user_email FROM user WHERE user_email=?";
        final String arg[];
        arg = new String[1];
        arg[0] = email;
        DatabaseUtils databaseUtils = new DatabaseUtils();
        List result = databaseUtils.executeQuery(sqlStr, arg);
        return result.size() > 0;
    }

    //  检查user的名称是否存在
    @Contract("null -> false")
    public static boolean isExistedName(String name){
        if(name == null) {
            return false;
        }

        final String sqlStr = "SELECT user_name FROM user WHERE user_name=?";
        final String arg[];
        arg = new String[1];
        arg[0] = name;
        DatabaseUtils databaseUtils = new DatabaseUtils();
        List result = databaseUtils.executeQuery(sqlStr, arg);
        return result.size() > 0;
    }


    // 测试user的输入信息是否合法
    private boolean isUserExisted(User user) {
        return isExistedEmail(user.getEmail()) &&
                isExistedName(user.getName());
    }

    @Contract(value = "null -> false; !null -> true", pure = true)
    private boolean addUser(User user) {
        if(user == null) {
            return false;
        }

        final String arg[];

        final String sqlStr = "INSERT INTO user (user_email, user_name, user_password, user_group, user_ip) VALUES (?, ?, ?, ?, ?)";
        return true;
    }

    @Contract(value = "_, _ -> true", pure = true)
    private boolean modUser(User orgUser, User newUser) {
        return true;
    }

    public boolean delUser(String email) {
        return true;
    }

    // 注册user的账户
    @Contract("null -> false")
    public boolean register(User user) {
        if(user != null && isUserExisted(user)) {
            if(addUser(user))
                LogUtils.log(UserUtils.class, "用户注册成功");
            return true;
        }

        LogUtils.log(UserUtils.class, "用户注册失败");
        return false;

    }

    public boolean loginCheck(User user) {
        if(user != null) {
            if(isExistedEmail(user.getEmail())) {
                RegisterUtils passwordUtils = new RegisterUtils();
                if(passwordUtils.isPasswordValid(user)) {
                    LogUtils.log(UserUtils.class, "Password is confirm");
                    return true;
                }
                else {
                    LogUtils.log(UserUtils.class, "Password is invalid");
                    return false;
                }
            }
            else {
                LogUtils.log(UserUtils.class, "Email: " + user.getEmail() + " not found");
                return false;
            }
        }
        return false;
    }


    public static void main(String args[]) {
        if(UserUtils.isExistedEmail("rootming@live.cn")) {
            System.out.println("邮箱已存在");
        }
        else {
            System.out.println("可注册的邮箱");
        }
    }
}
