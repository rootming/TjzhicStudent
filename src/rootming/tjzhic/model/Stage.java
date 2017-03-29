package rootming.tjzhic.model;

import rootming.tjzhic.data.StageData;

import java.sql.Timestamp;
import java.util.LinkedHashMap;

/**
 * Created by rootming on 2017/2/27.
 */
public class Stage extends Model {

    private String id;                  //阶段编号
    private String name;                //阶段名称
    private Timestamp startTime;        //阶段开始时间
    private Timestamp endTime;          //阶段结束时间
    private String information;         //阶段信息

    @Override
    protected void init() {
        LinkedHashMap<String, String> fields = new LinkedHashMap<>();
        fields.put("stage_id", "key");
        fields.put("stage_name", null);
        fields.put("stage_startTime", null);
        fields.put("stage_endTime", null);
        fields.put("stage_information", null);
        setFieldsList(fields);
        setTableName("`stage`");
    }

    public Stage() {
    }

    public Stage(StageData stageData) {
        this.id = stageData.getStateID();
        this.name = stageData.getStateName();
        this.startTime = stageData.getStartTime();
        this.endTime = stageData.getEndTime();
        this.information = stageData.getInformation();

    }

    public Stage(String stateID, String name, Timestamp startTime, Timestamp endTime, String information) {
        this.id = stateID;
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.information = information;
    }

    public String getStateID() {
        return id;
    }

    public void setStateID(String stateID) {
        this.id = stateID;
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
