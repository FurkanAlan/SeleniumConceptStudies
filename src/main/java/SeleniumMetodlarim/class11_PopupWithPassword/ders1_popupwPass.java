package SeleniumMetodlarim.class11_PopupWithPassword;

import SeleniumMetodlarim.Util.ElementUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ders1_popupwPass {
    public static void main(String[] args) {
        //setup browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = null;

        driver = ElementUtil.browserLauncher(driver, "chrome");


        //there are different ways to handle pop-up authorization
        //1. way
        // https://admin:admin@the-internet.herokuapp.com/basic_auth
        //directly enter username and password to the link
        //2.way
        //write down username and password as string and pass them to the link
        //String uName = "admin";
        //String pWord = "admin";
        // "https://"+uName+":"+pWord+"@the-internet.herokuapp.com/basic_auth"

//        By locatingElement = By.xpath("//input[@name='note']");

        //1.way
//        WebElement elementForTesting = wait.until(ExpectedConditions.presenceOfElementLocated(locatingElement));

        String uName = "admin";
        String pWord = "admin";
        driver.get("https://"+uName+":"+pWord+"@the-internet.herokuapp.com/basic_auth");
        System.out.println("##################### the title ##########################");
        System.out.println(driver.getTitle());
        //2.way
//        ElementUtil.getElementWithExpWaitApplied(driver,locatingElement,5)

        //tearDown
        ElementUtil.slpBrowser(2000);
        ElementUtil.qBrowser(driver);
    }
}
