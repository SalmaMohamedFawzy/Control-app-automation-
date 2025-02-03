package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.asserts.SoftAssert;
import screens.Screenshot;

import java.time.Duration;
import java.util.List;

public class P02_HomePage {

    public void GoToControlApp(WebDriver driver) {
       driver.navigate().to("https://express-control.noonstg.team/requests"); //  staging
       // driver.navigate().to("https://express-control.noon.team/requests");   //prod

    }

    public void ClickOnTEST_A1hub(WebDriver driver) {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        // Step 1: Click the dropdown to reveal the list
        By dropdownMenuLocator = By.xpath("//*[@id='wrapper']/div[1]/div[3]/div[1]/div/div/div/div[1]/div[1]");
        WebElement dropdownMenu = wait.until(ExpectedConditions.elementToBeClickable(dropdownMenuLocator));
        String currentSelection = dropdownMenu.getText().trim();
        if (!"TEST-A1".equalsIgnoreCase(currentSelection)){
        dropdownMenu.click();

        // Step 2: Select the "TEST-A1" option
        By testA1OptionLocator = By.xpath("//*[text()='TEST-A1']");
        WebElement testA1Option = wait.until(ExpectedConditions.visibilityOfElementLocated(testA1OptionLocator));
        testA1Option.click();

        wait.until(ExpectedConditions.textToBePresentInElement(dropdownMenu, "TEST-A1"));
        }else {
            System.out.println("TEST-A1 is already selected, no action taken.");
        }
    }

    public void waitHubMenuVisiblityANDassertThatHubIsTEST_A1(WebDriver driver, SoftAssert softAssert) {
        Screenshot screenshotObject=new Screenshot(driver);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
       // SoftAssert softAssert = new SoftAssert();
        By hubMenuLocator = By.xpath("//*[@id='wrapper']/div[1]/div[3]/div[1]/div/div/div/div[1]/div[1]");
        WebElement hubMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(hubMenuLocator));
        String selectedHub = hubMenu.getText();

