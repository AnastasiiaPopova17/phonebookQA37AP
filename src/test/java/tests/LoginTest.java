
package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class LoginTest extends tests.BaseTest {

    boolean flag = false;

    @AfterMethod
    public void methodPostCondition() {
        if (flag) {
            app.getUserHelper().clickLogoutBtn();
            flag = false;
        } else {
            app.getUserHelper().clickOkAlert();
        }
        app.getHomePageHelper().navigateToHomePage();
    }

    @Test
    public void positiveLoginTest() {
        app.getUserHelper().clickLoginOnNavBar();
        app.getUserHelper().login(user);
        String actualRes = app.getUserHelper().getSignOutBtnText();
        System.out.println(actualRes);

//        Assert.assertEquals(
//                driver.findElement(
//                        By.xpath("//div[contains(@class,'navbar-logged')]//button"))
//                        .getText().trim(),
//                "Sign Out");

        Assert.assertEquals(actualRes, "Sign Out");
        flag = true;
    }

    @Test
    public void positiveLoginTest1() {
        app.getUserHelper().clickLoginOnNavBar();
        app.getUserHelper().login(user);
        String actualRes = app.getUserHelper().getSignOutBtnText();
        System.out.println(actualRes);
        Assert.assertEquals(actualRes, "Sign Out");
        flag = true;
    }

    @Test
    public void loginNegativeWithoutEmail() {
        app.getUserHelper().clickLoginOnNavBar();
        app.getUserHelper().fillPasswordOnLogin(user.getPassword());
        app.getUserHelper().clickLoginBtn();
        app.getUserHelper().pause(2000);
        Assert.assertEquals(app.getUserHelper().getTextAlert(),
                "Wrong email or password");
        // Wrong email or password
    }

    @Test
    public void loginNegativeWithoutPassword() {
        app.getUserHelper().clickLoginOnNavBar();
        app.getUserHelper().fillEmailOnLogin(user.getEmail());
        app.getUserHelper().clickLoginBtn();
        app.getUserHelper().pause(2000);
        Assert.assertEquals(app.getUserHelper().getTextAlert(),
                "Wrong email or password");
        // Wrong email or password

    }
}
