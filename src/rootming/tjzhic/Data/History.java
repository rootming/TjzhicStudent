package rootming.tjzhic.Data;

import java.sql.Timestamp;

/**
 * Created by rootm on 2017/3/12.
 */
public class History {
    private int id;
    private String name;
    private String group;
    private Timestamp time;
    private String ip;

    public History() {
    }

    public History(int id, String name, String group, Timestamp time, String ip) {
        this.id = id;
        this.name = name;
        this.group = group;
        this.time = time;
        this.ip = ip;
    }
}
