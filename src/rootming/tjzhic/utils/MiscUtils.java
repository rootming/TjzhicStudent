package rootming.tjzhic.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by rootming on 2017/2/27.
 */
public class MiscUtils {

    public static String getTime() {
        Date date = new Date();     //获得系统时间
        return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(date);
    }

    public static Timestamp getSqlTime() {
        return Timestamp.valueOf(getTime());
    }
}
