package addToCart.pages;

import addToCart.businessLogic.User;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class LoginPage extends TopMenu {
    private TopMenu topMenu = new TopMenu();

    public WebElement loginBox(){
        return driver.findElement(By.id("mainCnt"));
    }

    public WebElement enterLink(){
        return topMenu.enterLink();
    }

    public boolean isUserLoggedIn(){
        try{
            topMenu.waitForPageToLoad();
            return enterLink().isDisplayed();
        }
        catch(NoSuchElementException ex){
            return false;
        }
    }

    public WebElement loginButton(){
        return driver.findElement(By.id("sgnBt"));
    }

    public void enterCredentials(User user){
        actions.sendKeys(user.getUserName()).sendKeys(Keys.TAB).sendKeys(user.getPassword()).build().perform();
    }

    public boolean secretQuestionsFormIsDisplayed(){
        try{
            return driver.findElement(By.id("secretQuesForm")).isDisplayed();
        }
        catch (NoSuchElementException ex){
            return false;
        }
    }

    public WebElement remindMeLaterButton(){
        return driver.findElement(By.id("rmdLtr"));
    }

    public void switchToEnglish(){
        navigateToBaseUrl();
        topMenu.switchToEnglish();
    }

    public void logOut(){
        navigateToBaseUrl();
        topMenu.waitForPageToLoad();
        topMenu.logOut();
    }
}
