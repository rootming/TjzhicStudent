package rootming.tjzhic.utils;


import org.jetbrains.annotations.Nullable;
import rootming.tjzhic.model.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.*;


/**
 * Created by rootming on 2017/2/28.
 */
public class ModelUtils {

    private static Method getMethod(Class<?> classType, String name) throws NoSuchMethodException {
        return classType.getSuperclass().getMethod(name);
    }


    private static String makeQuerySql(Class<?> classType) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {


        Object temp = classType.newInstance();
        Method m = getMethod(temp.getClass(), "getTableName");
        Method m2 = getMethod(temp.getClass(), "getKeyName");
        return "SELECT * FROM " + m.invoke(classType) + " WHERE " + m2.invoke(classType) + "=?";
    }

    private static String makeQuerySql(Class<?> classType, String key) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {


        Object temp = classType.newInstance();
        Method m = getMethod(temp.getClass(), "getTableName");
        return "SELECT * FROM " + m.invoke(classType) + " WHERE " + key + "=?";
    }

    private static String makeDeleteSql(Class<?> classType, String key) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {


        Object temp = classType.newInstance();
        Method m = getMethod(temp.getClass(), "getTableName");
        return "DELETE FROM " + m.invoke(classType) + " WHERE " + key + "=?";
    }


    private static String makeQueryLikeSql(Class<?> classType, String key) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {


        Object temp = classType.newInstance();
        Method m = getMethod(temp.getClass(), "getTableName");
        return "SELECT * FROM " + m.invoke(classType) + " WHERE " + key + " LIKE ?";
    }

    private static String makeQueryAllSql(Class<?> classType) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {


        Object temp = classType.newInstance();
        Method m = getMethod(temp.getClass(), "getTableName");
        return "SELECT * FROM " + m.invoke(classType);
    }

    private static String makeInsertSql(Model arg) {
        final String operator = "INSERT INTO";
        String sqlStr;
        sqlStr = operator + " " + Model.getTableName() + " " + "(";
        for(Object it : arg.getFieldsList().keySet()) {
            sqlStr =  sqlStr + it + "," + " ";
        }
        sqlStr = sqlStr.substring(0, sqlStr.length() - 2);
        sqlStr = sqlStr + ")" + " VALUES " + "(";

        for(int i = 0; i < arg.getFieldsList().size(); i++) {
            sqlStr = sqlStr + "?" + "," + " ";
        }
        sqlStr = sqlStr.substring(0, sqlStr.length() - 2);
        sqlStr = sqlStr + ")";
        return sqlStr;

    }

//    private List queryData(Model arg) {
//
//
//    }


