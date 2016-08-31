package selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseSelenium {
    public static WebDriver driver;
    protected static Actions actions;

    public static void init(){
        //System.setProperty("webdriver.chrome.driver", "c:\\tools\\chromedriver.exe");
        driver = new FirefoxDriver();
        actions = new Actions(driver);
        driver.manage().window().maximize();
        navigateToBaseUrl();
    }

    public static void close(){
        try {
            driver.quit();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        finally{
            driver = null;
        }
    }

    protected static void navigateToBaseUrl(){
        driver.get("http://www.ebay.com");
    }

    public static void navigateTo(String url){
        driver.get(url);
    }

    public void waitForPageToLoad() {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(expectation);
        } catch (Throwable error) { }
    }
}
