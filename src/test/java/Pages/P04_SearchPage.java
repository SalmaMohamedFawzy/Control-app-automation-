package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import screens.Screenshot;

import java.time.Duration;


public class P04_SearchPage {

    public void EnterSearchTerm(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#wrapper > div.jsx-1086676435.headerCtr > div.jsx-1086676435.logoSearchWrapper > div > form > input")));
        searchBox.sendKeys("CR04N01M10242441623\n");
    }
    public void ClickOnTheSearchIcon(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#wrapper > div.jsx-1086676435.headerCtr > div.jsx-1086676435.logoSearchWrapper > div > form > button")));
        searchButton.click();
    }
   public void SearchResults(WebDriver driver, SoftAssert softAssert) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Screenshot screenshotObject = new Screenshot(driver);
        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='wrapper']/div[2]/div[3]/div[2]/div/div[1]/div[1]/span")));

       WebElement clientRequestDetailsElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='wrapper']/div[2]/div[3]/div[1]/div")));
       String expectedText = "Client Request Details";
       String actualText = clientRequestDetailsElement.getText();
       softAssert.assertTrue(actualText.contains(expectedText), "The text 'Client Request Details' was not found! Expected text: " + expectedText + ", but got: " + actualText);
    }

    public void returnToHomeAgain(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement homeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='wrapper']/div[1]/div[2]/a/img")));
        homeButton.click();
    }

    public void SeeHomeLogoAgain(WebDriver driver, SoftAssert softAssert) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Screenshot screenshotObject = new Screenshot(driver);
        WebElement homeLogo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#wrapper > div.jsx-1086676435.headerCtr > div.jsx-1086676435.logoSearchWrapper")));

        if (!homeLogo.isDisplayed()) {
            screenshotObject.takeScreenshot("Homepage_logo_Failure");
        }
            softAssert.assertTrue(homeLogo.isDisplayed(), "Homepage logo is not visible.");
    }
}
