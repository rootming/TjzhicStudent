package rootming.tjzhic.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import rootming.tjzhic.Config;
import rootming.tjzhic.data.AdminStateData;
import rootming.tjzhic.data.HistoryData;
import rootming.tjzhic.data.PasswordData;
import rootming.tjzhic.data.UserStateData;
import rootming.tjzhic.handle.LoginHandle;
import rootming.tjzhic.model.Group;
import rootming.tjzhic.model.Log;
import rootming.tjzhic.model.User;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by rootm on 2017/3/13.
 */
public class APIUtils {
    private HashMap<String, String> api = new HashMap<>();

    private void init() {
        api.put("del_admin", "sysadmin");           //删除admin
        api.put("rst_passwd", "sysadmin");          //重置admin密码
        //api.put("mod_admin_passwd", "sysadmin");
        api.put("get_state", "sysadmin");           //获取在在线信息
        api.put("get_admin", "sysadmin");           //获取admin信息
        api.put("get_his", "sysadmin");             //获取登录信息
        api.put("mod_all_pass", "sysadmin");        //修改所有用户的密码
    }

    public APIUtils() {
        init();
    }

    private boolean checkValid(String cmd, String group) {
        String storedGroup = api.get(cmd);
        if(storedGroup != null) {
            if(!storedGroup.contains(group)) {
                LogUtils.log("No Permission access API: " + group);
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

    public String doAPI(String cmd, String arg, String group) throws InvocationTargetException, IllegalAccessException {
        APIUtils obj = new APIUtils();
        boolean found = false;
        Method methods[] = obj.getClass().getDeclaredMethods();
        Method m = null;

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
            LogUtils.log("Method not found");
            return Config.JSONError;
        }

        return (String)m.invoke(obj, arg);
    }

    private static String del_admin(String arg) {

        boolean flag = false;
        if(arg != null && arg.equals("rootming@live.cn")) {
            LogUtils.log("admin can not del!");
            return Config.JSONError;
        }

        try {
            flag = ModelUtils.deleteObject(User.class, "user_email", arg);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return Config.JSONError;
        }
        return flag ? Config.JSONSuccess : Config.JSONError;

    }

    private static String rst_passwd(String arg) {

        boolean flag = false;
        if(arg != null && arg.equals("rootming@live.cn")) {
            LogUtils.log("admin can not reset password!");
            return Config.JSONError;
        }

        try {
            User user = (User)ModelUtils.queryObject(User.class,  arg);
            assert user != null;
            user.setPassword(RegisterUtils.getEnPassword("123456789"));
            ModelUtils.deleteObject(User.class, "user_email", arg);
            ModelUtils.addObject(user);
            flag = true;

        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return Config.JSONError;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return flag ? Config.JSONSuccess : Config.JSONError;
    }

//    private static String mod_admin_passwd(String arg) {
//
//        boolean flag = false;
//        if(arg != null && arg.equals("rootming@live.cn")) {
//            LogUtils.log("admin can not reset password!");
//            return Config.JSONError;
//        }
//
//        try {
//            User user = (User)ModelUtils.queryObject(User.class,  arg);
//            assert user != null;
//            user.setPassword(RegisterUtils.getEnPassword("123456789"));
//            ModelUtils.deleteObject(User.class, "user_email", arg);
//            ModelUtils.addObject(user);
//            flag = true;
//
//        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
//            e.printStackTrace();
//            return Config.JSONError;
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        return flag ? Config.JSONSuccess : Config.JSONError;
//
//    }


    private static String mod_all_pass(String arg) {
        Gson gson = new GsonBuilder().create();

        PasswordData passwordData;


        try {
            passwordData = gson.fromJson(arg, PasswordData.class);


            if (!UserUtils.isExistedEmail(passwordData.getEmail()))
                return Config.JSONError;

//            //更新为加密后的密码
//            passwordData.setPassword(RegisterUtils.getEnPassword(passwordData.getPassword()));
//            passwordData.setConfirmPassword(RegisterUtils.getEnPassword(passwordData.getConfirmPassword()));

            //代码真是又臭又长
            if (passwordData.getPassword().equals(passwordData.getConfirmPassword())) {
                User user = (User) ModelUtils.queryObject(User.class, arg);
                assert user != null;
                user.setPassword(RegisterUtils.getEnPassword(passwordData.getPassword()));
                ModelUtils.deleteObject(User.class, "user_email", arg);
                ModelUtils.addObject(user);
                return Config.JSONSuccess;
            } else {
                return Config.JSONError;
            }


        } catch (Exception e) {
            e.printStackTrace();
            return Config.JSONError;
        }


    }

    private static String get_state(String arg) {
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


        UserStateData state = new UserStateData(userCount, adminCount, onlineCount);
        //System.out.println(gson.toJson(state));
        //return "" + state.getUserCount();
        return gson.toJson(state);
    }

    private static String get_adminstate(String arg) {
        Gson gson = new GsonBuilder().create();
        LinkedList<Object> users;
        LinkedList<Object> groups;
//        LinkedList<PageData<AdminStateData>> sections = new LinkedList<>();

        LinkedList<AdminStateData> adminStateDatas = new LinkedList<>();

        try {
            users = ModelUtils.queryObjectLike(User.class, "user_group", "%admin");
            groups = ModelUtils.queryObjectLike(Group.class, "group_name", "%admin");

            for (int i = 0; i < users.size(); i++) {
                User user = (User) users.get(i);
//                int index = i / Config.pageLimit;

//                if(i % Config.pageLimit == 0) {
//                    sections.add(new PageData<>());
//                    //sections.get(index).setPage(index);
//                    sections.get(index).setState(new LinkedList<>());
//                }

                for (int j = 0; j < groups.size(); j++) {
                    Group group = (Group) groups.get(j);
                    if (group.getGroupName().equals(user.getGroup())) {
                        adminStateDatas.add(
                                new AdminStateData(i, user.getName(), group.getGroupInfo(), user.getEmail()));
                        break;
                    }
                }

            }

        } catch (NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return gson.toJson(adminStateDatas);
    }

    private static String get_his(String arg) {
        Gson gson = new GsonBuilder().create();
        LinkedList<Object> logs;
        LinkedList<Object> groups;
        //LinkedList<PageData<HistoryData>> sections = new LinkedList<>();
        LinkedList<HistoryData> historyData = new LinkedList<>();

        try {
            logs = ModelUtils.queryAllObject(Log.class);
            groups = ModelUtils.queryAllObject(Group.class);

            for (int i = 0; i < logs.size(); i++) {
                Log log = (Log) logs.get(i);
                int index = i / Config.pageLimit;

//                if(i % Config.pageLimit == 0) {
//                    sections.add(new PageData<>());
//                    System.out.println(index);
//                    //sections.get(index).setPage(index);
//                    sections.get(index).setState(new LinkedList<>());
//                }

                for (int j = 0; j < groups.size(); j++) {
                    Group group = (Group) groups.get(j);
                    if (group.getGroupName().equals(log.getGroup())) {
                        historyData.add(
                                new HistoryData(i, log.getName(), group.getGroupInfo(), log.getTime(), log.getIp()));
                        break;
                    }
                }

            }

        } catch (NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return gson.toJson(historyData);
    }



    public static void main(String []args) throws InvocationTargetException, IllegalAccessException {
        APIUtils test = new APIUtils();
        System.out.println(test.doAPI("del_admin", "rootming@live.cn", "sysadmin"));
        System.out.println(del_admin("rootming@live.cn"));
    }


}
