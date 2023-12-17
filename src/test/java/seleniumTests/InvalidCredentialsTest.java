package seleniumTests;

import base.BaseTest;
import gui.pages.LoginPage;
import gui.steps.LoginSteps;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InvalidCredentialsTest extends BaseTest {

    @Test
    public void InvalidCredsTest() {
        // -------  Arrange -------
        LoginPage loginPage = new LoginPage();
        LoginSteps loginSteps = new LoginSteps();

        String actualTextMessage = "";
        boolean isInvalidCredentialAlertElementVisible = false;

        // --------  Act -------
            loginPage.open();
            loginSteps.login("1", "1");

            actualTextMessage = loginPage.getMessageWhenCredentialIsWrong();
            isInvalidCredentialAlertElementVisible = loginPage.checkIsDisplayedInvalidCredentialAlertElement();

        // -------  Assert -------
        Assertions.assertEquals("Invalid credentials", actualTextMessage);
        Assertions.assertTrue(isInvalidCredentialAlertElementVisible);
    }
}

