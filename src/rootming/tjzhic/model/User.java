package rootming.tjzhic.model;

import rootming.tjzhic.utils.MiscUtils;
import rootming.tjzhic.utils.PasswordUtils;
import java.sql.Timestamp;
import java.util.LinkedHashMap;


/**
 * Created by rootming on 2017/2/26.
 */
public class User extends Model {

    private String email;           //用户邮箱
    private String name;            //用户名
    private String password;        //用户密码(虽然密码应该用char[]来存储)
    private String group;           //用户所属组
    private String ip;              //用户注册时的IP
    private Timestamp regTime;         //用户注册时间


    @Override
    protected void init() {
        LinkedHashMap<String, String> fields = new LinkedHashMap<>();
        fields.put("user_email", "key");
        fields.put("user_name", null);
        fields.put("user_password", null);
        fields.put("user_group", null);
        fields.put("user_ip", null);
        fields.put("user_date", null);
        setTableName("`user`");
        setFieldsList(fields);
    }

    /*
        SYS_ADMIN   系统管理员
        EDU_ADMIN   教务管理员
        APP_ADMIN   招生管理员
        USER        普通考生
     */

    //public enum GROUP { SYS_ADMIN, EDU_ADMIN, APP_ADMIN, USER }

    public User() {
        super();
    }

    public User(String email, String password) {
        this.email = email;
        this.password = PasswordUtils.getEnPassword(password);
    }

    public User(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = PasswordUtils.getEnPassword(password);
        this.group = "user";
        this.regTime = MiscUtils.getSqlTime();
    }

    public User(String name, String email, String password, String ip, String group) {
        this.name = name;
        this.email = email;
        this.password = PasswordUtils.getEnPassword(password);
        this.ip = ip;
        this.group = group;
        this.regTime = MiscUtils.getSqlTime();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //返回的是加密后的密码
    public String getPassword() {
        return password;
    }

    //只存储加密后的密码
    public void setPassword(String password) {
        this.password = password;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Timestamp getRegTime() {
        return regTime;
    }

    public void setRegTime(Timestamp regTime) {
        this.regTime = regTime;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

}
