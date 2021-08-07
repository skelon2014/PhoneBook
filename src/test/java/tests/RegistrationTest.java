package tests;

import models.Users;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.BaseTest;

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
        app.userHelper().fillLoginForm("kselon+35@gmail.com", "Qwerty$4");
        app.userHelper().submitReg();
        app.userHelper().logout();

    }
    @Test
    public void registrationPositiveDto(){
        Users user = new Users().withEmail("Kselon+36@gmail.com").withPassword("Qwerty$4");
        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm(user);
        app.userHelper().submitRegistration();
        app.userHelper().logout();
    }
}
