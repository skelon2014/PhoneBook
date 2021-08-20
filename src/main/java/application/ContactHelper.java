package application;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ContactHelper extends HelperBase {
    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void openFormContact() {
        click(By.xpath("//a[.='ADD']"));
    }

    public void saveContact() {
          pause(1000);
       JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("document.querySelector('button b').click();");
        //  click(By.xpath("//button/b"));
    }

    public void fillFormContact(Contact contact) {
        int i = (int) ((System.currentTimeMillis()) / 100) % 360;
        type(By.cssSelector("input[placeholder='Name']"), contact.getName() + i);
        type(By.cssSelector("input[placeholder='Last Name']"), contact.getLastName());
        type(By.cssSelector("input[placeholder='Phone']"), contact.getPhone());
        type(By.cssSelector("input[placeholder='email']"), contact.getEmail());
        type(By.cssSelector("input[placeholder='Address']"), contact.getAddress());
        type(By.cssSelector("input[placeholder='description']"), contact.getDescription());
    }

    public boolean isContactAdded(String phone) {
        List<WebElement> contacts = wd.findElements(By.xpath("//h3"));
        for (WebElement el : contacts) {
            if (el.getText().equals(phone)) {
                System.out.println("============" + el.getText() + "===============");
                return true;
            }
        }
        return false;
    }

    public void removeOneContact() {
        WebElement contact = wd.findElement(By.cssSelector(".contact-item_card__2SOIM"));
        contact.click();
        click(By.xpath("//button[.='Remove']"));
        System.out.println(contact.getText());
    }

    public void removeAllContacts() {
       // List<WebElement> contacts = wd.findElements(By.cssSelector(".contact-item_card__2SOIM"));
    /*  for(WebElement el:contacts) {
          el.click();
          click(By.xpath("//button[.='Remove']"));
          System.out.println(el.getText());
          pause(2000);
      }*/

        while (wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size() > 0) {
            removeOneContact();
            pause(500);
            System.out.println();
        }
    }

    public boolean isContactPresent() {
        return wd.findElement(By.xpath("//h1[normalize-space()='No Contacts here!']")).isDisplayed();
    }
}
