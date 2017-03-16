package rootming.tjzhic.Test;

import rootming.tjzhic.Config;

/**
 * Created by rootm on 2017/3/16.
 */
public class Test {
    public static void main(String []args) {
        final String testEmail = "rootming@live.cn";
        final String testName = "rootming";
        final String testPassword = "rootming";
        System.out.println(testEmail.matches(Config.emailPattern));
        System.out.println(testName.matches(Config.usernamePattern));
        System.out.println(testPassword.matches(Config.passwordPattern));
    }
}
