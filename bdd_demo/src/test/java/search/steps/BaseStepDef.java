package search.steps;

import addToCart.pages.SearchPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import selenium.BaseSelenium;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

public class BaseStepDef extends BaseSelenium {
    private SearchPage searchPage = new SearchPage();

    @Given("^I set search request \"([^\"]*)\"$")
    public void iSetSearchRequest(String searchRequest){
        searchPage.searchBox().sendKeys(searchRequest);
    }

    @When("^I perform search$")
    public void iPerfomSearch(){
        searchPage.searchButton().click();
    }

    @Then("^the term query \"([^\"]*)\" should be the first in the Search Result grid$")
    public void theTermQueryShouldBeTheFirstInTheSearchResultGrid(String expectPhrase){
        String firstSnippet = searchPage.searchResultItem("1").getText();
        assertThat(firstSnippet,containsString(expectPhrase));
    }
}
