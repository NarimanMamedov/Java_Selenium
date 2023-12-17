package gui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ResetPasswordPage extends BasePage{
    private final By inputFieldUserNameLocator = By.xpath("//input[@name='username' and @placeholder='Username']");
    private final By buttonResetPasswordLocator = By.xpath("//button [text() = ' Reset Password ']");

    private WebElement actualUserNameInputField = this.driver.findElement(inputFieldUserNameLocator);
    private WebElement resetPasswordButton = this.driver.findElement(buttonResetPasswordLocator);


    private final By buttonCancelLocator = By.xpath("//button [text() = ' Cancel ']");
    private final String expectedResetPasswordURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/requestPasswordResetCode";
    private final By expectedNameModalWindow = By.xpath("//h6 [text()='Reset Password']");

    public void clickResetPasswordButton(){
        resetPasswordButton.click();
    }

    public String getModalWindowName(){
        return this.driver.findElement(this.expectedNameModalWindow).getText();
    }

    public String getCancelButtonText(){
        return this.driver.findElement(this.buttonCancelLocator).getText();
    }

    public String getPageUrl (){
        return driver.getCurrentUrl();
    }

    public WebElement getResetButtonText(){
        return resetPasswordButton;
    }

    public WebElement getActualUserNameInputField(){
        return actualUserNameInputField;
    }

    public void setUserName(String userName){
        actualUserNameInputField.sendKeys(userName);
    }

}
