package Tests;

import Pages.SecondSelectedPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static Hooks.hooks.driver;


public class SecondPageSteps {
    SecondSelectedPage secPage = new SecondSelectedPage();

    /*@Test(dependsOnMethods = "Tests.Home.loginTest")
    @Description("Second test to verify client reference and request details")
    @Severity(SeverityLevel.NORMAL)
    public void SecTest() throws InterruptedException {
        System.out.println("Driver before use in SecTest: " + driver);
        if (driver == null) {
            throw new RuntimeException("WebDriver is not initialized in SecTest!");
        }
        SecPge.AssertClientReferencecIs_NAE584747(driver);
        SecPge.AssertClientRequestIsCR04N01M10244980554(driver);
        SecPge.AssertStatusIsPending(driver);
        SecPge.AssertTypeIsb2cdelivery(driver);
    }*/
    @Given("the user is logged in")
    public void theUserIsLoggedIn() {
        System.out.println("Driver before use in SecTest: " + driver);
        if (driver == null) {
            throw new RuntimeException("WebDriver is not initialized in SecTest!");
        }
    }
    //select the test-a1 from the list

    @When("the user verifies the client reference")
    public void theUserVerifiesTheClientReference() {
        secPage.AssertClientReferencecIs_NAE584747(driver);
    }

    @And("the user verifies the client request details")
    public void theUserVerifiesTheClientRequestDetails() {
        secPage.AssertClientRequestIsCR04N01M10244980554(driver);
    }

    @Then("the status should be Pending")
    public void theStatusShouldBePending() {
        secPage.AssertStatusIsPending(driver);
    }

    @And("the type should be B2C Delivery")
    public void theTypeShouldBeB2CDelivery() {
        secPage.AssertTypeIsb2cdelivery(driver);
    }

    //return to home
    @And("I return to the homepage")
    public void returnToHome() {
        WebElement homeButton = driver.findElement(By.xpath("//*[@id='wrapper']/div[1]/div[2]/a/img"));
        homeButton.click();
    }
}