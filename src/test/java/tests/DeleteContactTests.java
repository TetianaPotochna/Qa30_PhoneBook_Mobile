package tests;

import config.AppiumConfig;
import models.Auth;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactListScreen;

public class DeleteContactTests extends AppiumConfig {

    @BeforeClass
    public void precondition(){
        new AuthenticationScreen(driver)
                .fillLoginRegistrationForm(Auth.builder()
                        .email("dusm5@gmail.com")
                        .password("Dudu12345@")
                        .build())
                .submitLogin();
    }
    @Test
    public void deleteFirstContactList(){
        new ContactListScreen(driver)
                .deleteFirstContact()
                .isListSizeLessOnOne();
    }
    @Test
    public void deleteAllContacts(){
        new ContactListScreen(driver)
                .removeAllContacts()
                .isNoContactsHere();
    }
}