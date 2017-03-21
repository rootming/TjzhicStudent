package rootming.tjzhic.Data;

/**
 * Created by rootm on 2017/3/21.
 */

public class RegisterData {
    private String username;
    private String email;
    private String password;
    private String confirmPassword;
    private String code;

    public RegisterData() {
    }

    public RegisterData(String username, String email, String password, String confirmPassword, String code) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.code = code;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
