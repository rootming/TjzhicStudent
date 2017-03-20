package rootming.tjzhic;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by rootming on 2017/3/7.
 */
public class Config {

//    数据库配置
    public final static String driver = "com.mysql.jdbc.Driver";
    public final static String url = "jdbc:mysql://localhost:3306/tjzhic";
    public final static String username = "root";
    public final static String password = "1q2w3e4r5";

//    每页显示条目限制
    public final static int pageLimit = 10;

//    JSON返回值定义
    public final static String JSONError = "{\"success\" : 0}";
    public final static String JSONSuccess = "{\"success\" : 1}";

//    数据检测Pattern
    public final static String usernamePattern = "^\\w{6,20}$";
    public final static String emailPattern = "^([a-zA-Z0-9]+[_|\\_|\\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\\_|\\.]?)*[a-zA-Z0-9]+\\.[a-zA-Z]{2,3}$";
    public final static String passwordPattern = "^\\w{6,20}$";

}
