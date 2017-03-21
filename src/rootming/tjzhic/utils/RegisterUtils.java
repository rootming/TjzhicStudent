package rootming.tjzhic.utils;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;
import rootming.tjzhic.Config;
import rootming.tjzhic.model.User;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;

/**
 * Created by rootming on 2017/2/25.
 */
public class RegisterUtils {

    private static String base64encode(String raw) {
        String result = "";
        try {
            result = Base64.getEncoder().encodeToString(raw.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static String base64decode(String raw) {
        String result;
        result = new String(Base64.getDecoder().decode(raw));
        return result;
    }

    @Nullable
    private static String getMD5(String str) {
        final String MD5 = "MD5";
        StringBuffer buf = new StringBuffer("");

        byte[] bytes = null;
        try {

            MessageDigest md = MessageDigest.getInstance(MD5);
            md.update(str.getBytes());
            bytes = md.digest();

            for (byte aByte : bytes) {
                int i;
                i = aByte;
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
        } catch (NoSuchAlgorithmException e) {
            System.out.println("加密算法: " + MD5 + " 不存在: ");
        }

        if(bytes != null)
            return new String(buf);
        else
            return null;
    }

    // 加密传入的密码
    public static String getEnPassword(String raw) {
        String result;
        result = getMD5(base64encode(raw));
        return result;

    }

    //  获取user加密后的密码
    private  String getStoredEnPassword(String email) {
        final String sqlStr = "SELECT user_password FROM user WHERE user_email=?";
        final String arg[];
        arg = new String[1];
        arg[0] = email;
        DatabaseUtils databaseUtils = new DatabaseUtils();
        List result = databaseUtils.executeQuery(sqlStr, arg);
        HashMap data = (HashMap)result.get(0);

        return (String)data.get("user_password");
    }

    // 检查密码是否匹配
    @Contract(value = "null, _ -> false; !null, null -> false", pure = true)
    private boolean passwordCheck(String targetPassword, String storePassword) {
        return targetPassword != null && storePassword != null && storePassword.equals(targetPassword);

    }

    // 检查密码是否匹配
    public boolean isPasswordValid(User user) {
        return passwordCheck(getEnPassword(user.getPassword()),
                            getStoredEnPassword(user.getEmail()));
    }



    static public boolean checkUsernameVaild(String username) {
        return Config.usernamePattern.matches(username);
    }


    static public boolean checkEmailVaild(String email) {
        return Config.emailPattern.matches(email);
    }


    static public boolean checkPasswordVaild(String password) {
        return Config.passwordPattern.matches(password);
    }


    public static void main(String args[]) {
        String str = base64encode("rootming");
        System.out.println("Base64 encode: " + str);
        System.out.println("Base64 decode: " + base64decode(str));
        System.out.println("MD5 encode: " + getMD5("rootming"));
        System.out.println("Password encode: " + getEnPassword("rootming"));
        //RegisterUtils pao = new RegisterUtils();
        System.out.println(UserUtils.isExistedEmail("rootming@live.cn"));
    }
}

