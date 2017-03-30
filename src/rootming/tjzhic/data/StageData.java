package rootming.tjzhic.data;

import java.sql.Timestamp;

/**
 * Created by rootm on 2017/3/29.
 */

//TODO: 时区有问题

public class StageData {
    private String id;
    private String name;
    private String startTime;
    private String endTime;
    private String information;

    public StageData() {
    }

    public StageData(String id, String name, String startTime, String endTime, String information) {
        this.id = id;
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.information = information;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }
}
