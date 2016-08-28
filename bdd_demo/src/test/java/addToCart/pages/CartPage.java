package addToCart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import selenium.BaseSelenium;

public class CartPage extends BaseSelenium {
    private int counter = 0;

    public WebElement paymentMethodControl(){
        return driver.findElement(By.id("payment-methods-ctr"));
    }

    public boolean paymentMethodControlIsDisplayed(){
        try{
            return paymentMethodControl().isDisplayed();
        }
        catch(NoSuchElementException ex){
            return false;
        }
    }

    public void clickGoToCartLink(){
        try{
            driver.findElement(By.xpath("//a[@title='Click to goto cart']")).click();
        }
        catch (NoSuchElementException ex){
            driver.navigate().back();
        }
    }

    public int productsNumberInCart(){
        return driver.findElements(By.xpath("//div[@id='ShopCart']/div/div[contains(@id,'sellerBucket')]")).size();
    }
}
