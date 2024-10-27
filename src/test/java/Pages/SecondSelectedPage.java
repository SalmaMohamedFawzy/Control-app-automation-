package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import screens.Screenshot;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

public class SecondSelectedPage {

    public void AssertClientReferencecIs_NAE584747(WebDriver driver)
    {
        Screenshot screenshotObject=new Screenshot(driver);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        SoftAssert softAssert = new SoftAssert();
        WebElement clientReference = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='wrapper']/div[2]/div[3]/div[2]/div/div[1]/div[1]/span")));
    String clientReferenceText = clientReference.getText();
        try{softAssert.assertEquals("Client reference mismatch!", "CLIENT REFERENCE: NAE187763", clientReferenceText);
    }
        catch (AssertionError e) {
        screenshotObject.takeScreenshot("Client_reference_Failure");
        throw e;
    }
    softAssert.assertAll();
    }
    public void AssertClientRequestIsCR04N01M10244980554 (WebDriver driver){
        Screenshot screenshotObject=new Screenshot(driver);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        SoftAssert softAssert = new SoftAssert();
        WebElement clientRequest = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='wrapper']/div[2]/div[3]/div[2]/div/div[1]/div[2]/div/div/div[2]/span[2]")));
        String clientRequestText = clientRequest.getText();
        try{
            softAssert.assertEquals("Client request mismatch!", "CR04N01M10244980554", clientRequestText);
        }
        catch (AssertionError e) {
            screenshotObject.takeScreenshot("Client_request_Failure");
            throw e;
        }
        softAssert.assertAll();
    }
    public void AssertStatusIsPending(WebDriver driver)
    {
        Screenshot screenshotObject=new Screenshot(driver);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        SoftAssert softAssert = new SoftAssert();
        WebElement status = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='wrapper']/div[2]/div[3]/div[2]/div/div[1]/div[2]/div/div/div[3]/span[2]")));
        String statusText = status.getText();
        try{softAssert.assertEquals("Status mismatch!", "pending", statusText); }
        catch (AssertionError e) {
            screenshotObject.takeScreenshot("status_Failure");
            throw e;
        }
    softAssert.assertAll();
    }
    public void AssertTypeIsb2cdelivery (WebDriver driver){
        Screenshot screenshotObject=new Screenshot(driver);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        SoftAssert softAssert = new SoftAssert();
        WebElement type = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='wrapper']/div[2]/div[3]/div[2]/div/div[1]/div[2]/div/div/div[4]/span[2]")));
        String typeText = type.getText();
        try{softAssert.assertEquals("Type mismatch!", "b2c delivery", typeText); }
        catch (AssertionError e) {
            screenshotObject.takeScreenshot("type_Failure");
            throw e;
        }
        softAssert.assertAll();
    }
}
