package rootming.tjzhic.utils;


/**
 * Created by rootming on 2017/3/9.
 * SQL注入过滤器
 */

public class SecurityUtils {
    public static boolean isSql(String sql) {
//        sql = sql.toLowerCase();
//        String badKey = "'|and|exec|execute|insert|select|delete|update|count|drop|char|mid|master|truncate|char|declare|sitename|netuser|xp_cmdshell|or|like";
//        String []badKeys = badKey.split("\\|");
//        for (String badKey1 : badKeys) {
//            if (sql.contains(badKey1)) {
//                return true;
//            }
//        }
//        return false;

        //关掉了SQL检测
        return false;
    }

    public void destroy() {
    }




}
