package gui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static gui.core.WebDriverInstance.driverInstance;

public abstract class BasePage {
    private static final String ATTRIBUTE_VALUE = "value";
    protected WebDriver driver;

    public BasePage(){
        this.driver = driverInstance().getDriver();
    }

    public String getPageTitle() {
        return this.driver.getTitle();
    }

    public String getPageURL(){
        return this.driver.getCurrentUrl();
    }

    public void updateValueInInputField(WebElement webElement, String newValue) throws InterruptedException {
        Thread.sleep(3000);
        new Actions(driver)
                .click(webElement)
                .keyDown(Keys.CONTROL)
                .sendKeys("A")
                .keyUp(Keys.CONTROL)
                .keyDown(Keys.DELETE)
                .sendKeys(newValue)
                .perform();
    }

    public void refreshPage () throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(3000);
    }

    public String getInputFieldValue (By locator){
        return driver.findElement(locator).getAttribute(ATTRIBUTE_VALUE);
    }
}
