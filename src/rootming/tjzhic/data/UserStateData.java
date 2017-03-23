package rootming.tjzhic.data;

/**
 * Created by rootm on 2017/3/12.
 */
public class UserStateData {
    private int userCount;
    private int adminCount;
    private int onlineCount;

    public UserStateData(int userCount, int adminCount, int onlineCount) {
        this.userCount = userCount;
        this.adminCount = adminCount;
        this.onlineCount = onlineCount;
    }
}