package rootming.tjzhic.utils;

import rootming.tjzhic.model.Log;
import rootming.tjzhic.model.User;


/**
 * Created by rootming on 2017/2/27.
 */
public class LogUtils {


    public static void log(String info) {
        System.out.println("[" + MiscUtils.getTime() + "]" + " Log: " + info);
    }

    public static void log(String address, String info) {
        System.out.println("[" + MiscUtils.getTime() + "][" + address + "] Log: " + info);
    }

    public static void addLoginInfo(User user, String address) {
        Log log = new Log(user, address);
        if(ModelUtils.addObject(log)) {
            log("已记录登陆");
        }
    }
}
