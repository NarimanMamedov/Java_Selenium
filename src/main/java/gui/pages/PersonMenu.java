package gui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PersonMenu extends BasePage {
    private final By itemContactDetailsLocator = By.xpath("//div [contains (a, 'Contact Details')]");


    public void clickOnContactDetails () {
        WebElement linkContactDetails = driver.findElement(itemContactDetailsLocator);
        linkContactDetails.click();
    }
}
