package SeleniumMetodlarim.class17_SSLcertificates;

import SeleniumMetodlarim.Util.ElementUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;


public class ders1_SSLcertificates {
    public static void main(String[] args) {
        //setup browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = null;


        //accept insecure and SSL cert problem websites
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

        //Adding new properties for the new chrome browser
        ChromeOptions options = new ChromeOptions();
        options.merge(capabilities);

        //launching new browser with new properties
        driver = ElementUtil.browserLauncher(driver, "chrome");
        driver.get("https://www.seleniumhq.org/");


        System.out.println("##################### the title ##########################");
        System.out.println(driver.getTitle());


        //tearDown
        ElementUtil.slpBrowser(5000);
        ElementUtil.qBrowser(driver);
    }

}