    public static boolean addObject(Model arg) {
        String sqlStr;
        sqlStr = makeInsertSql(arg);
        System.out.println(sqlStr);
        LinkedList<java.io.Serializable> data = new LinkedList<>();
        Field[] field = arg.getClass().getDeclaredFields();
        try {
            for (Field aField : field) {                                        // 遍历所有属性
                String name = aField.getName();                                 // 获取属性的名字
                name = name.substring(0, 1).toUpperCase() + name.substring(1);  // 将属性的首字符大写，方便构造get，set方法
                //System.out.println("Field: " + name);
                String type = aField.getGenericType().toString();               // 获取属性的类型
                if (type.equals("class java.lang.String")) {                    // 如果type是类类型，则前面包含"class "，后面跟类名
                    Method m = arg.getClass().getMethod("get" + name);
                    String value = (String) m.invoke(arg);                      // 调用getter方法获取属性值
                    data.add(value);
                }

                if (type.equals("class java.lang.Integer")) {
                    Method m = arg.getClass().getMethod("get" + name);
                    Integer value = (Integer) m.invoke(arg);
                    data.add(value);
                }

                if (type.equals("class java.lang.Boolean")) {
                    Method m = arg.getClass().getMethod("get" + name);
                    Boolean value = (Boolean) m.invoke(arg);
                    data.add(value);
                }

                if (type.equals("class java.sql.Timestamp")) {
                    Method m = arg.getClass().getMethod("get" + name);
                    Timestamp value = (Timestamp) m.invoke(arg);
                    data.add(value);
                }

            }

            DatabaseUtils dao = new DatabaseUtils();
            dao.executeUpdate(sqlStr, data.toArray());
            System.out.println(data);
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public static LinkedList<Object> queryAllObject(Class<?> classType) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {

        String sqlStr = makeQueryAllSql(classType);                                 //生成SQL语句
        DatabaseUtils databaseUtils = new DatabaseUtils();
        List queryData = databaseUtils.executeQuery(sqlStr, null);      //执行查询

        final Object tempObject = classType.newInstance();
        Field[] field = tempObject.getClass().getDeclaredFields();               //通过反射获取类内各个字段
        LinkedList<Object> modelList = new LinkedList<>();

        System.out.println(classType.getName());
        for (Object aData : queryData) {
            Map temp = (Map) aData;
            Object[] keys = temp.keySet().toArray();
            Object modelTemp = classType.newInstance();
//            System.out.println("Fields: ");
//            for (Field it : field) {
//                System.out.println(it.getName());
//            }

            for (int j = 0; j < temp.size() - 1; j++) {
                String name = field[j].getName();                                           // 获取属性的名字
                name = name.substring(0, 1).toUpperCase() + name.substring(1);              // 将属性的首字符大写，构造get，set方法
                //System.out.println("Field: " + name);
                String type = field[j].getGenericType().toString();                         // 获取属性的类型
                if (type.equals("class java.lang.String")) {                                // 如果type是类类型，则前面包含"class "，后面跟类名
                    Method m = tempObject.getClass().getMethod("set" + name, String.class);  //获取方法
                    m.invoke(modelTemp, temp.get(keys[j + 1]));                             //set方法设置值
                }

                if (type.equals("class java.lang.Integer")) {
                    Method m = tempObject.getClass().getMethod("set" + name, Integer.class);
                    m.invoke(modelTemp, temp.get(keys[j + 1]));
                }

                if (type.equals("class java.lang.Boolean")) {
                    Method m = tempObject.getClass().getMethod("set" + name, Boolean.class);
                    m.invoke(modelTemp, temp.get(keys[j + 1]));
                }

                if (type.equals("class java.sql.Timestamp")) {
                    Method m = tempObject.getClass().getMethod("set" + name, Timestamp.class);
                    m.invoke(modelTemp, temp.get(keys[j + 1]));
                }
            }
            modelList.add(modelTemp);
        }

        return modelList;
    }

    public static LinkedList<Object> queryObject(Class<?> classType, String key, String value) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        String sqlStr = makeQuerySql(classType, key);
        DatabaseUtils databaseUtils = new DatabaseUtils();
        String arg[] = new String[1];
        arg[0] = value;
        List queryData = databaseUtils.executeQuery(sqlStr, arg);
        Map data;
        final Object tempObject = classType.newInstance();
        Field[] field = tempObject.getClass().getDeclaredFields();
        LinkedList<Object> resultData = new LinkedList<>();

//        System.out.println(ctype.getName());
        for (Object aData : queryData) {
            data = (Map) aData;
            Object[] keys = data.keySet().toArray();
            Object modelTemp = classType.newInstance();
//            System.out.println("Fields: ");
//            for (Field it : field) {
//                System.out.println(it.getName());
//            }

            for (int j = 0; j < data.size() - 1; j++) {

                String name = field[j].getName();
                name = name.substring(0, 1).toUpperCase() + name.substring(1);
//                System.out.println("Field: " + name);
                String type = field[j].getGenericType().toString();
                if (type.equals("class java.lang.String")) {                            
                    Method m = tempObject.getClass().getMethod("set" + name, String.class);
                    m.invoke(modelTemp, data.get(keys[j + 1]));
                }

                if (type.equals("class java.lang.Integer")) {
                    Method m = tempObject.getClass().getMethod("set" + name, Integer.class);
                    m.invoke(modelTemp, data.get(keys[j + 1]));
                }

                if (type.equals("class java.lang.Boolean")) {
                    Method m = tempObject.getClass().getMethod("set" + name, Boolean.class);
                    m.invoke(modelTemp, data.get(keys[j + 1]));
                }

                if (type.equals("class java.sql.Timestamp")) {
                    Method m = tempObject.getClass().getMethod("set" + name, Timestamp.class);
                    m.invoke(modelTemp, data.get(keys[j + 1]));
                }
            }
            resultData.add(modelTemp);
        }

        return resultData;
    }

    @Nullable
    public static Object queryObject(Class<?> classType, String value) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException, InstantiationException {

        String sqlStr = makeQuerySql(classType);                //创建原始的SQL语句
        final String key[];                                     //存储参数
        key = new String[1];
        key[0] = value;
        DatabaseUtils databaseUtils = new DatabaseUtils();
        List result = databaseUtils.executeQuery(sqlStr, key);  //执行查询
        Map data;

        Object tempObject = classType.newInstance();
        Field[] field = tempObject.getClass().getDeclaredFields();   //通过反射获取类内各个字段

//        System.out.println(ctype.getName());
        if(result.size() < 1)
            return null;
        data = (Map)result.get(0);                              //只取第一个结果, 如果出现两个结果, 那么数据库的约束设置不正确
        Object []keys = data.keySet().toArray();


//        Method[] methods = tempObject.getClass().getDeclaredMethods();

//        for(Method it : methods) {
//            if(it.getName().matches("set.*")) {
//                System.out.println(it.getName());
//                //Method m = value.getClass().getMethod(it.getName());
//                //m.invoke("rootming");
//            }
//        }

//        System.out.println("Fields: ");
//        for(Field it : field) {
//            System.out.println(it.getName());
//        }
//        System.out.println("Methods: ");
//        for(Method it : methods) {
//            System.out.println(it.getName());
//        }

        for (int i = 0; i < data.size() - 1; i++) {

            String name = field[i].getName();                                 // 获取属性的名字
            name = name.substring(0, 1).toUpperCase() + name.substring(1);        // 将属性的首字符大写，方便构造get，set方法
//            System.out.println("Field: " + name);
            String type = field[i].getGenericType().toString();                   // 获取属性的类型
            if (type.equals("class java.lang.String")) {                            // 如果type是类类型，则前面包含"class "，后面跟类名
                Method m = tempObject.getClass().getMethod("set" + name, String.class);
                m.invoke(tempObject, data.get(keys[i + 1]));                                 // 调用getter方法获取属性值
            }

            if (type.equals("class java.lang.Integer")) {
                Method m = tempObject.getClass().getMethod("set" + name, Integer.class);
                m.invoke(tempObject, data.get(keys[i + 1]));
            }

            if (type.equals("class java.lang.Boolean")) {
                Method m = tempObject.getClass().getMethod("set" + name, Boolean.class);
                m.invoke(tempObject, data.get(keys[i + 1]));
            }

            if (type.equals("class java.sql.Timestamp")) {
                Method m = tempObject.getClass().getMethod("set" + name, Timestamp.class);
                m.invoke(tempObject, data.get(keys[i + 1]));
            }
        }

        return tempObject;
    }

    public static LinkedList<Object> queryObjectLike(Class<?> classType, String key, String value) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        String sqlStr = makeQueryLikeSql(classType, key);
        DatabaseUtils databaseUtils = new DatabaseUtils();
        String arg[] = new String[1];
        arg[0] = value;
        List queryData = databaseUtils.executeQuery(sqlStr, arg);
        Map data;
        final Object tempObject = classType.newInstance();
        Field[] field = tempObject.getClass().getDeclaredFields();
        LinkedList<Object> resultData = new LinkedList<>();

//        System.out.println(ctype.getName());
        for (Object aData : queryData) {
            data = (Map) aData;
            Object[] keys = data.keySet().toArray();
            Object modelTemp = classType.newInstance();
//            System.out.println("Fields: ");
//            for (Field it : field) {
//                System.out.println(it.getName());
//            }

            for (int j = 0; j < data.size() - 1; j++) {

                String name = field[j].getName();
                name = name.substring(0, 1).toUpperCase() + name.substring(1);
//                System.out.println("Field: " + name);
                String type = field[j].getGenericType().toString();
                if (type.equals("class java.lang.String")) {
                    Method m = tempObject.getClass().getMethod("set" + name, String.class);
                    m.invoke(modelTemp, data.get(keys[j + 1]));
                }

                if (type.equals("class java.lang.Integer")) {
                    Method m = tempObject.getClass().getMethod("set" + name, Integer.class);
                    m.invoke(modelTemp, data.get(keys[j + 1]));
                }

                if (type.equals("class java.lang.Boolean")) {
                    Method m = tempObject.getClass().getMethod("set" + name, Boolean.class);
                    m.invoke(modelTemp, data.get(keys[j + 1]));
                }

                if (type.equals("class java.sql.Timestamp")) {
                    Method m = tempObject.getClass().getMethod("set" + name, Timestamp.class);
                    m.invoke(modelTemp, data.get(keys[j + 1]));
                }
            }
            resultData.add(modelTemp);
        }

        return resultData;
    }

