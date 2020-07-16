package SeleniumMetodlarim.Class1;

import SeleniumMetodlarim.Util.ElementUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.jsoup.nodes.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ders3_WebDrivers_Navigate {
    public static void main(String[] args) {

        ElementUtil eUtil = new ElementUtil();


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //difference between get and navigate is get will w8 for page to load fully yet navigate wont
//        driver.get("http://www.facebook.com");
        driver.navigate().to("http://www.facebook.com");
        driver.navigate().to("http://www.google.com");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();


        eUtil.slpBrowser(2000);
        eUtil.qBrowser(driver);
        System.out.println("Test Done");
    }
}
