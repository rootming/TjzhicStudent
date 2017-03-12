package rootming.tjzhic.Data;

import java.util.LinkedList;

/**
 * Created by rootm on 2017/3/12.
 */
public class AdminState {
    private int id;
    private String name;
    private String group;
    private String email;

    public AdminState() {

    }

    public AdminState(int id, String name, String group, String email) {
        this.id = id;
        this.name = name;
        this.group = group;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

