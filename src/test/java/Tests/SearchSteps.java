package Tests;

import Pages.searchPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import screens.Screenshot;

import java.time.Duration;

import static Hooks.hooks.driver;

public class SearchSteps {
    private SoftAssert softAssert = new SoftAssert();
    searchPage searchpge=new searchPage();
    @Given("I am on the homepage")
    public void iAmOnTheHomepage() {
        System.out.println("Driver before use in search: " + driver);
        if (driver == null) {
            throw new RuntimeException("WebDriver is not initialized in search!");
        }
    }

    @When("I enter a search term")
    public void iEnterASearchTerm() {
        searchpge.EnterSearchTerm(driver);
    }

    @When("I click on the search icon")
    public void iClickOnTheSearchIcon() {
        searchpge.ClickOnTheSearchIcon(driver);
    }

    @Then("I should see search results")
    public void iShouldSeeSearchResults() {
        searchpge.SearchResults(driver,softAssert);
    }

    @And("I return to the homepage again")
    public void returnToHomeAgain() {
       searchpge.returnToHomeAgain(driver);
    }

    @And("I should see the homepage logo again")
    public void IshouldSeeHomeLogoAgain() {
        searchpge.SeeHomeLogoAgain(driver,softAssert);
    }

    @Then("I assert all results")
    public void assertAllResults() {
        softAssert.assertAll();
    }
}
