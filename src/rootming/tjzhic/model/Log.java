package rootming.tjzhic.model;

import rootming.tjzhic.utils.MiscUtils;

import java.sql.Timestamp;
import java.util.LinkedHashMap;

/**
 * Created by rootming on 2017/2/27.
 */
public class Log extends Model {

    private String name;        //登陆者姓名
    private String group;       //登陆者所属的组
    private Timestamp time;        //登录时间
    private String ip;          //登陆者的IP

    @Override
    protected void init() {
        LinkedHashMap<String, String> fields = new LinkedHashMap<>();
        fields.put("log_name", "key");
        fields.put("log_group", null);
        fields.put("log_time", null);
        fields.put("log_ip", null);
        setTableName("`log`");
        setFieldsList(fields);
    }

    public Log() {
        super();
    }

    public Log(String name, String group, Timestamp time, String ip) {
        this.name = name;
        this.group = group;
        this.time = time;
        this.ip = ip;
    }

    public Log(User user, String address) {
        this.name = user.getName();
        this.group = user.getGroup();
        this.time = MiscUtils.getSqlTime();
        this.ip = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
