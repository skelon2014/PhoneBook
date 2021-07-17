import application.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected static ApplicationManager app = new ApplicationManager();

    @BeforeClass
    public void start() {
        app.init();
    }

    @AfterClass
    public void tearDown() {
        // app.stop();
    }
}


