import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void loginTestPositive() {
        click(By.xpath("//a[.='LOGIN']"));
        click(By.xpath("//input[@placeholder='Email']"));
        type(By.xpath("//input[@placeholder='Email']"), "kselon+1@gmail.com");
        click(By.xpath("//input[@placeholder='Password']"));
        type(By.xpath("//input[@placeholder='Password']"), "Qwerty$4");
        click(By.xpath("//button[.=' Login']"));
        pause(3000);
        String message = wd.findElement(By.xpath("//h1[.=' No Contacts here!']")).getText();
        Assert.assertEquals(message, "No Contacts here!");
        //add contact
        click(By.cssSelector("a[href='/add']"));
        click(By.cssSelector("input[placeholder='Name']"));
        type(By.cssSelector("input[placeholder='Name']"),"Chip");
        click(By.cssSelector("input[placeholder='Last Name']"));
        type(By.cssSelector("input[placeholder='Last Name']"),"Deil");
        click(By.cssSelector("input[placeholder='Phone']"));
        type(By.cssSelector("input[placeholder='Phone']"),"123456789");
        click(By.cssSelector("input[placeholder='email']"));
        type(By.cssSelector("input[placeholder='email']"),"Chip&Deil@gmail.com");
        click(By.xpath("//input[@placeholder='Address']"));
        type(By.xpath("//input[@placeholder='Address']"),"Lenina 1");
        click(By.xpath("//input[@placeholder='description']"));
        type(By.xpath("//input[@placeholder='description']"),"friend");
        click(By.xpath("//button[.='Sign Out']"));

    }
}
