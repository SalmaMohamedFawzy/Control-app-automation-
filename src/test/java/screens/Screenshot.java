package screens;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Screenshot {
    private WebDriver driver;

     // Constructor to initialize WebDriver and clean the screenshots folder
    public Screenshot(WebDriver driver) {
        this.driver = driver;
        //clearScreenshotFolder();
    }
    public void takeScreenshot(String testName) {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        try {
            // Ensure the screenshots directory exists
            File screenshotDir = new File("src/screens/");
            if (!screenshotDir.exists()) {
                screenshotDir.mkdirs();
            }

            File destinationFile = new File(screenshotDir, testName + ".png");
            Files.copy(srcFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Screenshot saved at: " + destinationFile.getAbsolutePath());

        } catch (IOException e) {
            System.err.println("Failed to save screenshot: " + e.getMessage());
        } catch (WebDriverException e) {
            System.err.println("WebDriver exception while taking screenshot: " + e.getMessage());
        }
    }
}
