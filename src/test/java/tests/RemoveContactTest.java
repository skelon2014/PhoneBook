package tests;

import models.Contact;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTest extends TestBase{
    @BeforeMethod
    public void preCondition() {
        if (app.userHelper().isNoLogged()) {
            app.userHelper().login(new User().withEmail("kselon+25@bk.ru").withPassword("Qwerty$4"));
        }
    }
@Test
    public void remove1OneContact(){

     //   app.userHelper().click(By.cssSelector("a[href='/contacts']"));
        app.contact().removeOneContact();

   // Assert.assertTrue();

}
@Test
    public void removeAllContacts(){
        app.contact().removeAllContacts();

}
}
