package rootming.tjzhic.utils;
import rootming.tjzhic.Config;

import java.sql.*;
import java.util.*;

/**
 * Created by rootming on 2017/2/26.
 */
public class DatabaseUtils {
    final private static String driver = Config.driver;
    final private static String url = Config.url;
    final private static String username = Config.username;
    final private static String password = Config.password;

    private Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private void closeAll(Connection connection, PreparedStatement prsts, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (prsts != null) {
            try {
                prsts.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    int executeUpdate(String sql, Object[] param) {
        int rows = 0;
        Connection conn = this.getConnection();
        PreparedStatement prsts = null;
        try {
            prsts = conn.prepareStatement(sql);
            for (int i = 1; i <= param.length; i++) {
                prsts.setObject(i, param[i - 1]);
            }
            rows = prsts.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeAll(conn, prsts, null);
        }
        return rows;
    }

    boolean execute(String sql, Object[] param) {
        boolean success = false;
        Connection conn = this.getConnection();
        PreparedStatement prsts = null;
        try {
            prsts = conn.prepareStatement(sql);
            for (int i = 1; i <= param.length; i++) {
                prsts.setObject(i, param[i - 1]);
            }
            prsts.execute();
            if(prsts.getUpdateCount() > 0)
                success = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeAll(conn, prsts, null);
        }
        return success;
    }

    List executeQuery(String sql, Object[] param) {
        ResultSet rs = null;
        List list = null;
        Connection conn = this.getConnection();
        PreparedStatement prsts = null;
        try {
            prsts = conn.prepareStatement(sql);
            if(param != null) {
                for (int i = 1; i <= param.length; i++) {
                    prsts.setObject(i, param[i - 1]);
                }
            }
            rs = prsts.executeQuery();
            list = new ArrayList();
            ResultSetMetaData rsm = rs.getMetaData();
            Map map;
            while (rs.next()) {
                map = new LinkedHashMap();
                for (int i = 1; i <= rsm.getColumnCount(); i++) {
                    map.put(rsm.getColumnName(i), rs.getObject(rsm.getColumnName(i)));
                }
                list.add(map);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            this.closeAll(conn, prsts, rs);
        }
        return list;
    }

    public static void main(String[] args) {
        final String sqlStr = "SELECT admin_password FROM admin WHERE admin_email=?";
        final String arg[];
        arg = new String[1];
        arg[0] = "rootming@live.cn";
        DatabaseUtils databaseUtils = new DatabaseUtils();
        List result = databaseUtils.executeQuery(sqlStr, arg);
        LinkedHashMap data = (LinkedHashMap)result.get(0);
        System.out.println(data.get("admin_password"));
    }
}
