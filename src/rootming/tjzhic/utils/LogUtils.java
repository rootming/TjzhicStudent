package rootming.tjzhic.utils;

import rootming.tjzhic.model.Log;
import rootming.tjzhic.model.User;


/**
 * Created by rootming on 2017/2/27.
 */
public class LogUtils {
    public static void log(Object obj, String info) {
        System.out.println("[" + MiscUtils.getTime() + "][" + obj.getClass().getName() + "] Log: " + info);
    }

    public static void log(String address, String info) {
        System.out.println("[" + MiscUtils.getTime() + "][" + address + "] Log: " + info);
    }

    public static void addLoginInfo(User user, String address) {
        Log log = new Log(user, address);
        if(ModelUtils.addObject(log)) {
            log(LogUtils.class, "已记录登陆");
        }
    }
}
