package Tests;

import Pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static Hooks.hooks.driver;

public class HomeSteps {

    HomePage homePge = new HomePage();

    /* @Test
    @Description("Test to manually log in and verify various aspects on the homepage")
    @Severity(SeverityLevel.CRITICAL)
    public void loginTest() throws InterruptedException {

        homePge.GoToControlApp(driver);
        homePge.LoginManually(driver);
        homePge.waitHubMenuVisiblityANDassertThatHubIsTEST_A1(driver);
        homePge.AssertThatServiceIsB2CDelivery(driver);
        homePge.AssertThatStatusIsPending(driver);
        homePge.ClickOnThirdItenInThePage(driver);
        System.out.println("loginTest completed.");
    }*/
   @Given("the user navigates to the control app")
   public void the_user_navigates_to_the_control_app() {
       if (driver == null) {
           throw new RuntimeException("WebDriver is not initialized!");
       }
       homePge.GoToControlApp(driver);
   }

    @When("the user logs in manually")
    public void the_user_logs_in_manually() throws InterruptedException {
        homePge.LoginManually(driver);
    }

    @Then("the hub menu should be visible and assert that it is TEST_A1")
    public void the_hub_menu_should_be_visible_and_assert_that_it_is_test_a1() {
        homePge.waitHubMenuVisiblityANDassertThatHubIsTEST_A1(driver);
    }

    @Then("the service should be B2C Delivery")
    public void the_service_should_be_b2c_delivery() {
        homePge.AssertThatServiceIsB2CDelivery(driver);
    }

    @Then("the Home status should be Pending")
    public void the_home_status_should_be_pending() {
        homePge.AssertThatStatusIsPending(driver);
    }

    @And("the user clicks on the third item on the page")
    public void the_user_clicks_on_the_third_item_on_the_page() {
        homePge.ClickOnThirdItenInThePage(driver);
    }
}
