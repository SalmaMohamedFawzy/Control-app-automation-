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

    @Then("the Home status should be Pending")
    public void the_home_status_should_be_pending() {
       homePge.AssertThatStatusIsPending(driver,softAssert);
    }

    @And("the user clicks on the third item on the page")
    public void the_user_clicks_on_the_third_item_on_the_page() {
        homePge.ClickOnThirdItenInThePage(driver);
    }

    @And("complete soft assertion check")
    public void complete_soft_assertion_check() {
        softAssert.assertAll(); // Call once at the end
    }

}
