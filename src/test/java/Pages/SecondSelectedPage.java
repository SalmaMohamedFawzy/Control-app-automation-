package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import screens.Screenshot;

import java.time.Duration;

public class SecondSelectedPage {

    public void AssertClientReferencecIs_NAE584747(WebDriver driver,SoftAssert softAssert)
    {
        Screenshot screenshotObject=new Screenshot(driver);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement clientReference = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='wrapper']/div[2]/div[3]/div[2]/div/div[1]/div[1]/span")));
    String clientReferenceText = clientReference.getText();

        if (!"CLIENT REFERENCE: NAE035029".equalsIgnoreCase(clientReferenceText)) {
            screenshotObject.takeScreenshot("SecPg_Client_reference");
        }
        softAssert.assertEquals(clientReferenceText.toLowerCase(),  "CLIENT REFERENCE: NAE035029".toLowerCase() , "Client reference mismatch!");

    }
    public void AssertClientRequestIsCR04N01M10244980554 (WebDriver driver,SoftAssert softAssert){
        Screenshot screenshotObject=new Screenshot(driver);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement clientRequest = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='wrapper']/div[2]/div[3]/div[2]/div/div[1]/div[2]/div/div/div[2]/span[2]")));
        String clientRequestText = clientRequest.getText();

        if (!"CR04N01M11241741073".equals(clientRequestText)) {
            screenshotObject.takeScreenshot("secPg_ClientRequest");
        }
        softAssert.assertEquals(clientRequestText, "CR04N01M11241741073", "Client request mismatch!");
    }
    public void AssertStatusIsPending(WebDriver driver,SoftAssert softAssert)
    {
        Screenshot screenshotObject=new Screenshot(driver);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement status = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='wrapper']/div[2]/div[3]/div[2]/div/div[1]/div[2]/div/div/div[3]/span[2]")));
        String statusText = status.getText();

        if (!"pending".equalsIgnoreCase(statusText)) {
            screenshotObject.takeScreenshot("status_Failure");
        }
        softAssert.assertEquals(statusText.toLowerCase(),  "pending".toLowerCase(),"Status mismatch!" );
    }

    public void AssertTypeIsb2cdelivery (WebDriver driver,SoftAssert softAssert){
        Screenshot screenshotObject=new Screenshot(driver);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement type = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='wrapper']/div[2]/div[3]/div[2]/div/div[1]/div[2]/div/div/div[4]/span[2]")));
        String typeText = type.getText();

        if (!"b2c delivery".equalsIgnoreCase(typeText)) {
            screenshotObject.takeScreenshot("type_Failure");
        }
        softAssert.assertEquals( typeText.toLowerCase(), "b2c delivery".toLowerCase(),"Type mismatch!");
    }
}
