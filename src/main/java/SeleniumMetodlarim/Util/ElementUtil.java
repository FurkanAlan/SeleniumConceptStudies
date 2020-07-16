package SeleniumMetodlarim.Util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
    //several common method storages
//    public static WebDriver driver;

    /**
     * FurkanAlan
     */


    /**
     * @param driver
     * @param bName
     * @return
     */
    //Browser Launcher
    public static WebDriver browserLauncher(WebDriver driver, String bName) {
        if (bName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            System.out.println("you chose chrome browser");
        } else if (bName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            System.out.println("you chose firefox browser");
        } else {
            System.out.println("Error, check it: " + bName);
        }
        return driver;
    }

    /**
     * @param driver
     * @param urlName
     */
    //url launcher
    public static void findSurfPageName(WebDriver driver, String urlName) {
        driver.get(urlName);
    }

    /**
     * @param driver
     * @return
     */
    public static String pTitleOf(WebDriver driver) {
        return driver.getTitle();
    }

    /**
     * @param driver
     * @param locatingElement
     * @param someThing
     */
    public static void sendData(WebDriver driver, By locatingElement, String someThing) {
        driver.findElement(locatingElement).sendKeys(someThing);
    }


    /**
     * @param driver
     * @param locatingElement
     */
    public static void waitForElementsAvailability(WebDriver driver, By locatingElement) {
        WebDriverWait webWait = new WebDriverWait(driver, 13);
        webWait.until(ExpectedConditions.presenceOfElementLocated(locatingElement));
    }

    /**
     * get your element
     *
     * @param driver
     * @param locatingElement
     * @return
     */

    public static WebElement getYourElement(WebDriver driver, By locatingElement) {
        waitForElementsAvailability(driver, locatingElement);
        return driver.findElement(locatingElement);
    }


    /**
     * @param driver
     * @param locatingElement
     */
    public static void clickerOn(WebDriver driver, By locatingElement) {
        driver.findElement(locatingElement).click();
    }

    /**
     * @param driver
     */
    public static void qBrowser(WebDriver driver) {
        driver.quit();
    }

    /**
     * @param driver
     */
    public static void cBrowser(WebDriver driver) {
        driver.close();
    }


    /**
     * @param driver
     * @return
     */
    public static String gettingAlertText(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println(alertText);
        alert.dismiss();
        return alertText;

    }

    public static void slpBrowser(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
