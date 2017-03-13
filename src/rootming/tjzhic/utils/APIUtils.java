package rootming.tjzhic.utils;

import rootming.tjzhic.Config;
import rootming.tjzhic.model.User;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * Created by rootm on 2017/3/13.
 */
public class APIUtils {
    private HashMap<String, String> api = new HashMap<>();

    private void init() {
        api.put("del_admin", "sysadmin");
        api.put("reset_password", "sysadmin");
        //api.put("get_his", "sysadmin");
    }

    public APIUtils() {
        init();
    }

    private boolean checkValid(String cmd, String group) {
        String storedGroup = api.get(cmd);
        if(storedGroup != null) {
            if(!storedGroup.contains(group)) {
                LogUtils.log("No Permission access API: " + group);
                return false;
            }
            else {
                return true;
            }
        }
        else {
            return true;
        }
    }

    public String doAPI(String cmd, String arg, String group) throws InvocationTargetException, IllegalAccessException {
        APIUtils obj = new APIUtils();
        boolean found = false;
        Method methods[] = obj.getClass().getDeclaredMethods();
        Method m = null;

        if(!checkValid(cmd, group)) {
            return Config.JSONError;
        }

        for(Method method : methods) {
            if(method.getName().equals(cmd)) {
                m = method;
                found = true;
            }
        }

        if(!found) {
            LogUtils.log("Method not found");
            return Config.JSONError;
        }

        return (String)m.invoke(obj, arg);
    }

    private static String del_admin(String arg) {

        boolean flag = false;
        if(arg != null && arg.equals("rootming@live.cn")) {
            LogUtils.log("admin can not del!");
            return Config.JSONError;
        }

        try {
            flag = ModelUtils.deleteObject(User.class, "user_email", arg);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return Config.JSONError;
        }
        return flag ? Config.JSONSuccess : Config.JSONError;

    }



    public static void main(String []args) throws InvocationTargetException, IllegalAccessException {
        APIUtils test = new APIUtils();
        System.out.println(test.doAPI("del_admin", "rootming@live.cn", "sysadmin"));
        System.out.println(del_admin("rootming@live.cn"));
    }


}
