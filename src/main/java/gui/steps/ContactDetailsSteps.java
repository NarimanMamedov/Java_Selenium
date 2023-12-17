package gui.steps;

import gui.pages.ContactDetailsPage;
import org.openqa.selenium.WebElement;

public class ContactDetailsSteps extends BaseSteps{
    private LoginSteps loginSteps = new LoginSteps();
    private MenuSteps menuSteps = new MenuSteps();
    private PersonMenuSteps personMenuSteps = new PersonMenuSteps();

    private ContactDetailsPage contactDetailsPage = new ContactDetailsPage();

    public void openContactDetailsPage(String userName, String userPassword){
        loginSteps.open();
        loginSteps.login(userName, userPassword);
        menuSteps.clickOnMyInfoMenu();
        personMenuSteps.clickOnContactDetails();
    }

    public void saveChangesAndRefreshPage () throws InterruptedException {
        contactDetailsPage.clickOnSaveButton();
        Thread.sleep(2000);
        contactDetailsPage.refreshPage();

    }

    public void setStreet2TextFieldValue(String street2Value) throws InterruptedException {
        WebElement webElement = contactDetailsPage.findStreet2TextField();
        contactDetailsPage.updateValueInInputField(webElement, street2Value);
    }

    public String getFieldStreet2Value () {
        return contactDetailsPage.getFieldStreet2Value();
    }

    public void setStateProvinceTextFieldValue(String stateProvinceValue) throws InterruptedException {
        WebElement webElement = contactDetailsPage.findStateProvinceTextField();
        contactDetailsPage.updateValueInInputField(webElement, stateProvinceValue);
    }

    public String getFieldStateProvinceValue (){
        return contactDetailsPage.getFieldStateProvinceValue();
    }

    public void setHomeTextFieldValue(String homeValue) throws InterruptedException {
        WebElement webElement = contactDetailsPage.findHomeTextField();
        contactDetailsPage.updateValueInInputField(webElement, homeValue);
    }

    public String getFieldHomeValue (){
        return contactDetailsPage.getFieldHomeValue();
    }

    public void setCountryInDropdown (String country) throws InterruptedException {
        contactDetailsPage.setCountryInDropdown(country);
    }
}
