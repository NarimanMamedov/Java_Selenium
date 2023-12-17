package seleniumTests;

import base.BaseTest;
import gui.models.LoginTestData;
import gui.pages.ConfirmationResetPasswordPage;
import gui.pages.ResetPasswordPage;
import gui.utils.JsonFileReader;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;

public class PasswordRecoveryTest extends BaseTest {
// TODO implement Steps logic for current test
    private LoginTestData loginTestData = JsonFileReader.readJsonFile("src/test/java/configFiles/LoginTestData.json", LoginTestData.class);
    private ResetPasswordPage resetPasswordPage;
    private ConfirmationResetPasswordPage confirmationResetPasswordPage;

    @Test
    public void validateResetPasswordForm() throws InterruptedException {
        loginSteps.open();
        loginSteps.clickForgotYourPasswordLink();
        resetPasswordPage = new ResetPasswordPage();

        // -------  Arrange -------

        final String expectedResetPasswordURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/requestPasswordResetCode";
        String actualNameResetPasswordWindow = "";
        String actualURL = "";
        String actualNameFromButtonCancel = "";

        // --------  Act -------
        try {
            actualURL = resetPasswordPage.getPageUrl();
            actualNameResetPasswordWindow = resetPasswordPage.getModalWindowName();
            actualNameFromButtonCancel = resetPasswordPage.getCancelButtonText();

        } catch (Error e) {
            System.out.println(e.getMessage());
        }

        // -------  Assert -------
        Thread.sleep(9000);
        Assertions.assertNotNull(resetPasswordPage.getActualUserNameInputField());
        Assertions.assertEquals(expectedResetPasswordURL, actualURL);
        Assertions.assertEquals("Reset Password", actualNameResetPasswordWindow);
        Assertions.assertNotNull(actualNameFromButtonCancel);
        Assertions.assertNotNull(resetPasswordPage.getResetButtonText());
    }

    @Test
    public void TestFunctionalityOfResetPasswordForm() {
        // -------  Arrange -------

        WebElement formTitle = null;
        confirmationResetPasswordPage = new ConfirmationResetPasswordPage();

        // -------  Act -------
        loginSteps.open();
        loginSteps.clickForgotYourPasswordLink();

        resetPasswordPage = new ResetPasswordPage();

        try {
            resetPasswordPage.setUserName(loginTestData.getUserName());
            resetPasswordPage.clickResetPasswordButton();
            formTitle = confirmationResetPasswordPage.getFormTitleElement();

        } catch (Error e) {
            System.out.println(e.getMessage());
        }
        // -------  Assert -------
        Assertions.assertNotNull(formTitle);
    }
}
