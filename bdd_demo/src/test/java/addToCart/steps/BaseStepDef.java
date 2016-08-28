package addToCart.steps;

import addToCart.pages.CartPage;
import addToCart.pages.LoginPage;
import addToCart.pages.ProductPage;
import addToCart.pages.SearchPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import selenium.BaseSelenium;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class BaseStepDef extends BaseSelenium {
    private SearchPage searchPage = new SearchPage();
    private ProductPage productPage = new ProductPage();
    private LoginPage loginPage = new LoginPage();
    private CartPage cartPage = new CartPage();

    private final String cartUrl = "http://cart.payments.ebay.com/sc/view";

    @When("^I set search request \"([^\"]*)\"$")
    public void iSetSearchRequest(String searchRequest){
        searchPage.waitForPageToLoad();
        searchPage.searchBox().sendKeys(searchRequest);
    }

    @When("^I perform search$")
    public void iPerformSearch(){
        searchPage.waitForPageToLoad();
        searchPage.searchButton().click();
    }

    @Then("^the term query \"([^\"]*)\" should be the first in the Search Result grid$")
    public void theTermQueryShouldBeTheFirstInTheSearchResultGrid(String expectPhrase){
        String firstSnippet = searchPage.searchResultItem("1").getText();
        assertThat(firstSnippet,containsString(expectPhrase));
    }

    @When("^I select item \"([^\"]*)\" in the list$")
    public void iSelectItemInTheList(String number){
        searchPage.waitForPageToLoad();
        searchPage.searchResultItemTitle(number).click();
    }

    @When("^I click buy now button$")
    public void iClickBuyNowButton(){
        productPage.setProductParameters();
        productPage.buyButton().click();
    }

    @Then("^I verify that login page is displayed$")
    public void iVerifyThatLoginPageIsDisplayed(){
        assertTrue(loginPage.loginBox().isDisplayed());
    }

    @Then("^I verify that checkout page is displayed$")
    public void iVerifyThatCheckoutPageIsDisplayed(){
        assertTrue(cartPage.paymentMethodControl().isDisplayed());
    }

    @When("^I go to cart$")
    public void iGoToCart(){
        cartPage.waitForPageToLoad();
        cartPage.clickGoToCartLink();
    }

    @Then("^I verify that the cart is not empty$")
    public void iVerifyThatTheNumberOfItemsInTheCartIsEqualsTo(){
        cartPage.waitForPageToLoad();
        navigateTo(cartUrl);
        assertTrue(cartPage.productsNumberInCart() != 0);
    }

    @When("^Switch locale to English$")
    public void switchLocaleToEnglish(){
        loginPage.switchToEnglish();
    }
}
