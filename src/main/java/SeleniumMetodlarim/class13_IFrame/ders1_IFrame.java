package SeleniumMetodlarim.class13_IFrame;

import SeleniumMetodlarim.Util.ElementUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;

public class ders1_IFrame {
    public static void main(String[] args) {
        //setup browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = null;

        driver = ElementUtil.browserLauncher(driver, "chrome");

        driver.get("http://londonfreelance.org/courses/frames/index.html");

        System.out.println("##################### the title ##########################");
        System.out.println(driver.getTitle());


//        By locatingElement = By.xpath("//h2[contains(text(),'Title bar')]");
        By locatingElement = By.name("main");

        System.out.println("##################### After switched frame ##########################");
        //We should change the frame in order to get title from the page
        String titleOfPage = driver.switchTo().frame((driver.findElement(locatingElement))).getTitle();
        System.out.println(titleOfPage);

        By headElementLocators = By.xpath("//h2[contains(text(),'Title bar')]");
        WebElement headElement = driver.findElement(headElementLocators);
        String titleAfter = driver.getTitle();
        System.out.println(titleAfter);

        String textOfHead = headElement.getText();
        System.out.println(textOfHead);

        System.out.println("##################### After switched To Main Frame ##########################");
        String defaultContentTitle = driver.switchTo().defaultContent().getTitle();
        System.out.println(defaultContentTitle+" title of default content");
        //tearDown
        ElementUtil.slpBrowser(2000);
        ElementUtil.qBrowser(driver);
    }

}
