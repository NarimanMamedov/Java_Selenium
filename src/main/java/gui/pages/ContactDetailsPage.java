package gui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ContactDetailsPage extends BasePage{

    private final By itemMyInfoLocator = By.xpath( "//a [contains (span, 'My Info')]/parent::*");
    private final By fieldStreet2Locator = By.xpath("//div [contains (label, 'Street 2')]/following::div[1]/input");
    private final By fieldStateProvinceLocator = By.xpath("//div [contains (label, 'State/Province')]/following::input[1]");
    private final By fieldHomeLocator = By.xpath("//div [contains (label, 'Home')]/following::input[1]");
    private final By buttonSaveLocator = By.xpath("//button [text() = ' Save ']");
    private final By countryDropdownLocator = By.xpath("//div[@class='oxd-select-text-input']");
    private final By countryDropdownItemLocator = By.xpath("//div[@role='listbox']//span");

    public void clickOnSaveButton (){
        new Actions(driver)
                .click(driver.findElement(buttonSaveLocator))
                .perform();
    }

    public WebElement findStreet2TextField (){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(fieldStreet2Locator));
        return driver.findElement(fieldStreet2Locator);
    }

    public String getFieldStreet2Value () {
        return getInputFieldValue(fieldStreet2Locator);
    }

    public void setCountryInDropdown (String country) throws InterruptedException {
        driver.findElement(countryDropdownLocator).click();
        Thread.sleep(2000);
        //WebElement countryItem = driver.findElement(By.xpath("//div[@role='listbox']//*[text()='Algeria']"));
        // System.out.println("===> ELEMENT TAG: " + countryItem.getTagName());

        List<WebElement> countryItems = driver.findElements(countryDropdownItemLocator);
        for(WebElement item : countryItems) {
            //System.out.println("===> Country form the list: " + item.getText());
            if (item.getText().equals(country)){
                item.click();
                break;
            }
        }
    }

    public WebElement findStateProvinceTextField (){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(fieldStateProvinceLocator));
        return driver.findElement(fieldStateProvinceLocator);
    }

    public String getFieldStateProvinceValue (){
        return getInputFieldValue(fieldStateProvinceLocator);
    }

    public WebElement findHomeTextField (){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(fieldHomeLocator));
        return driver.findElement(fieldHomeLocator);
    }

    public String getFieldHomeValue (){
        return getInputFieldValue(fieldHomeLocator);
    }
}



