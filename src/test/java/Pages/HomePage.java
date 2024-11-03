package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import screens.Screenshot;

import java.time.Duration;
import java.util.List;

public class HomePage {

    public void GoToControlApp(WebDriver driver) {
        driver.navigate().to("https://express-control.noonstg.team/requests");
    }

    public void LoginManually(WebDriver driver) throws InterruptedException {
        System.out.println("Please log in manually. The test will continue");
        Thread.sleep(70000);
    }
    public void ClickOnTEST_A1hub(WebDriver driver) {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        // Step 1: Click the dropdown to reveal the list
        By dropdownMenuLocator = By.xpath("//*[@id='wrapper']/div[1]/div[3]/div[1]/div/div/div/div[1]/div[1]");
        WebElement dropdownMenu = wait.until(ExpectedConditions.elementToBeClickable(dropdownMenuLocator));
        dropdownMenu.click();

        // Step 2: Select the "TEST-A1" option
        By testA1OptionLocator = By.xpath("//*[text()='TEST-A1']");
        WebElement testA1Option = wait.until(ExpectedConditions.visibilityOfElementLocated(testA1OptionLocator));
        testA1Option.click();

        wait.until(ExpectedConditions.textToBePresentInElement(dropdownMenu, "TEST-A1"));
    }

    public void waitHubMenuVisiblityANDassertThatHubIsTEST_A1(WebDriver driver, SoftAssert softAssert) {
        Screenshot screenshotObject=new Screenshot(driver);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
       // SoftAssert softAssert = new SoftAssert();
        By hubMenuLocator = By.xpath("//*[@id='wrapper']/div[1]/div[3]/div[1]/div/div/div/div[1]/div[1]");
        WebElement hubMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(hubMenuLocator));
        String selectedHub = hubMenu.getText();
        try {
            softAssert.assertEquals(selectedHub, "TEST-A1", "The selected Hub is not 'TEST-A1'.");
        } catch (AssertionError e) {
            screenshotObject.takeScreenshot("HUB_Selection_Failure");
            throw e;
        }
    }

    public void AssertThat_Selected_ServiceIsB2CDelivery(WebDriver driver, SoftAssert softAssert) {
        Screenshot screenshotObject=new Screenshot(driver);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        //SoftAssert softAssert = new SoftAssert();
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"wrapper\"]/div[2]/div[3]/div[2]/div[1]/div[2]/div[1]/div[1]/span[2]/div/div/div[1]/div[1]")));
        String selectedOption = dropdown.getText();
        try {
            softAssert.assertTrue(selectedOption.contains("B2C"));
        } catch (AssertionError e) {
            screenshotObject.takeScreenshot("B2C_Selection_Failure");
            throw e;
        }
    }
    public void AssertThat_Result_inTheSpecifiedColumnIsB2CDelivery(WebDriver driver, SoftAssert softAssert) {
        Screenshot screenshotObject=new Screenshot(driver);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        By columnElementsLocator = By.xpath("//*[@id='wrapper']/div[2]/div[3]/div[2]/div[2]/table/tbody/tr/td[2]");
        List<WebElement> columnElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(columnElementsLocator));
        for (WebElement element : columnElements) {
            String cellText = element.getText();
            try {
                softAssert.assertTrue(cellText.contains("b2c"), "Found a non-B2C Delivery order: " + cellText);
            }catch (AssertionError e) {
                screenshotObject.takeScreenshot("B2C_Results_Failure");
                throw e;
            }
            }
    }
    public void AssertThatStatusIsPending(WebDriver driver, SoftAssert softAssert) {
        Screenshot screenshotObject=new Screenshot(driver);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        //SoftAssert softAssert = new SoftAssert();
        WebElement dropdownIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"wrapper\"]/div[2]/div[3]/div[2]/div[1]/div[2]/div[1]/div[2]/span[2]/div/div/div[1]/div[1]")));
    String selectedOptionText = dropdownIcon.getText();
        try

    {
        softAssert.assertEquals(selectedOptionText, "Pending", "The selected dropdown option is not 'Pending'.");
    } catch(
    AssertionError e)

    {
        screenshotObject.takeScreenshot("Pending_Selection_Failure");
        throw e;
    }
}


    public void SelectAEcountryZoneAndAssert(WebDriver driver,SoftAssert softAssert){
        Screenshot screenshotObject=new Screenshot(driver);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
     // Step 1: Click the "Country Zone" dropdown to reveal the options
        By countryZoneDropdownLocator = By.xpath("//*[@id='wrapper']/div[2]/div[3]/div[2]/div[1]/div[2]/div[1]/div[5]/span[2]/div/div/div[1]/div[1]");
        WebElement countryZoneDropdown = wait.until(ExpectedConditions.elementToBeClickable(countryZoneDropdownLocator));
        countryZoneDropdown.click();

   // Step 2: Select the "AE" option from the dropdown
        By aeOptionLocator = By.xpath("//*[normalize-space(text())='AE']");
        WebElement aeOption = wait.until(ExpectedConditions.visibilityOfElementLocated(aeOptionLocator));
        aeOption.click();

        By pageContentLocator = By.xpath("//*[@id=\"wrapper\"]/div[2]/div[3]/div[2]/div[2]/div/div[1]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageContentLocator));

         //assert selected option & Re-locate and check if "AE" is selected in the dropdown
        countryZoneDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(countryZoneDropdownLocator));
        String selectedCountry = countryZoneDropdown.getText();
        try{
            softAssert.assertTrue(selectedCountry.contains("AE"), "The selected country is not 'AE'.");
            }
        catch(AssertionError e)
        {
            screenshotObject.takeScreenshot("Country_AE_Selection_Failure");
            throw e;
        }
    }



    public void ClickOnThirdItenInThePage(WebDriver driver){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement targetElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='wrapper']/div[2]/div[3]/div[2]/div[2]/table/tbody/tr[3]/td[1]")));
        try {
        targetElement.click();
    } catch (ElementNotInteractableException e) {
        System.out.println("Regular click failed, trying JavaScript click.");
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", targetElement);
    }}

}
