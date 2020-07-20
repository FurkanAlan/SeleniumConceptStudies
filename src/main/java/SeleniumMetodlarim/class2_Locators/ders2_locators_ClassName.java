package SeleniumMetodlarim.class2_Locators;

import SeleniumMetodlarim.Util.ElementUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ders2_locators_ClassName {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://app.hubspot.com/login");
        ElementUtil.slpBrowser(5000);

        //we can use partial name as well such as login-password but not safe
        //form-control private-form__control login-email
        By uName = By.className("login-email");
//        form-control private-form__control login-password m-bottom-3
        By pName = By.className("login-password");
//        uiButton private-button private-button--primary private-button--default m-bottom-4 login-submit disabled private-button--disabled private-button--non-link
        By clcElement = By.className("login-submit");

        driver.findElement(uName).sendKeys("aaaaaa@gmail.com");
        driver.findElement(pName).sendKeys("deneme$123");
        driver.findElement(clcElement).click();

        ElementUtil.slpBrowser(2000);
        ElementUtil.qBrowser(driver);
    }
}
