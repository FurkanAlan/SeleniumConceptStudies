package SeleniumMetodlarim.class15_Cookies;

import SeleniumMetodlarim.Util.ElementUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

public class ders1_kurabiye {

    public static void main(String[] args) {
        //setup browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = null;

        driver = ElementUtil.browserLauncher(driver, "chrome");

        driver.get("http://www.w3schools.com");
        Set<Cookie> cookies = driver.manage().getCookies();
        int totalCookieCount = cookies.size();
        System.out.println(totalCookieCount);
        System.out.println(cookies);

        System.out.println("##################### after removing all cookie ##########################");
        //To remove all cookies
        driver.manage().deleteAllCookies();
        System.out.println("After removing all cookie: "+cookies+ " the total: " +cookies.size());

        System.out.println("##################### the title ##########################");
        System.out.println(driver.getTitle());


        //tearDown
        ElementUtil.slpBrowser(2000);
        ElementUtil.qBrowser(driver);
    }
}

