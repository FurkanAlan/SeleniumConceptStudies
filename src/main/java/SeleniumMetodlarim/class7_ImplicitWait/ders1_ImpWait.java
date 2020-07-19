package SeleniumMetodlarim.class7_ImplicitWait;

import SeleniumMetodlarim.Util.ElementUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class ders1_ImpWait {
    public static void main(String[] args) {
        //setup browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = null;

        driver = ElementUtil.browserLauncher(driver, "chrome");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        //Implicit wait will w8 for all elements in the page with given time and unit
        //this can be used for to load up all the elements in the page
        //It works with web elements only
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");


        //tearDown
        ElementUtil.slpBrowser(5000);
        ElementUtil.qBrowser(driver);
    }
}

