package addToCart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import selenium.BaseSelenium;

public class TopMenu extends BaseSelenium {
    private String languageSwitcherlocator = "//li[@id='gh-eb-Geo']/div[@class='gh-menu']";

    protected WebElement enterLink(){
        return driver.findElement(By.xpath("//div[@id='gh-top']/ul/li//a[contains(.,'Sign in')]"));
    }

    public WebElement languageSwitcher(){
        return driver.findElement(By.xpath(languageSwitcherlocator));
    }

    public boolean languageSwitcherIsDisplayed(){
        try{
            return languageSwitcher().isDisplayed();
        }
        catch (NoSuchElementException ex){
            return false;
        }
    }

    protected void switchToEnglish(){
        if(languageSwitcherIsDisplayed()) {
            actions.moveToElement(languageSwitcher()).build().perform();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
            driver.findElement(By.id("gh-eb-Geo-a-en")).click();
        }
    }

    protected void logOut(){
        WebElement drop = driver.findElement(By.xpath("//li[@id='gh-eb-u']/a"));
        actions.moveToElement(drop).build().perform();
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException ex){}
        driver.findElement(By.xpath("//li[@id='gh-uo']/a")).click();
    }
}
