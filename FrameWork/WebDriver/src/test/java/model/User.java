package model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String email;
    private String password;
    private String username;

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
