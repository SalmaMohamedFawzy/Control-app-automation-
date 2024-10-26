package Hooks;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class hooks  {
    public static WebDriver driver;
    @Before
    public void setUp() {
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            System.out.println("Driver initialized in Hooks: " + driver);
        }
    }

    @AfterAll
    public static void tearDown(){
        if (driver != null) {
            driver.quit();
            System.out.println("Driver quit in hooks: " + driver);
            driver = null; // Reset driver to null after quitting
        }
    }

}
