package addToCart.pages;

import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import selenium.BaseSelenium;

public class TopMenu extends BaseSelenium {

    protected WebElement enterLink(){
        return driver.findElement(By.xpath("//div[@id='gh-top']/ul/li//a[contains(.,'Sign in')]"));
    }

    protected void switchToEnglish(){
        WebElement drop = driver.findElement(By.xpath("//li[@id='gh-eb-Geo']/div[@class='gh-menu']"));
        actions.moveToElement(drop).build().perform();
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException ex){}
        driver.findElement(By.id("gh-eb-Geo-a-en")).click();
    }
}
