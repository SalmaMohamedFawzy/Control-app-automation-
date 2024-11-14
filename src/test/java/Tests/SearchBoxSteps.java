package Tests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static Hooks.hooks.driver;

public class SearchBoxSteps {
    @Given("Iam on the homepage again")
    public void iAmOnTheHomepageAgain() {
        System.out.println("Driver before use in search: " + driver);
        if (driver == null) {
            throw new RuntimeException("WebDriver is not initialized in search!");
        }
    }
    @When("I enter {string} in the search box")
    public void i_enter_in_the_search_box(String searchText) {
        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[2]/div[3]/div[2]/div[1]/div[1]/form/input"));
        searchBox.clear();
        searchBox.sendKeys(searchText);
        searchBox.sendKeys(Keys.RETURN);
    }

    @Then("I verify that the item or message {string} is displayed")
    public void i_verify_that_the_item_or_message_is_displayed(String expectedResult) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement resultsArea = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"wrapper\"]/div[2]/div[3]/div[2]")));

        if ("Specific Item".equals(expectedResult)) {
            ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            WebElement specificItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"wrapper\"]/div[2]/div[3]/div[2]/div[2]/table/tbody/tr/td[1]")));
            Assert.assertTrue(specificItem.isDisplayed(),"Expected item not found for: " + specificItem.getText());

        } else if ("No data available".equals(expectedResult)) {
            ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, document.body.scrollHeight)");
            WebElement noDataMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"wrapper\"]/div[2]/div[3]/div[2]/div[2]/div")));
            String noDataMessageText = noDataMessageElement.getText();
            Assert.assertEquals(noDataMessageText,"Uh-oh! No Data Available","No message is displayed");
        }
    }
}
