package rootming.tjzhic.data;

/**
 * Created by rootm on 2017/3/12.
 */
public class UserStateData {
    private int userCount;
    private int adminCount;
    private int onlineCount;

    public UserStateData() {

    }

    public UserStateData(int userCount, int adminCount, int onlineCount) {
        this.userCount = userCount;
        this.adminCount = adminCount;
        this.onlineCount = onlineCount;
    }

    public int getUserCount() {
        return userCount;
    }

    public void setUserCount(int userCount) {
        this.userCount = userCount;
    }

    public int getAdminCount() {
        return adminCount;
    }

    public void setAdminCount(int adminCount) {
        this.adminCount = adminCount;
    }

    public int getOnlineCount() {
        return onlineCount;
    }

    public void setOnlineCount(int onlineCount) {
        this.onlineCount = onlineCount;
    }
}