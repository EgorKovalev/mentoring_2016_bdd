package addToCart.steps;

import addToCart.businessLogic.User;
import addToCart.pages.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import selenium.BaseSelenium;

public class LoginStepDef extends BaseSelenium {
    LoginPage loginPage = new LoginPage();
    User user = new User();

    @Given("^Logged in user$")
    public void loggedInUser(){
        navigateToBaseUrl();

        if(loginPage.isUserLoggedIn()) {
            loginPage.enterLink().click();
            loginPage.enterCredentials(user);
            loginPage.loginButton().click();
        }

        if (loginPage.secretQuestionsFormIsDisplayed()){
            loginPage.remindMeLaterButton().click();
        }
    }

    @When("^Logged out user$")
    public void loggedOutUser(){
        navigateToBaseUrl();
        loginPage.logOut();
    }
}
