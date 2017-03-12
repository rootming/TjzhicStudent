package rootming.tjzhic.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.LinkedList;

import com.google.gson.*;
import rootming.tjzhic.Config;
import rootming.tjzhic.handle.LoginHandle;
import rootming.tjzhic.model.Group;
import rootming.tjzhic.model.User;


/**
 * Created by rootm on 2017/3/12.
 */

class State {
    private int userCount;
    private int adminCount;
    private int onlineCount;

    public State(int userCount, int adminCount, int onlineCount) {
        this.userCount = userCount;
        this.adminCount = adminCount;
        this.onlineCount = onlineCount;
    }
}

class AdminState {
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

class AdminStateSection {
    private int page;
    private LinkedList<AdminState> state;

    public AdminStateSection() {

    }

    public AdminStateSection(int page, LinkedList<AdminState> state) {
        this.page = page;
        this.state = state;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public LinkedList<AdminState> getState() {
        return state;
    }

    public void setState(LinkedList<AdminState> state) {
        this.state = state;
    }
}

public class JSONDataUtils {
    private HashMap<String, String> params = new HashMap<>();

    private void init() {
        params.put("get_state", "sysadmin");
        params.put("get_admin", "sysadmin");
    }


    public JSONDataUtils() {
        init();
    }


    public static String get_state() {
        Gson gson = new GsonBuilder().create();
        int userCount = 0;
        int adminCount = 0;
        int onlineCount = LoginHandle.getActiveSessions();
        try {
            userCount = ModelUtils.queryObject(User.class, "user_group", "user").size();
            adminCount = ModelUtils.queryAllObject(User.class).size() - userCount;
        } catch (NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }


        State state = new State(userCount, adminCount, onlineCount);
        //System.out.println(gson.toJson(state));
        return gson.toJson(state);
    }

    public static String get_adminstate() {
        Gson gson = new GsonBuilder().create();
        LinkedList<Object> users;
        LinkedList<Object> groups;
        LinkedList<AdminStateSection> sections = new LinkedList<>();

        try {
            users = ModelUtils.queryObjectLike(User.class, "user_group", "%admin");
            groups = ModelUtils.queryObjectLike(Group.class, "group_name", "%admin");
            AdminStateSection section = new AdminStateSection();
            LinkedList<AdminState> states = new LinkedList<>();

            for (int i = 0; i < users.size(); i++) {
                User user = (User) users.get(i);
                int index = i / Config.pageLimit;

                if(i % Config.pageLimit == 0) {
                    sections.add(new AdminStateSection());
                    section.setPage(index);
                    sections.get(index).setState(new LinkedList<>());
                }

                for (int j = 0; j < groups.size(); j++) {
                    Group group = (Group) groups.get(j);
                    if (group.getGroupName().equals(user.getGroup())) {
                        sections.get(index).getState().add(
                                new AdminState(i, user.getName(), group.getGroupInfo(), user.getEmail()));
                        break;
                    }
                }

            }

        } catch (NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return gson.toJson(sections);
    }
    public static void main(String []args) {
        System.out.println(get_adminstate());
    }

}

