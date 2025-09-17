package tests;

import config.AppiumConfig;
import models.Auth;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;

public class LoginTestSecond extends AppiumConfig {

    @Test
    public void loginSuccess(){
        new AuthenticationScreen(driver)
                .fillEmail("dusm5@gmail.com")
                .fillPassword("Dudu12345@")
                .submitLogin()
                .isAccountOpened()
                .logout();

    }

    @Test
    public void loginSuccessModel(){
        new AuthenticationScreen(driver)
                .fillLoginRegistrationForm(Auth.builder()
                        .email("dusm5@gmail.com")
                        .password("Dudu12345@")
                        .build())
                .fillPassword("Dudu12345@")
                .submitLogin()
                .isAccountOpened()
                .logout();

    }
}
