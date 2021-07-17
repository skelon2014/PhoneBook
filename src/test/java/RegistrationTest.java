import models.Users;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {

    @BeforeMethod
    public void preCondition() {
        if (!app.userHelper().isLogined()) {
            app.userHelper().logout();
        }
    }

    @Test
    public void registrationPositive() {
        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm("kselon@gmail.com", "Qwerty$4");
        app.userHelper().submitReg();

    }
    @Test
    public void registrationPositiveDto(){
        Users user = new Users().withEmail("Kselon+1@gmail.com").withPassword("Qwerty$4");
        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm(user);
        app.userHelper().submitLogin();
        app.userHelper().logout();
    }
}
