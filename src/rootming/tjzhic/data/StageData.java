package rootming.tjzhic.data;

import java.sql.Timestamp;

/**
 * Created by rootm on 2017/3/29.
 */
public class StageData {
    private String id;
    private String name;
    private Timestamp startTime;
    private Timestamp endTime;
    private String information;

    public StageData() {
    }

    public StageData(String stateID, String stateName, Timestamp startTime, Timestamp endTime, String information) {
        this.id = stateID;
        this.name = stateName;
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

    public String getStateName() {
        return name;
    }

    public void setStateName(String stateName) {
        this.name = stateName;
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
