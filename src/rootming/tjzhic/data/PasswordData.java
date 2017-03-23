package rootming.tjzhic.data;

/**
 * Created by rootm on 2017/3/23.
 */
public class PasswordData {
    private String email;
    private String password;
    private String confirmPassword;

    public PasswordData() {
    }

    public PasswordData(String email, String password, String confirmPassword) {
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
