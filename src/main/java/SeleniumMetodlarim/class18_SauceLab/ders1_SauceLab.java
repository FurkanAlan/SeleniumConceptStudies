package SeleniumMetodlarim.class18_SauceLab;

import SeleniumMetodlarim.Util.ElementUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class ders1_SauceLab {
    public static final String USERNAME = "alan";
    public static final String ACCESS_KEY = "1128529c-e624-5vge-b67h-78912fsec512";
    public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";

    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability("platform", "MacOS");
        capabilities.setCapability("version", "10.14.6");

        WebDriver driver = new RemoteWebDriver(new URL(URL), capabilities);

        driver.get("https://www.seleniumhq.org/");


        System.out.println("##################### the title ##########################");
        System.out.println(driver.getTitle());


        //tearDown
        ElementUtil.slpBrowser(5000);
        ElementUtil.qBrowser(driver);
    }

}


