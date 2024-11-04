package Tests;

import Pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;

import static Hooks.hooks.driver;

public class HomeSteps {

    HomePage homePge = new HomePage();
    SoftAssert softAssert = new SoftAssert();

   @Given("the user navigates to the control app")
   public void the_user_navigates_to_the_control_app() {
       if (driver == null) {
           throw new RuntimeException("WebDriver is not initialized!");
       }
       homePge.GoToControlApp(driver);
   }

    @When("the user logs in manually and select TEST-A1")
    public void the_user_logs_in_manually_and_select_TESTA1() throws InterruptedException {
        homePge.LoginManually(driver);
        homePge.ClickOnTEST_A1hub(driver);
    }

    @Then("the hub menu should be visible and assert that it is TEST_A1")
    public void the_hub_menu_should_be_visible_and_assert_that_it_is_test_a1() {
        homePge.waitHubMenuVisiblityANDassertThatHubIsTEST_A1(driver,softAssert);
    }

    @Then("the service should be B2C Delivery")
    public void the_service_should_be_b2c_delivery() {
        homePge.AssertThat_Selected_ServiceIsB2CDelivery(driver,softAssert);
        homePge.AssertThat_Result_inTheSpecifiedColumnIsB2CDelivery(driver,softAssert);
    }

    @Then("the home status should be Pending")
    public void the_home_status_should_be_pending() {
       homePge.AssertThatStatusIsPending(driver,softAssert);
    }
    @Then("the leg Type should be Delivery")
    public void the_legType_should_be_delivery() {
       homePge.SelectDeliveryLegTypeAndAssert(driver,softAssert);
    }

    @Then("the reason should be rescheduled")
    public void the_reason_should_be_rescheduled() {
       homePge.SelectReasonAndAssert(driver,softAssert);
    }

        @And("the country should be AE")
    public void CountryAEselectionAndAssertion() {
        homePge.SelectAEcountryZoneAndAssert(driver,softAssert);
    }

    @And("the user clicks on the result item")
    public void the_user_clicks_on_the_result_item() {
        homePge.ClickOnResultItem(driver);
    }

    @And("complete soft assertion check")
    public void complete_soft_assertion_check() {
        softAssert.assertAll(); // Call once at the end
    }

}
