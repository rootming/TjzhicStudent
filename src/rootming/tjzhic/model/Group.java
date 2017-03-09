package rootming.tjzhic.model;

import java.util.LinkedHashMap;

/**
 * Created by rootming on 2017/3/7.
 */
public class Group extends Model {

    private String groupName;
    private int groupLevel;
    private String groupInfo;

    @Override
    protected void init() {
        LinkedHashMap<String, String> fields = new LinkedHashMap<>();
        fields.put("group_name", "key");
        fields.put("group_level", null);
        fields.put("group_info", null);

        setTableName("`group`");
        setFieldsList(fields);
    }

    public Group() {
        super();
    }

    public Group(String groupName, int groupLevel, String groupInfo) {
        this.groupName = groupName;
        this.groupLevel = groupLevel;
        this.groupInfo = groupInfo;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getGroupLevel() {
        return groupLevel;
    }

    public void setGroupLevel(int groupLevel) {
        this.groupLevel = groupLevel;
    }

    public String getGroupInfo() {
        return groupInfo;
    }

    public void setGroupInfo(String groupInfo) {
        this.groupInfo = groupInfo;
    }
}
