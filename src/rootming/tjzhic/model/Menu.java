package rootming.tjzhic.model;

import java.util.LinkedHashMap;

/**
 * Created by rootming on 2017/3/2.
 */
public class Menu extends Model {

    private Integer menuNumber;                //表示Item的顺序, 不可重复
    private Integer menuParentNumber;          //父级menuNumber, 0为没有父级目录
    private Integer menuClass;                 //Item的级别, 0为一级目录, 没有子目录
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

    public Menu(Integer menuNumber, Integer menuParentNumber, Integer menuClass, String menuName, String menuUrl, String menuGroup) {
        this.menuNumber = menuNumber;
        this.menuParentNumber = menuParentNumber;
        this.menuClass = menuClass;
        this.menuName = menuName;
        this.menuUrl = menuUrl;
        this.menuGroup = menuGroup;
    }

    public Integer getMenuNumber() {
        return menuNumber;
    }

    public void setMenuNumber(Integer menuNumber) {
        this.menuNumber = menuNumber;
    }

    public Integer getMenuParentNumber() {
        return menuParentNumber;
    }

    public void setMenuParentNumber(Integer menuParentNumber) {
        this.menuParentNumber = menuParentNumber;
    }

    public Integer getMenuClass() {
        return menuClass;
    }

    public void setMenuClass(Integer menuClass) {
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
