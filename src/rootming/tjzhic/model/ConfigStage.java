package rootming.tjzhic.model;

import rootming.tjzhic.utils.MiscUtils;

import java.sql.Timestamp;

/**
 * Created by rootming on 2017/2/27.
 */
public class ConfigStage extends Model {

    private String name;            //修改配置的管理员名称
    private Timestamp time;         //更改配置时间
    private String stageName;       //更改状态

    @Override
    protected void init() {

    }

    public ConfigStage(String name, String stageName) {
        this.name = name;
        this.time = MiscUtils.getSqlTime();
        this.stageName = stageName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }
}
