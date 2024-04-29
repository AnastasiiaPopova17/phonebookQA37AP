
package helpers;

import dto.UserDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserHelper extends BaseHelper{
    public UserHelper(WebDriver driver) {
        super(driver);
    }

    By btnSignOut = By.xpath("//div[contains(@class,'navbar-logged')]//button");
    By btnLogout = By.xpath("//div[contains(@class,'navbar-logged')]//button");

    public String getSignOutBtnText() {
        return getTextBaseByLocator(btnSignOut);
    }
    public void clickLogoutBtn() {
        clickBase(btnLogout);
    }
    public void clickLoginOnNavBar() {
        driver.findElement(By.xpath("//a[@href='/login']")).click();
    }


    public void clickLoginBtn() {
        driver.findElement(By.xpath("//button[@name='login']")).click();
    }


    public void login(UserDTO user) {
        fillEmailOnLogin(user.getEmail());
        // fill password by: //input[@name='password'] "123456Aa$"
        fillPasswordOnLogin(user.getPassword());
        // click login btn by: //button[@name='login']
        clickLoginBtn();
    }

    public void fillPasswordOnLogin(String password) {
        WebElement inputPassword = driver.findElement(By
                .xpath("//input[@name='password']"));
        inputPassword.click();
        inputPassword.clear();
        inputPassword.sendKeys(password);
    }

    public void fillEmailOnLogin(String email) {
        WebElement inputEmail = driver.findElement(By
                .xpath("//input[@name='email']"));
        inputEmail.click();
        inputEmail.clear();
        inputEmail.sendKeys(email);
    }




}
