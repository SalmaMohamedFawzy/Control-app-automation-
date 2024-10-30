package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.asserts.SoftAssert;
import screens.Screenshot;

import java.time.Duration;

public class HomePage {

    public void GoToControlApp(WebDriver driver) {
        driver.navigate().to("https://express-control.noonstg.team/requests");
    }

    public void LoginManually(WebDriver driver) throws InterruptedException {
        System.out.println("Please log in manually. The test will continue");
        Thread.sleep(70000);
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

    public void AssertThatServiceIsB2CDelivery(WebDriver driver, SoftAssert softAssert) {
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

    public void ClickOnThirdItenInThePage(WebDriver driver){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement targetElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='wrapper']/div[2]/div[3]/div[2]/div[2]/table/tbody/tr[3]/td[1]")));
        try {
        targetElement.click();
    } catch (ElementNotInteractableException e) {
        System.out.println("Regular click failed, trying JavaScript click.");
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", targetElement);
    }}
    /*to click on test_a1 from menu
     try {
            hubMenu.click();  // Regular click
        } catch (org.openqa.selenium.ElementNotInteractableException e) {
            System.out.println("Using JavaScript click due to ElementNotInteractableException");
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", hubMenu);  // JS click as fallback
        }
        WebElement classElement = driver.findElement(By.className("css-12sut97"));
        classElement.click();*/
}
