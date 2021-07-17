import models.Users;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

    public class LoginTest extends BaseTest {
    @BeforeMethod
    public void preCondition() {
        if (!app.userHelper().isLogined()) {
            app.userHelper().logout();
        }
    }
    @Test
    public void loginPositive() throws InterruptedException {
        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm("skelon+4@bk.ru","Qwerty$4");
        app.userHelper().submitLogin();
        Thread.sleep(2000);
        app.userHelper().logout();
    }
    @Test
        public void loginPositiveDto() throws InterruptedException {
        Users user = new Users().withEmail("skelon+4@bk.ru").withPassword("Qwerty$4");
        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm(user);
        app.userHelper().submitLogin();
        Thread.sleep(3000);
        app.userHelper().logout();
    }
}