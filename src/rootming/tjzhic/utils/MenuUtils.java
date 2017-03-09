package rootming.tjzhic.utils;

import rootming.tjzhic.model.Menu;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * Created by rootming on 2017/3/5.
 */

public class MenuUtils {

    private LinkedList<LinkedList<Menu>> items = new LinkedList<>();

    public LinkedList<LinkedList<Menu>> makeMenu(String group) {

        LinkedList<Object> data = null;

        try {
            data = ModelUtils.queryObject(Menu.class, "menu_group", group);
        } catch (NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }

        if(data == null) {
            return null;
        }

        //寻找父级目录
        for(Object aData : data) {
            Menu tmp = (Menu)aData;
            LinkedList<Menu> parent = new LinkedList<>();
            if(tmp.getMenuClass() == 0) {
                parent.add(tmp);
                items.add(parent);
            }
        }

        //System.out.println(data.size());
        //设置子目录
        for (Object aData : data) {
            Menu tmp = (Menu) aData;
            for (LinkedList<Menu> parent : items) {
                if (tmp.getMenuClass() != 0 && tmp.getMenuParentNumber() == parent.get(0).getMenuNumber()) {
                    parent.add(tmp);
                }
            }
        }


        //测试 遍历目录
//        for(LinkedList<Menu> item : items) {
//            if(item.size() == 1) {
//                System.out.println(item.get(0).getMenuName());
//            }
//            else {
//                for(Menu unit : item) {
//                    System.out.print(unit + " ");
//                }
//                System.out.println();
//            }
//        }

        return items;
    }

    public static void main(String []arg) {
        MenuUtils util = new MenuUtils();
        util.makeMenu("sysadmin");
    }


}
