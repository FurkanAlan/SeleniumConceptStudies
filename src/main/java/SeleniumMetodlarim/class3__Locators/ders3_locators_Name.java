package SeleniumMetodlarim.class3__Locators;

import SeleniumMetodlarim.Util.ElementUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ders3_locators_Name {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://app.hubspot.com/login");
        ElementUtil.slpBrowser(5000);

        By uName = By.name("username");
        By pName = By.name("password");
        By clcName = By.name("loginBtn");
        ElementUtil.getYourElement(driver,uName).sendKeys("aaaaaa@gmail.com");
        ElementUtil.getYourElement(driver,pName).sendKeys("deneme$123");
        ElementUtil.getYourElement(driver,clcName).click();


        ElementUtil.slpBrowser(2000);
        ElementUtil.qBrowser(driver);

    }
}
