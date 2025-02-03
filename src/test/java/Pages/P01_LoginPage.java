package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P01_LoginPage {
    public void LoginWithSalmaCredentails(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));

        // Locate the Google login button by its XPath and click it
        WebElement googleLoginButton = driver.findElement(By.xpath("//*[@id='q-app']/div/div/main/div/div/div[3]/div[1]/a/span[2]/span"));
        googleLoginButton.click();

        WebElement pageLoadElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='yDmH0d']/c-wiz/div/div[2]")));

        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='identifierId']")));
        emailField.sendKeys("snagy@noon.com");

        WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='identifierNext']/div/button/span")));
        nextButton.click();

        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")));
        passwordField.sendKeys("Noon@Yellow2033");

        WebElement nextButtonn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"passwordNext\"]/div/button/span")));
        nextButtonn.click();

        WebElement twoStepVerificationHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='headingText']/span")));

        WebElement mainPageSearchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='wrapper']/div[2]/div[3]/div[2]/div[1]/div[1]/form/input")));

        By elementLocator = By.xpath("//*[@id='wrapper']/div[2]/div[3]/div[2]/div[1]");
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));

    }
}
