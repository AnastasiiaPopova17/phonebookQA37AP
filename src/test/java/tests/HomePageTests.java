
package tests;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends tests.BaseTest {

    @Test
    public void homePageOpened() {
        String actualRes = app.getHomePageHelper().getTextTitleHomePage();
        System.out.println(actualRes); // sout
        Assert.assertEquals(actualRes, "Home Component");
    }

}
