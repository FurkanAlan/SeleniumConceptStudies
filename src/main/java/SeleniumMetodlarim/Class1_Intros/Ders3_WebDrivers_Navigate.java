package SeleniumMetodlarim.Class1_Intros;

import SeleniumMetodlarim.Util.ElementUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ders3_WebDrivers_Navigate extends ElementUtil{
    public static void main(String[] args) {

        //// back - forward - refresh only for navigate method, but not for get method

//        ElementUtil eUtil = new ElementUtil();


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //difference between get and navigate is get will w8 for page to load fully yet navigate wont
//        driver.get("http://www.facebook.com");
        driver.navigate().to("http://www.facebook.com");
        driver.navigate().to("http://www.google.com");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();


        slpBrowser(2000);
        qBrowser(driver);
        System.out.println("Test Done");
    }
}
