package base;

import gui.core.WebDriverFactory;
import gui.steps.LoginSteps;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import static gui.core.WebDriverInstance.driverInstance;

public abstract class BaseTest {
    // --- Steps classes ---
    protected LoginSteps loginSteps;

    @BeforeEach
    public void setup() {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driverInstance().setWebDriver(driver);  //We put driver with options to container

        loginSteps = new LoginSteps();
    }

    @AfterEach
    public void closeDriver() {
        WebDriver driver = driverInstance().getDriver();
        if (driver != null){
        driver.quit();
        }
    }
}
