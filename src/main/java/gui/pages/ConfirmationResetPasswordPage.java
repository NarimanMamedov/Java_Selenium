package gui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static gui.core.WebDriverInstance.driverInstance;

public class ConfirmationResetPasswordPage extends BasePage{

    private final By formTitleLocator = By.xpath("//h6 [text() = 'Reset Password link sent successfully']");

    public ConfirmationResetPasswordPage (){
        this.driver = driverInstance().getDriver();
    }

    public WebElement getFormTitleElement(){
        return  driver.findElement(formTitleLocator);
    }
}