        if (!"TEST-A1".equals(selectedHub)) {
            screenshotObject.takeScreenshot("Hub_Selection_Failure");
        }
        softAssert.assertEquals(selectedHub, "TEST-A1", "The selected Hub is not 'TEST-A1'.");

    }

    public void AssertThat_Selected_ServiceIsB2CDelivery(WebDriver driver, SoftAssert softAssert) {
        Screenshot screenshotObject=new Screenshot(driver);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        //SoftAssert softAssert = new SoftAssert();
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"wrapper\"]/div[2]/div[3]/div[2]/div[1]/div[2]/div[1]/div[1]/span[2]/div/div/div[1]/div[1]")));
        String selectedOption = dropdown.getText();

        if (!selectedOption.toLowerCase().contains("b2c".toLowerCase())) {
            screenshotObject.takeScreenshot("B2C_Selection_Failure");
        }
        softAssert.assertTrue(selectedOption.toLowerCase().contains("b2c".toLowerCase()), "B2C not found in selected option!");
    }
    public void AssertThat_Result_inTheSpecifiedColumnIsB2CDelivery(WebDriver driver, SoftAssert softAssert) {
        Screenshot screenshotObject=new Screenshot(driver);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        By columnElementsLocator = By.xpath("//*[@id='wrapper']/div[2]/div[3]/div[2]/div[2]/table/tbody/tr/td[2]");
        List<WebElement> columnElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(columnElementsLocator));
        for (WebElement element : columnElements) {
            String cellText = element.getText();
            if (!cellText.toLowerCase().contains("b2c")) {
                screenshotObject.takeScreenshot("HomPg_B2C_Results_Column");
            }
            softAssert.assertTrue(cellText.toLowerCase().contains("b2c"), "Found a non-B2C Delivery order: " + cellText);
        }
    }
    public void AssertThatStatusIsPending(WebDriver driver, SoftAssert softAssert) {
        Screenshot screenshotObject=new Screenshot(driver);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dropdownIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"wrapper\"]/div[2]/div[3]/div[2]/div[1]/div[2]/div[1]/div[2]/span[2]/div/div/div[1]/div[1]")));
        String selectedOptionText = dropdownIcon.getText();
        if (!"pending".equalsIgnoreCase(selectedOptionText)) {
            screenshotObject.takeScreenshot("Pending_Selection_Failure");
        }
        softAssert.assertEquals(selectedOptionText.toLowerCase(), "pending", "The selected dropdown option is not 'Pending'.");
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

        ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");

        // Step 4: Re-locate the "Reason" menu to avoid stale element reference
        legTypeMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(legTypeMenuLocator));

        //assert that delivery is selected
        String selectedoption = legTypeMenu.getText();

        if (!"delivery".equalsIgnoreCase(selectedoption)) {
            screenshotObject.takeScreenshot("HomPg_Delivery_Selection");
        }
        softAssert.assertTrue(selectedoption.toLowerCase().contains("delivery".toLowerCase()), "The selected reason is not 'Delivery'.");

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

        ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");

        // Step 4: Re-locate the "Reason" menu to avoid stale element reference
        reasonMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(reasonMenuLocator));

        // Step 4: Assert that "Rescheduled" is selected
        String selectedReason = reasonMenu.getText();
        if (!"rescheduled".equalsIgnoreCase(selectedReason)) {
            screenshotObject.takeScreenshot("reason_rescheduled_Selection_Failure");
        }
        softAssert.assertTrue(selectedReason.toLowerCase().contains("rescheduled".toLowerCase()), "The selected reason is not 'Rescheduled'.");
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

        ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");

        //assert selected option & Re-locate and check if "AE" is selected in the dropdown
        countryZoneDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(countryZoneDropdownLocator));
        String selectedCountry = countryZoneDropdown.getText();
        if (!"AE".equals(selectedCountry)) {
            screenshotObject.takeScreenshot("HomPg_Country_AE");
        }
        softAssert.assertTrue(selectedCountry.contains("AE"), "The selected country is not 'AE'.");
    }

    public void SelectHubSectorAndAssert(WebDriver driver,SoftAssert softAssert){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Screenshot screenshotObject = new Screenshot(driver);
     // Step 1: Click on the "Hub Sector" menu to reveal options
        By hubSectorMenuLocator = By.xpath("//*[@id='wrapper']/div[2]/div[3]/div[2]/div[1]/div[2]/div[1]/div[6]/span[2]/div/div/div[1]/div[1]");
        WebElement hubSectorMenu = wait.until(ExpectedConditions.elementToBeClickable(hubSectorMenuLocator));
        hubSectorMenu.click();

        // Step 2: Select the "TEST-A1-S" option from the dropdown
        By hubOptionLocator = By.xpath("//*[normalize-space(text())='TEST-A1-S']");
        WebElement hubOption = wait.until(ExpectedConditions.elementToBeClickable(hubOptionLocator));
        hubOption.click();

        ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");

        // Step 3: Verify that "TEST-A1-S" is displayed in the "Hub Sector" menu
        WebElement selectedHubSector = wait.until(ExpectedConditions.visibilityOfElementLocated(hubSectorMenuLocator));
        String selectedHubText = selectedHubSector.getText();
        if (!"TEST-A1-S".equals(selectedHubText)) {
            screenshotObject.takeScreenshot("HomPg_Hub_Sector");
        }
        softAssert.assertTrue(selectedHubText.contains("TEST-A1-S"), "The selected hub is not displayed as 'TEST-A1-S'.");

    }

    public void SelectPickupTypeAndAssert(WebDriver driver,SoftAssert softAssert){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Screenshot screenshotObject = new Screenshot(driver);
        // Step 1: Click on the menu to reveal options
        By menuLocator = By.xpath("//*[@id='wrapper']/div[2]/div[3]/div[2]/div[1]/div[2]/div[1]/div[7]/span[2]/div/div/div[1]/div[1]");
        WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(menuLocator));
        menu.click();

        // Step 2: Select the "Regular" option from the dropdown
        By regularOptionLocator = By.xpath("//*[normalize-space(text())='Regular']");
        WebElement regularOption = wait.until(ExpectedConditions.elementToBeClickable(regularOptionLocator));
        regularOption.click();

        ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");

        // Step 3: Verify that "Regular" appears in the menu
        WebElement selectedMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(menuLocator));
        String selectedMenuText = selectedMenu.getText();
        if (!"Regular".equals(selectedMenuText)) {
            screenshotObject.takeScreenshot("Pickup_Type_Failure");
        }
        softAssert.assertTrue(selectedMenuText.contains("Regular"), "The selected option is not displayed as 'Regular'.");
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
        if (!"All".equals(legTypeText)) {
            screenshotObject.takeScreenshot("reset_Failure");
        }
        softAssert.assertEquals(legTypeText, "All", "The 'Leg Type' menu is not reset to 'All'.");
        // Step 3: Verify that "Reason" menu is reset to "All"
        By reasonMenuLocator = By.xpath("//*[@id='wrapper']/div[2]/div[3]/div[2]/div[1]/div[2]/div[1]/div[4]/span[2]/div/div/div[1]/div[1]");
        WebElement reasonMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(reasonMenuLocator));
        String reasonText = reasonMenu.getText();
        if (!"All".equals(reasonText)) {
            screenshotObject.takeScreenshot("reset_Failure");
        }
        softAssert.assertEquals(reasonText, "All", "The 'Reason' menu is not reset to 'All'.");
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
