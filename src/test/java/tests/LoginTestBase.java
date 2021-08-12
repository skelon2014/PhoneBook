package tests;

import application.MyDataProvider;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoginTestBase extends TestBase {
    @BeforeMethod
    public void preCondition() {
        if (!app.userHelper().isNoLogged()) {
            app.userHelper().logout();
        }
    }

    @Test(groups = {"rest"})
    public void loginPositive() {
        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm("skelon+4@bk.ru", "Qwerty$4");
        app.userHelper().submitLogin();
        //    Thread.sleep(2000);
        String message = app.userHelper().getText(By.xpath("//a[.='ADD']"));
        Assert.assertEquals(message, "ADD");
        app.userHelper().logout();
    }

    @Test
    public void loginPositiveDto() {
        User user = new User().withEmail("skelon+4@bk.ru").withPassword("Qwerty$4");
        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm(user);
        app.userHelper().submitLogin();

        app.userHelper().logout();
    }

    @Test
    public void loginNegativeTestWithWrongPassword() {
        User user = new User().withEmail("kselon+1@bk.ru").withPassword("Qwerty5");
        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm(user);
        app.userHelper().submitLogin();
        //   app.userHelper().pause(3000);
        app.userHelper().acceptAlert();
        Assert.assertTrue(app.userHelper().isNoLogged());

    }

    @Test
    public void loginTestBase() {
        User user = new User()
                .withEmail("skelon+4@bk.ru")
                .withPassword("Qwerty$4");
        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm(user);
        app.userHelper().clickLoginButton();

        Assert.assertTrue(app.userHelper().isNoLogged());
    }

    //======================================================Data in class
    @DataProvider
    public Iterator<Object[]> validDataLogin() {
        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{"skelon+4@bk.ru","Qwerty$4"});
        list.add(new Object[]{"skelon+11@bk.ru","Qwerty$4"});
        list.add(new Object[]{"skelon+10@bk.ru","Qwerty$4"});

        return list.iterator();
    }

    @Test(dataProvider = "validDataLogin")
    public void loginTestDataProvider(String email, String password) {
        User user = new User()
                .withEmail(email)
                .withPassword(password);
        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm(user);
        app.userHelper().clickLoginButton();
        Assert.assertTrue(app.userHelper().isNoLogged());
        app.userHelper().logout();

    }
//=======================================================================with MyDataProvider

    @Test(dataProvider = "validLoginDataClassDP",dataProviderClass = MyDataProvider.class)
    public void loginTestDataProviderClass(String email, String password) {
        User user = new User()
                .withEmail(email)
                .withPassword(password);
        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm(user);
        app.userHelper().clickLoginButton();
        Assert.assertTrue(app.userHelper().isNoLogged());
        app.userHelper().logout();
        app.userHelper().pause(1000);
    }

    //=================================================with data csv
    @Test(dataProvider = "dataFileCSV",dataProviderClass = MyDataProvider.class)
    public void loginTestDP_CSV(User user) {
        app.userHelper().pause(1000);
        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm(user);
        app.userHelper().clickLoginButton();
        app.userHelper().logout();
        Assert.assertTrue(app.userHelper().isNoLogged());
    }

}