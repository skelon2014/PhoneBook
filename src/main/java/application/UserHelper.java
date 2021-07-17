package application;

import models.Users;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends HelperBase {
    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm()  {
        click(By.xpath("//a[.='LOGIN']"));
    }
    public void fillLoginForm(String email,String password){

        type(By.xpath("//input[@placeholder='Email']"), email);

        type(By.xpath("//input[@placeholder='Password']"), password);
    }
    public void fillLoginForm(Users user){

        type(By.xpath("//input[@placeholder='Email']"), user.getEmail());
        type(By.xpath("//input[@placeholder='Password']"), user.getPassword());
    }
    public void submitReg(){
        click(By.xpath("//button[.=' Registration']"));
    }

    public void submitLogin(){
        click(By.xpath("//button[.=' Login']"));
    }

    public boolean isLogined() {
        return (wd.findElements(By.xpath("//a[.='LOGIN']"))).size()>0;
    }

    public void logout() {
        click(By.xpath("//button[.='Sign Out']"));
    }
}
