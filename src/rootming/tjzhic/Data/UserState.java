package rootming.tjzhic.Data;

/**
 * Created by rootm on 2017/3/12.
 */
public class UserState {
    private int userCount;
    private int adminCount;
    private int onlineCount;

    public UserState(int userCount, int adminCount, int onlineCount) {
        this.userCount = userCount;
        this.adminCount = adminCount;
        this.onlineCount = onlineCount;
    }
}