    public static boolean deleteObject(Class<?> classType, String key, String value) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        String sqlStr = makeDeleteSql(classType, key);
        //System.out.println(sqlStr);
        DatabaseUtils databaseUtils = new DatabaseUtils();
        String arg[] = new String[1];
        arg[0] = value;
        return databaseUtils.execute(sqlStr, arg);
    }

    static public void main(String []args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, ClassNotFoundException, InstantiationException {
//        User user = new User("455718869@qq.com", "Stargazer", "rootming");
//        ModelUtils mao = new ModelUtils();
//        //mao.addObject(user);
//        //System.out.println(Model.getKeyName());
//        User query = (User) queryObject(User.class, "328901936@qq.com");
//        System.out.println(query.getName());

        LinkedList<Object> menuList = queryAllObject(Log.class);
        System.out.println(menuList.size());
        for (Object aMenuList : menuList) {
            Log item = (Log) aMenuList;
            System.out.println(item.getGroup());
        }
        deleteObject(User.class, "user_name", "littletao");

        //Model data = new User.class.getClass();

        //System.out.println(makeQuerySql(User.class));

//        Class test = User.class.getSuperclass();
//        Method []methods = test.getDeclaredMethods();
//        Method m2 = test.getMethod("getTableName");
//        System.out.println((String)m2.invoke(null));
//
//        for(Method m : methods) {
//            System.out.println(m.getName());
//        }
        //System.out.println();

    }
}
