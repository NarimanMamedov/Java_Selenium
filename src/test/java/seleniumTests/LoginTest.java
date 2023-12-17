package seleniumTests;

import base.BaseTest;
import gui.models.LoginTestData;
import gui.utils.JsonFileReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.apache.log4j.Logger;

public class LoginTest extends BaseTest {
    private static final Logger log = Logger.getLogger(String.valueOf(LoginTest.class));
    private LoginTestData loginTestData = JsonFileReader.readJsonFile("src/test/java/configFiles/LoginTestData.json", LoginTestData.class);

    @Test
    public void seleniumTest() {
        log.info("Start login test");

        // -------  Arrange -------
        log.debug("User name: " + loginTestData.getUserName());
        log.debug("User pass: " + loginTestData.getUserPassword());

        final String expectedTitle = "OrangeHRM";
        final String expectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";

        // --------  Act -------
        loginSteps.open();
        log.info("Open url");
        loginSteps.login(loginTestData.getUserName(), loginTestData.getUserPassword());
        log.info("Set user name and password" + loginTestData.getUserName() + ", " + loginTestData.getUserPassword());
        String actualTitle = loginSteps.getPageTitle();
        String actualURL = loginSteps.getPageURL();

        // -------  Assert -------
        Assertions.assertEquals(expectedTitle, actualTitle);
        Assertions.assertEquals(expectedURL, actualURL);
    }
}
