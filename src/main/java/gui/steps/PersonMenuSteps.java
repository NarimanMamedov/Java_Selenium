package gui.steps;

import gui.pages.PersonMenu;

public class PersonMenuSteps extends BaseSteps {
    private PersonMenu personMenu = new PersonMenu();

    public void clickOnContactDetails (){
        personMenu.clickOnContactDetails();
    }
}
