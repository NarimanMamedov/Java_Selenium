package gui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Menu extends BasePage{

    private final By itemMyInfoLocator = By.xpath( "//a [contains (span, 'My Info')]/parent::*");

    public void clickOnMyInfoMenu () {
        WebElement linkMyInfo = driver.findElement(itemMyInfoLocator);
        linkMyInfo.click();
    }

}
