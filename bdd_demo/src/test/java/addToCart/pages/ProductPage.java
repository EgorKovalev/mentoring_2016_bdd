package addToCart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import selenium.BaseSelenium;

public class ProductPage extends BaseSelenium {
    public WebElement buyButton(){
        return driver.findElement(By.xpath("//div[@class='u-flL']/a"));
    }

    public WebElement setColorDroplist(){
        return driver.findElement(By.id("msku-sel-1"));
    }

    public WebElement setStorageCapacityDroplist(){
        return driver.findElement(By.id("msku-sel-2"));
    }

    public boolean colorParameterDisplayed(){
        try{
            return setColorDroplist().isDisplayed();
        }
        catch (NoSuchElementException ex){
            return false;
        }
    }

    public boolean storageCapacityParameterDisplayed(){
        try{
            return setStorageCapacityDroplist().isDisplayed();
        }
        catch (NoSuchElementException ex){
            return false;
        }
    }

    public void setProductParameters(){
        if (colorParameterDisplayed()){
            new Select(setColorDroplist()).selectByIndex(1);
        }
        if (storageCapacityParameterDisplayed()){
            new Select(setStorageCapacityDroplist()).selectByIndex(1);
        }
    }
}
