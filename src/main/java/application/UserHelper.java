package application;

import models.Users;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserHelper extends HelperBase {
    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm() {

        click(By.xpath("//a[.='LOGIN']"));
    }

    public void fillLoginForm(String email, String password) {

        type(By.xpath("//input[@placeholder='Email']"), email);

        type(By.xpath("//input[@placeholder='Password']"), password);
    }

    public void fillLoginForm(Users user) {

        type(By.xpath("//input[@placeholder='Email']"), user.getEmail());
        type(By.xpath("//input[@placeholder='Password']"), user.getPassword());
    }

    public void submitReg() {
        click(By.xpath("//button[.=' Registration']"));
    }

    public void submitLogin() {
        click(By.xpath("//button[.=' Login']"));
    }

    public boolean isLogined() {
        return (wd.findElements(By.xpath("//a[.='LOGIN']"))).size() > 0;
    }

    public void logout() {
        click(By.xpath("//button[.='Sign Out']"));
    }

    public void submitRegistration() {
        click(By.xpath("//button[.=' Registration']"));
    }

    public void acceptAlert() {
        new WebDriverWait(wd, 5).until(ExpectedConditions.alertIsPresent());
        wd.switchTo().alert().accept();
    }

    public boolean isLogged() {
        return wd.findElements(By.xpath("//button[text()='Sign out']")).size() > 0;
    }
}
