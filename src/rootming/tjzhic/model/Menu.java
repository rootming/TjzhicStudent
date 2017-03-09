package rootming.tjzhic.model;

import java.util.LinkedHashMap;

/**
 * Created by rootming on 2017/3/2.
 */
public class Menu extends Model {

    private int menuNumber;                //表示Item的顺序, 不可重复
    private int menuParentNumber;          //父级menuNumber, 0为没有父级目录
    private int menuClass;                 //Item的级别, 0为一级目录, 没有子目录
    private String menuName;               //Item的名称
    private String menuUrl;                //Item的URL, 父目录没有URL
    private String menuGroup;              //Item的所属组

    @Override
    protected void init() {
        LinkedHashMap<String, String> fields = new LinkedHashMap<>();
        fields.put("menu_num", null);
        fields.put("menu_parentnum", null);
        fields.put("menu_class", null);
        fields.put("menu_name", null);
        fields.put("menu_url", null);
        fields.put("menu_group", null);

        setTableName("`menu`");
        setFieldsList(fields);

    }

    public Menu() {
        super();
    }

    public Menu(int menuNumber, int menuParentNumber, int menuClass, String menuName, String menuUrl, String menuGroup) {
        this.menuNumber = menuNumber;
        this.menuParentNumber = menuParentNumber;
        this.menuClass = menuClass;
        this.menuName = menuName;
        this.menuUrl = menuUrl;
        this.menuGroup = menuGroup;
    }

    public int getMenuNumber() {
        return menuNumber;
    }

    public void setMenuNumber(int menuNumber) {
        this.menuNumber = menuNumber;
    }

    public int getMenuParentNumber() {
        return menuParentNumber;
    }

    public void setMenuParentNumber(int menuParentNumber) {
        this.menuParentNumber = menuParentNumber;
    }

    public int getMenuClass() {
        return menuClass;
    }

    public void setMenuClass(int menuClass) {
        this.menuClass = menuClass;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getMenuGroup() {
        return menuGroup;
    }

    public void setMenuGroup(String menuGroup) {
        this.menuGroup = menuGroup;
    }
}
