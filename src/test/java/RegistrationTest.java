import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest{
    @Test
    public void registrationPositive() {
        click(By.xpath("//a[.='LOGIN']"));
        click(By.xpath("//input[@placeholder='Email']"));
        type(By.xpath("//input[@placeholder='Email']"), "kselon+4@gmail.com");
        click(By.xpath("//input[@placeholder='Password']"));
        type(By.xpath("//input[@placeholder='Password']"), "Qwerty$4");
        click(By.xpath("//button[.=' Registration']"));
        pause(10000);
        String message = wd.findElement(By.xpath("//h1[.=' No Contacts here!']")).getText();
        Assert.assertEquals(message, "No Contacts here!");
        click(By.xpath("//button[.='Sign Out']"));
    }
}
