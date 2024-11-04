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
       // Thread.sleep(70000);
        // Replace Thread.sleep(70000) with an explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));
        By elementLocator = By.xpath("//*[@id='wrapper']/div[2]/div[3]/div[2]/div[1]");
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));

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
    public void SelectDeliveryLegTypeAndAssert(WebDriver driver,SoftAssert softAssert) {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        Screenshot screenshotObject=new Screenshot(driver);
        // Step 1: Click the "Leg Type" menu to reveal options
        By legTypeMenuLocator = By.xpath("//*[@id='wrapper']/div[2]/div[3]/div[2]/div[1]/div[2]/div[1]/div[3]/span[2]/div/div/div[1]/div[1]");
        WebElement legTypeMenu = wait.until(ExpectedConditions.elementToBeClickable(legTypeMenuLocator));
        legTypeMenu.click();

        // Step 2: Select the "Delivery" option from the menu
        By deliveryOptionLocator = By.xpath("//*[normalize-space(text())='Delivery']");
        WebElement deliveryOption = wait.until(ExpectedConditions.visibilityOfElementLocated(deliveryOptionLocator));
        deliveryOption.click();

        /*Step 3: Wait until the page or specific content is loaded
        By pageContentLocatorr = By.xpath("//*[@id='wrapper']/div[2]/div[3]/div[2]/div[2]/div/div[1]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageContentLocatorr));*/
        ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");

        // Step 4: Re-locate the "Reason" menu to avoid stale element reference
        legTypeMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(legTypeMenuLocator));

        //assert that delivery is selected
        String selectedoption = legTypeMenu.getText();
        try {
            softAssert.assertTrue(selectedoption.contains("Delivery"), "The selected reason is not 'Delivery'.");
        } catch(
                AssertionError e)

        {
            screenshotObject.takeScreenshot("Delivery_Selection_Failure");
            throw e;
        }

    }
    public void SelectReasonAndAssert (WebDriver driver, SoftAssert softAssert) {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        Screenshot screenshotObject=new Screenshot(driver);
        // Step 1: Click the "Reason" menu to reveal options
        By reasonMenuLocator = By.xpath("//*[@id='wrapper']/div[2]/div[3]/div[2]/div[1]/div[2]/div[1]/div[4]/span[2]/div/div/div[1]/div[1]");
        WebElement reasonMenu = wait.until(ExpectedConditions.elementToBeClickable(reasonMenuLocator));
        reasonMenu.click();

        // Step 2: Select the "Rescheduled" option from the menu
        By rescheduledOptionLocator = By.xpath("//*[normalize-space(text())='rescheduled']");
        WebElement rescheduledOption = wait.until(ExpectedConditions.visibilityOfElementLocated(rescheduledOptionLocator));
        rescheduledOption.click();

        /* Step 3: Wait until the page or specific content is loaded
        By pageContentLocatorrr = By.xpath("//*[@id='wrapper']/div[2]/div[3]/div[2]/div[2]/div/div");
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageContentLocatorrr));
*/
        ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");

        // Step 4: Re-locate the "Reason" menu to avoid stale element reference
        reasonMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(reasonMenuLocator));

        // Step 4: Assert that "Rescheduled" is selected
        String selectedReason = reasonMenu.getText();
        try {
            softAssert.assertTrue(selectedReason.contains("Rescheduled"), "The selected reason is not 'Rescheduled'.");
        } catch(
                AssertionError e)

        {
            screenshotObject.takeScreenshot("reason_reschedueled_Selection_Failure");
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
/*
        By pageContentLocator = By.xpath("//*[@id=\"wrapper\"]/div[2]/div[3]/div[2]/div[2]/div/div[1]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageContentLocator));
*/
        ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");

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

    public void ResetAllSelectionsWithAssertion(WebDriver driver, SoftAssert softAssert) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Screenshot screenshotObject = new Screenshot(driver);
     // Step 1: Click the "Reset" button
        By resetButtonLocator = By.xpath("//*[@id='wrapper']/div[2]/div[3]/div[2]/div[1]/div[2]/div[2]/button");
        WebElement resetButton = wait.until(ExpectedConditions.elementToBeClickable(resetButtonLocator));
        resetButton.click();
        // Step 2: Verify that "Leg Type" menu is reset to "All"
        By legTypeMenuLocator = By.xpath("//*[@id='wrapper']/div[2]/div[3]/div[2]/div[1]/div[2]/div[1]/div[3]/span[2]/div/div/div[1]/div[1]");
        WebElement legTypeMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(legTypeMenuLocator));
        String legTypeText = legTypeMenu.getText();
        try {
            softAssert.assertEquals(legTypeText, "All", "The 'Leg Type' menu is not reset to 'All'.");
        }catch (AssertionError e) {
            screenshotObject.takeScreenshot("reset_Failure");
            throw e;
        }
        // Step 3: Verify that "Reason" menu is reset to "All"
        By reasonMenuLocator = By.xpath("//*[@id='wrapper']/div[2]/div[3]/div[2]/div[1]/div[2]/div[1]/div[4]/span[2]/div/div/div[1]/div[1]");
        WebElement reasonMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(reasonMenuLocator));
        String reasonText = reasonMenu.getText();
        try {
            softAssert.assertEquals(reasonText, "All", "The 'Reason' menu is not reset to 'All'.");
        }catch (AssertionError e) {
            screenshotObject.takeScreenshot("reset_Failure");
            throw e;
        }
    }


    public void ClickOnResultItem(WebDriver driver){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        //click on third result
    WebElement targetElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"wrapper\"]/div[2]/div[3]/div[2]/div[2]/table/tbody/tr[3]/td[1]")));
        try {
        targetElement.click();
    } catch (ElementNotInteractableException e) {
        System.out.println("Regular click failed, trying JavaScript click.");
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", targetElement);
    }}

}
