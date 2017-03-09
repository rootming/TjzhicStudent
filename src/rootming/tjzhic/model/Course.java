package rootming.tjzhic.model;

import java.util.LinkedHashMap;

/**
 * Created by rootming on 2017/2/26.
 */
public class Course extends Model {

    private String name;            //课程名称
    private String majorName;       //所属专业名称
    private String startTime;       //开始时间
    private String endTime;         //结束时间

    @Override
    protected void init() {

        LinkedHashMap<String, String> fields = new LinkedHashMap<>();
        fields.put("course_name", "key");
        fields.put("course_major", null);
        fields.put("course_start", null);
        fields.put("course_end", null);
        setTableName("`course`");
        setFieldsList(fields);

    }

    public Course(String name, String majorName, String startTime, String endTime) {
        this.name = name;
        this.majorName = majorName;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
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
}
