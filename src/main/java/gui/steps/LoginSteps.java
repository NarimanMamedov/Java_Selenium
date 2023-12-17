package gui.steps;


public class LoginSteps extends BaseSteps {


    public void open(){
        loginPage.open();
    }

    public void login (String userName, String userPassword){
        loginPage.setUserName(userName);
        loginPage.setUserPassword(userPassword);
        loginPage.pressLoginButton();
    }

    public String getPageTitle(){
        return loginPage.getPageTitle();
    }

    public String getPageURL(){
        return loginPage.getPageURL();
    }

    public void clickForgotYourPasswordLink (){
        loginPage.clickForgotYourPasswordLink();
    }

}
