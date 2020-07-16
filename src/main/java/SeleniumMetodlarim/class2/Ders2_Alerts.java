package SeleniumMetodlarim.class2;

import SeleniumMetodlarim.Util.ElementUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ders2_Alerts {
    public static WebDriver driver;


    public static void main(String[] args) {

        String urlName = "http://demo.guru99.com/test/delete_customer.php";
        By by = By.xpath("//input[@name='cusid']");

        By submitButton = By.name("submit");
        String inpuData = "123455";


        driver = ElementUtil.browserLauncher(driver, "chrome");

        ElementUtil.findSurfPageName(driver, urlName);

        System.out.println(ElementUtil.pTitleOf(driver));

        ElementUtil.sendData(driver, by, inpuData);

        ElementUtil.clickerOn(driver, submitButton);

        String alertText = ElementUtil.gettingAlertText(driver);

        ElementUtil.slpBrowser(5000);

        ElementUtil.qBrowser(driver);

        System.out.println("Test Done");
    }
}
