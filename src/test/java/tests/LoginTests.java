package tests;

import config.AppiumConfig;
import models.Auth;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactListScreen;
import screens.SplashScreen;

public class LoginTests extends AppiumConfig {

    @Test
    public void loginSuccess() {
//        boolean result = new SplashScreen(driver)
//                .checkCurrentVersion("Version 1.0.0")
        boolean result = new AuthenticationScreen(driver)
                .fillEmail("dusm5@gmail.com")
                .fillPassword("Dudu12345@")
                .submitLogin()
                .isActivityTitleDisplayed("Contact list");
        Assert.assertTrue(result);
    }

    @Test
    public void loginSuccessModel() {
//        boolean result = new SplashScreen(driver)
//                .checkCurrentVersion("Version 1.0.0")
        boolean result = new AuthenticationScreen(driver)
                .fillLoginRegistrationForm(Auth.builder()
                        .email("dusm5@gmail.com")
                        .password("Dudu12345@").build())
                .submitLogin()
                .isActivityTitleDisplayed("Contact list");
        Assert.assertTrue(result);

    }

    @Test
    public void loginSuccessModel2() {
        Assert.assertTrue(new AuthenticationScreen(driver)
                .fillLoginRegistrationForm(Auth.builder()
                        .email("dusm5@gmail.com")
                        .password("Dudu12345@").build())
                .submitLogin()
                .isActivityTitleDisplayed("Contact list"));
    }

    @Test
    public void loginWrongEmail() {
        new AuthenticationScreen(driver)
                .fillLoginRegistrationForm(Auth.builder()
                        .email("dusm@gmail.com")
                        .password("Dudu12345@")
                        .build())
                .submitLoginNegative()
                .isErrorMassageHasText("Login or Password incorrect");
    }

    @Test
    public void loginWrongPassword() {
        new AuthenticationScreen(driver)
                .fillLoginRegistrationForm(Auth.builder()
                        .email("dusm5@gmail.com")
                        .password("Dusm1")
                        .build())
                .submitLoginNegative()
                .isErrorMassageHasText("Login or Password incorrect");
    }

    @Test
    public void loginUnregisteredUser() {
        new AuthenticationScreen(driver)
                .fillLoginRegistrationForm(Auth.builder()
                        .email("dusm1589@gmail.com")
                        .password("Dudu12345@")
                        .build())
                .submitLoginNegative()
                .isErrorMassageHasText("Login or Password incorrect");
    }

    @AfterMethod
    public void postCondition() {
        new ContactListScreen(driver).logout();
    }

}