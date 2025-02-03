package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import screens.Screenshot;

import java.time.Duration;

public class P05_SecondSearchPage {
    public void EnterSearchTermInTheBox(String searchText,WebDriver driver) {
        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[2]/div[3]/div[2]/div[1]/div[1]/form/input"));
        searchBox.clear();
        searchBox.sendKeys(searchText);
        searchBox.sendKeys(Keys.RETURN);
    }

    public void VerifyResults(String expectedResult,WebDriver driver, SoftAssert softAssert) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Screenshot screenshotObject = new Screenshot(driver);
        WebElement resultsArea = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"wrapper\"]/div[2]/div[3]/div[2]")));

        if ("Specific Item".equals(expectedResult)) {
            ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            WebElement specificItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"wrapper\"]/div[2]/div[3]/div[2]/div[2]/table/tbody/tr/td[1]")));
            if (!specificItem.isDisplayed()) {
                screenshotObject.takeScreenshot("SecSearchResultsNotDisplyed");
            }
            softAssert.assertTrue(specificItem.isDisplayed(),"Expected item not found for: " + specificItem.getText());

        } else if ("No data available".equals(expectedResult)) {

            wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, document.body.scrollHeight)");
            Thread.sleep(1000);
            WebElement noDataMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"wrapper\"]/div[2]/div[3]/div[2]/div[2]/div")));
            String noDataMessageText = noDataMessageElement.getText();
            if (!"Uh-oh! No Data Available".equals(noDataMessageText)) {
                screenshotObject.takeScreenshot("SecSearchResults_NOTFoundMsg_NotDisplyed");
            }
            softAssert.assertEquals(noDataMessageText,"Uh-oh! No Data Available","No message is displayed");
        }
    }

}
