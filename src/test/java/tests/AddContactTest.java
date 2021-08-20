package tests;

import application.MyDataProvider;
import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTest extends TestBase {
    @BeforeMethod
    public void preCondition() {
        if (app.userHelper().isNoLogged()) {
            app.userHelper().login(new User().withEmail("kselon+25@bk.ru").withPassword("Qwerty$4"));
        }
    }

    @Test(invocationCount = 3)
    public void addContactTestBase() {
        int i = (int)((System.currentTimeMillis())/1000)%360;
        Contact contact = Contact.builder()
                .name("Masha")
                .lastName("Add")
                .email("qwerty+" + i + "@bk.ru")
                .phone("12345678")
                .address("Telavi, Rustaveli, 5, 12")
                .description("friend-"+i)
                .build();

        app.contact().openFormContact();
        app.contact().fillFormContact(contact);
        app.contact().saveContact();
        Assert.assertTrue(app.contact().isContactAdded(contact.getPhone()));
    }


    @Test(dataProvider = "dataContactCSV",dataProviderClass = MyDataProvider.class)
    public void addContactTestCSV(Contact contact) {
        int i = (int)((System.currentTimeMillis())/1000)%360;

        app.contact().openFormContact();
        app.contact().fillFormContact(contact);
        app.contact().saveContact();
           Assert.assertTrue(app.contact().isContactAdded(contact.getPhone()));
    }

    @Test(dataProvider = "DataContactDP",dataProviderClass = MyDataProvider.class)
    public void addContactTestDataProvider(String name, String lastName, String phone, String email, String address, String description) {

        Contact contact = Contact.builder()
                .name(name)
                .lastName(lastName)
                .email(email)
                .phone(phone)
                .address(address)
                .description(description)
                .build();

        app.contact().openFormContact();
        app.contact().fillFormContact(contact);
        app.contact().saveContact();
           Assert.assertTrue(app.contact().isContactAdded(contact.getPhone()));
    }
}
