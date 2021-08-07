package tests;

import models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTestBase extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if (!app.userHelper().isLogined()) {
            app.userHelper().logout();
        }
    }

    @Test
    public void registrationPositive() {
        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm("kselon+35@gmail.com", "Qwerty$4");
        app.userHelper().submitReg();

        app.userHelper().logout();

    }
    @Test
    public void registrationPositiveDto(){
        User user = new User().withEmail("Kselon+36@gmail.com").withPassword("Qwerty$4");
        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm(user);
        app.userHelper().submitRegistration();
        app.userHelper().logout();
    }
}
