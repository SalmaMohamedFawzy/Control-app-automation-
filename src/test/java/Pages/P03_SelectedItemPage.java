package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import screens.Screenshot;

import java.time.Duration;
import java.util.List;

public class P03_SelectedItemPage {

    public void AssertAttempts(WebDriver driver,SoftAssert softAssert)
    {
        Screenshot screenshotObject=new Screenshot(driver);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement attemptsElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='wrapper']/div[2]/div[3]/div[2]/div/div[2]/div[2]/div[1]/div/div[2]/span[2]")));
        String attemptsText = attemptsElement.getText();
        if (!"0/3".equals(attemptsText)) {
            screenshotObject.takeScreenshot("attempts_Failure");
        }
        softAssert.assertEquals(attemptsText, "0/3", "Attempts text does not match! Expected: '0/3' but got: " + attemptsText);
    }
    public void ScrollDown(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[@id='wrapper']/div[2]/div[3]/div[2]/div/div[2]/div[2]/div[3]/div[2]/table/thead/tr/th[1]")));
    }
    public void AssertPackages(WebDriver driver,SoftAssert softAssert)
    { Screenshot screenshotObject=new Screenshot(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='wrapper']/div[2]/div[3]/div[2]/div/div[2]/div[2]/div[3]/div[2]/table/tbody/tr")));
        List<WebElement> packageRows = driver.findElements(By.xpath("//*[@id='wrapper']/div[2]/div[3]/div[2]/div/div[2]/div[2]/div[3]/div[2]/table/tbody/tr"));
        int packageCount = packageRows.size();
        if (!(packageCount > 0)) {
            screenshotObject.takeScreenshot("Packages_Empty");
        }
        System.out.println("Total number of packages in the column: " + packageCount);
        softAssert.assertTrue(packageCount > 0, "No packages found in the column.");
        //////////go to package and download report///////
        WebElement airwayNumberElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='wrapper']/div[2]/div[3]/div[2]/div/div[2]/div[2]/div[3]/div[2]/table/tbody/tr[1]/td[3]")));
        airwayNumberElement.click();
        ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
      /*  WebElement downloadButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='wrapper']/div[2]/div[3]/div[2]/div/div[2]/div/button")));
        downloadButton.click();*/
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
