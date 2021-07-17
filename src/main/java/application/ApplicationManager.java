package application;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    UserHelper userHelper;


    public void init() {
        wd = new ChromeDriver();
        userHelper = new UserHelper(wd);
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home).");

    }
    public void stop(){
        wd.quit();
    }
    public UserHelper userHelper(){
        return userHelper;
    }
}
