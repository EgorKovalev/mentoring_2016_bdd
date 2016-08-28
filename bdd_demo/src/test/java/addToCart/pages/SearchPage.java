package addToCart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import selenium.BaseSelenium;

public class SearchPage extends BaseSelenium {

    public WebElement searchButton(){
        return driver.findElement(By.xpath("//*[@id='gh-btn']"));
    }
    public WebElement searchBox(){
        return driver.findElement(By.xpath(".//*[@id='gh-ac']"));
    }
    public WebElement searchResultItem(String number){
        return driver.findElement(By.xpath(
                "(//li[@class='lvformat']/span[contains(.,'Buy It Now')]/../../..)[" + number + "]"));
    }
    public WebElement searchResultItemTitle(String number){
        return driver.findElement(By.xpath(
                "(//li[@class='lvformat']/span[contains(.,'Buy It Now')]/../../..)[" + number + "]//h3/a"));
    }
}
