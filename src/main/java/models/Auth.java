package models;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import screens.AuthenticationScreen;

@Getter
@Setter
@ToString
@Builder
public class Auth {
    private String email;
    private String password;


}
