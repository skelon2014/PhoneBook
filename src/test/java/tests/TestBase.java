package tests;

import application.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase {
    protected static ApplicationManager app =
            new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod
    public void startLogger(Method m, Object[] p){
        logger.info("==================================");
        logger.info("Start on method - " + m.getName());
        logger.info("Start test with Data - " + Arrays.asList(p));
    }
    @AfterMethod
    public void endOfLogger(Method m){
        logger.info("End off method - " + m.getName());
    }


    @BeforeSuite(alwaysRun = true)
    public void start() {
        app.init();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
         app.stop();
    }
}


