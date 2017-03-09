package rootming.tjzhic.model;

import java.security.Timestamp;
import java.util.LinkedHashMap;

/**
 * Created by rootming on 2017/2/27.
 */
public class Stage extends Model {

    private String name;                //阶段名称
    private Timestamp startTime;        //阶段开始时间
    private Timestamp endTime;          //阶段结束时间
    private String information;         //阶段信息

    @Override
    protected void init() {
        LinkedHashMap<String, String> fields = new LinkedHashMap<>();
        fields.put("stage_name", "key");
        fields.put("stage_startTime", null);
        fields.put("stage_endTime", null);
        fields.put("stage_information", null);
        setFieldsList(fields);
        setTableName("`stage`");
    }


    public Stage(String name, Timestamp startTime, Timestamp endTime, String information) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.information = information;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }
}
