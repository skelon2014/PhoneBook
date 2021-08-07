package tests;

import models.Users;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.BaseTest;

public class LoginTest extends BaseTest {
    @BeforeMethod
    public void preCondition() {
        if (app.userHelper().isLogged()) {
            app.userHelper().logout();
        }
    }
   @Test(groups = {"rest"})
    public void loginPositive()  {
        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm("skelon+4@bk.ru","Qwerty$4");
        app.userHelper().submitLogin();
    //    Thread.sleep(2000);
        String message = app.userHelper().getText(By.xpath("//a[.='ADD']"));
        Assert.assertEquals(message,"ADD");
        app.userHelper().logout();
    }
    @Test
        public void loginPositiveDto()  {
        Users user = new Users().withEmail("skelon+4@bk.ru").withPassword("Qwerty$4");
        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm(user);
        app.userHelper().submitLogin();

        app.userHelper().logout();
    }
    @Test
        public void loginNegativeTestWithWrongPassword(){
        Users user = new Users().withEmail("kselon+1@bk.ru").withPassword("Qwerty5");
        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm(user);
        app.userHelper().submitLogin();
     //   app.userHelper().pause(3000);
        app.userHelper().acceptAlert();
        Assert.assertFalse(app.userHelper().isLogged());

    }

}