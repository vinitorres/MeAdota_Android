package app.vini.com.meadota.Model.DataEvent;

/**
 * Created by uriel on 03/07/17.
 */

public class UserDataEvent {

    public final String name;
    public final String email;
    public final String password;
    public final String confirmPassword;


    public UserDataEvent(String name, String email, String password, String confirmPassword) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }
}
