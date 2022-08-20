package model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String email;
    private String password;
    private String username;

//    public String getUsername() {
//        return username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public String getEmail(){
//        return email;
//    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
