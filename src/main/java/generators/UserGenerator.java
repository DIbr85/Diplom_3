package generators;

import models.User;


public class UserGenerator {
    public static User randomUser(String email, String password, String name) {
        return User
                .builder()
                .email(email)
                .password(password)
                .name(name)
                .build();
    }
}
