package rootming.tjzhic.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedList;

import com.google.gson.*;
import rootming.tjzhic.Config;
import rootming.tjzhic.Data.AdminState;
import rootming.tjzhic.Data.History;
import rootming.tjzhic.Data.UserState;
import rootming.tjzhic.handle.LoginHandle;
import rootming.tjzhic.model.Group;
import rootming.tjzhic.model.Log;
import rootming.tjzhic.model.User;


/**
 * Created by rootm on 2017/3/12.
 */

public class JSONDataUtils {
    private HashMap<String, String> params = new HashMap<>();

    private void init() {
        params.put("get_state", "sysadmin");
        params.put("get_admin", "sysadmin");
        params.put("get_his", "sysadmin");
    }


    public JSONDataUtils() {
        init();
    }

    private boolean checkValid(String cmd, String group) {
        String storedGroup = params.get(cmd);
        if(storedGroup != null) {
            if(!storedGroup.contains(group)) {
                LogUtils.log("No Permission access API.");
                return false;
            }
            else {
                return true;
            }
        }
        else {
            return true;
        }
    }

    public String queryData(String cmd, String group) throws InvocationTargetException, IllegalAccessException {
        JSONDataUtils obj = new JSONDataUtils();
        Method methods[] = obj.getClass().getDeclaredMethods();
        Method m = null;
        boolean found = false;

        if(!checkValid(cmd, group)) {
            return Config.JSONError;
        }

        for(Method method : methods) {
            if(method.getName().equals(cmd)) {
                m = method;
                found = true;
            }
        }

        if(!found) {
            return Config.JSONError;
        }

        return (String)m.invoke(obj);
    }


    private static String get_state() {
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


        UserState state = new UserState(userCount, adminCount, onlineCount);
        //System.out.println(gson.toJson(state));
        return gson.toJson(state);
    }

    private static String get_adminstate() {
        Gson gson = new GsonBuilder().create();
        LinkedList<Object> users;
        LinkedList<Object> groups;
//        LinkedList<Page<AdminState>> sections = new LinkedList<>();

        LinkedList<AdminState> adminStates = new LinkedList<>();

        try {
            users = ModelUtils.queryObjectLike(User.class, "user_group", "%admin");
            groups = ModelUtils.queryObjectLike(Group.class, "group_name", "%admin");

            for (int i = 0; i < users.size(); i++) {
                User user = (User) users.get(i);
//                int index = i / Config.pageLimit;

//                if(i % Config.pageLimit == 0) {
//                    sections.add(new Page<>());
//                    //sections.get(index).setPage(index);
//                    sections.get(index).setState(new LinkedList<>());
//                }

                for (int j = 0; j < groups.size(); j++) {
                    Group group = (Group) groups.get(j);
                    if (group.getGroupName().equals(user.getGroup())) {
                        adminStates.add(
                                new AdminState(i, user.getName(), group.getGroupInfo(), user.getEmail()));
                        break;
                    }
                }

            }

        } catch (NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return gson.toJson(adminStates);
    }

    private static String get_his() {
        Gson gson = new GsonBuilder().create();
        LinkedList<Object> logs;
        LinkedList<Object> groups;
        //LinkedList<Page<History>> sections = new LinkedList<>();
        LinkedList<History> history = new LinkedList<>();

        try {
            logs = ModelUtils.queryAllObject(Log.class);
            groups = ModelUtils.queryAllObject(Group.class);

            for (int i = 0; i < logs.size(); i++) {
                Log log = (Log) logs.get(i);
                int index = i / Config.pageLimit;

//                if(i % Config.pageLimit == 0) {
//                    sections.add(new Page<>());
//                    System.out.println(index);
//                    //sections.get(index).setPage(index);
//                    sections.get(index).setState(new LinkedList<>());
//                }

                for (int j = 0; j < groups.size(); j++) {
                    Group group = (Group) groups.get(j);
                    if (group.getGroupName().equals(log.getGroup())) {
                        history.add(
                                new History(i, log.getName(), group.getGroupInfo(), log.getTime(), log.getIp()));
                        break;
                    }
                }

            }

        } catch (NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return gson.toJson(history);
    }

    public static void main(String []args) throws InvocationTargetException, IllegalAccessException {
        System.out.println(get_adminstate());
        //System.out.println(queryData("get_adminstate"));
        //System.out.println(queryData("get_history"));
        System.out.println(get_adminstate());
        System.out.println(get_his());
    }

}

