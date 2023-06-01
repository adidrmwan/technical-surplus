package test.automation.data;

import org.springframework.stereotype.Component;
import test.automation.utils.FakerUtil;

import java.util.Locale;

@Component("test.automation.data.User")
public class User {

    private static String tempPassword = "password!2";
    public String existingEmail = "";
    public String existingPassword = "";

    public String getName(String name) {
        switch (name.toLowerCase(Locale.ROOT)) {
            case "valid":
                name = FakerUtil.getFakeName();
                break;
            case "none":
                name = "";
                break;
        }
        return name;
    }

    public String getEmail(String email) {
        switch (email.toLowerCase(Locale.ROOT)) {
            case "valid":
                email = FakerUtil.getFakeEmail();
                break;
            case "invalid":
                email = "invalidTypeEmail";
                break;
            case "existing":
                email = existingEmail;
                break;
            case "none":
                email = "";
                break;
        }
        return email;
    }

    public String getPassword(String password) {
        switch (password.toLowerCase(Locale.ROOT)) {
            case "valid":
                password = tempPassword;
                break;
            case "existing":
                password = existingPassword;
                break;
            case "none":
                password = "";
                break;
        }
        return password;
    }

    public String getConfirmPassword(String confirm_password) {
        switch (confirm_password.toLowerCase(Locale.ROOT)) {
            case "valid":
                confirm_password = tempPassword;
                break;
            case "invalid":
                confirm_password = "wrong_password";
                break;
            case "none":
                confirm_password = "";
                break;
        }
        return confirm_password;
    }
}
