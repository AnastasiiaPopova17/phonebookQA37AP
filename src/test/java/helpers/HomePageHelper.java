
package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageHelper extends BaseHelper{

    public HomePageHelper(WebDriver driver) {
        super(driver);
    }

    By textTitleH1 = By.cssSelector("div:nth-child(2) h1");

    public void navigateToHomePage() {
        driver.navigate().to("https://telranedu.web.app/home");
    }

    public String getTextTitleHomePage() {
        return getTextBaseByLocator(textTitleH1);
    }
}
