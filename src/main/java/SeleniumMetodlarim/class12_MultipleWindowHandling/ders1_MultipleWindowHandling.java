package SeleniumMetodlarim.class12_MultipleWindowHandling;

import SeleniumMetodlarim.Util.ElementUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;

public class ders1_MultipleWindowHandling {
    public static void main(String[] args) {
        //setup browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = null;

        driver = ElementUtil.browserLauncher(driver, "chrome");

        driver.get("http://popuptest.com/goodpopups.html");


        By locatingElement = By.xpath("//a[contains(text(),'Good PopUp #1')]");

        //1.way
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement elementForTesting = wait.until(ExpectedConditions.presenceOfElementLocated(locatingElement));

        //click action, new popup will emerge
        elementForTesting.click();


        System.out.println("##################### the title ##########################");
        System.out.println(driver.getTitle());

        Set<String> gettingHandlesIDs = driver.getWindowHandles();
        //[CDwindow-84D635D1426A6F3C11D61B67D1D0929D, CDwindow-2045238A205120A7134AF2C1D34B8D75]
        //we have two different ID for each handlers
        System.out.println(gettingHandlesIDs);

        Iterator<String> iterableForPopUps = gettingHandlesIDs.iterator();

        String idOfParent = iterableForPopUps.next();
        System.out.println(idOfParent);

        String idOfChild = iterableForPopUps.next();
        System.out.println(idOfChild);

        //Getting Title of Child
        String titleOfChild = driver.switchTo().window(idOfChild).getTitle();
        System.out.println(titleOfChild);
        ElementUtil.slpBrowser(2000);
        driver.close();

        //Getting Title of Parent
        String titleOfParent = driver.switchTo().window(idOfParent).getTitle();
        ElementUtil.slpBrowser(2000);
        System.out.println(titleOfParent);
        driver.close();


        //tearDown
        ElementUtil.slpBrowser(2000);
        ElementUtil.qBrowser(driver);
    }
}
