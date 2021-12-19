package ru.rsreu.hobbies.security;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.rsreu.hobbies.User;

@Data
public class RegistrationForm {

    private String username;
    private String password;
    private String fullname;

    private String phone;

    public User toUser(PasswordEncoder passwordEncoder) {
        return new User(
                username, passwordEncoder.encode(password),
                fullname,phone);
    }
}
