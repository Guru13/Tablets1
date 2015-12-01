package by.guru13.spring.entities;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import by.guru13.spring.validation.ValidEmail;

/**
 * Класс, который описывает пользователя и включает все необходимые геттеры и сеттеры
 * <p>
 *
 * @author Alexey Guryanchyck
 */
public class User {
    @NotBlank(message = "{NotBlank.user.username}")
    @Size(min = 8, max = 15, message = "{Size.user.username}")
    @Pattern(regexp = "^\\w{8,}$", message = "{Pattern.user.username}")
    private String username;

    @NotBlank(message = "{NotBlank.user.password}")
    @Size(min = 8, max = 15, message = "{Size.user.password}")
    @Pattern(regexp = "^\\S+$", message = "{Pattern.user.password}")
    private String password;

    @ValidEmail(message = "{ValidEmail.user.email}")
    private String email;
    private boolean enabled = false;
    private String authority;

    public User() {

    }

    public User(String username, String password, String email, boolean enabled, String authority) {

        this.username = username;
        this.password = password;
        this.email = email;
        this.enabled = enabled;
        this.authority = authority;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

}
