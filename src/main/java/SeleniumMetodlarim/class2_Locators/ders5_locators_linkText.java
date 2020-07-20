package SeleniumMetodlarim.class2_Locators;

import SeleniumMetodlarim.Util.ElementUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ders5_locators_linkText {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://app.hubspot.com/login");
        ElementUtil.slpBrowser(5000);

        //can get the text given for link, by doing that we can get locator
        By frPassword = By.linkText("Forgot my password");
        By pName = By.linkText("");
        By clcName = By.linkText("");
//        ElementUtil.getYourElement(driver,uName).sendKeys("aaaaaa@gmail.com");
//        ElementUtil.getYourElement(driver,pName).sendKeys("deneme$123");
//        ElementUtil.getYourElement(driver,clcName).click();


        ElementUtil.slpBrowser(2000);
        ElementUtil.qBrowser(driver);

    }
}
