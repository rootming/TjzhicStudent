package rootming.tjzhic.data;

import java.sql.Timestamp;

/**
 * Created by rootm on 2017/3/12.
 */
public class HistoryData {
    private int id;
    private String name;
    private String group;
    private Timestamp time;
    private String ip;

    public HistoryData() {
    }

    public HistoryData(int id, String name, String group, Timestamp time, String ip) {
        this.id = id;
        this.name = name;
        this.group = group;
        this.time = time;
        this.ip = ip;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
