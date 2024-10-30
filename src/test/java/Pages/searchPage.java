package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import screens.Screenshot;

import java.time.Duration;

import static Hooks.hooks.driver;

public class searchPage {

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
        String actualText = result.getText();
        try {
            softAssert.assertEquals(actualText, "Client Reference: NAE235140",
                    "Text does not match! Expected: 'Client Reference: NAE235140' but got: " + actualText);
        }
        catch (AssertionError e) {
            screenshotObject.takeScreenshot("Search_Results_Failure");
            throw e;
        }
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
        try {
            softAssert.assertTrue(homeLogo.isDisplayed(), "Homepage logo is not visible.");
        } catch (AssertionError e) {
            screenshotObject.takeScreenshot("Homepage_logo_Failure");
            throw e;
        }
    }
}
