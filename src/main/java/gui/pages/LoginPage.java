package gui.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{
    private final String pageURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    private final By userNameInputLocator = By.xpath("//input[@name='username' and @placeholder='Username']");
    private final By userPasswordInputLocator = By.xpath("//input[@name='password']");
    private final By buttonLoginLocator = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']");
    private final By invalidCredentialTextLocator = By.xpath(" //p [text() = 'Invalid credentials']");
    private final By invalidCredentialAlertLocator = By.xpath("//div [@role = 'alert']");
    private final By forgotYourPasswordLocator = By.xpath("//div [@class='orangehrm-login-forgot']/child::p[1]");


    public void open(){
        driver.get(pageURL);
    }

    public void setUserName(String name){
        driver.findElement(userNameInputLocator).sendKeys(name);
    }

    public void setUserPassword(String password){
        driver.findElement(userPasswordInputLocator).sendKeys(password);
    }

    public void pressLoginButton (){
        driver.findElement(buttonLoginLocator).click();
    }

    public String getMessageWhenCredentialIsWrong(){
        return driver.findElement(invalidCredentialTextLocator).getText();

    }

    public boolean checkIsDisplayedInvalidCredentialAlertElement(){
        return driver.findElement(invalidCredentialAlertLocator).isDisplayed();
    }

    public void clickForgotYourPasswordLink (){
        driver.findElement(forgotYourPasswordLocator).click();
    }

}
