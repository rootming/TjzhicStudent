package rootming.tjzhic.model;

import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;


/**
 * Created by rootming on 2017/2/28.
 */
public abstract class Model {
    private static LinkedHashMap fieldsList;        //字段名
    private static String tableName;                //表名

    //类内属性声明顺序应与字段名列表顺序相同, 否则反射获取get set方法时将会出错

    // TODO:
    // 1.属性与字段map, 顺序与字段无关
    // 2.增加字段初始化方法
    // 3.字段与属性相绑定, 不在类内声明属性


    /**
     * Gets fields list.
     *
     * @return the fields list
     */
    public LinkedHashMap getFieldsList() {
        return fieldsList;
    }

    /**
     * Sets fields list.
     *
     * @param fieldsList the fields list
     */
    void setFieldsList(LinkedHashMap fieldsList) {
        this.fieldsList = fieldsList;
    }

    /**
     * Gets table name.
     *
     * @return the table name
     */
    public static String getTableName() {
        return tableName;
    }

    /**
     * Sets table name.
     *
     * @param tableName the table name
     */
    void setTableName(String tableName) {
        Model.tableName = tableName;
    }

    /**
     * Init.
     */
    abstract protected void init();

    /**
     * Instantiates a new Model.
     */
    protected Model() {
        init();
    }

    /**
     * Gets key name.
     *
     * @return the key name
     */
    @Nullable
    public static String getKeyName() {
        //System.out.println(fieldsList);
        for (Object it : fieldsList.keySet()) {
            if(fieldsList.get(it).equals("key"))
                return (String)it;
        }
        return null;
    }
}
