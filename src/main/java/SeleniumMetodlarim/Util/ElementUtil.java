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
    public WebDriver browserLauncher(WebDriver driver, String bName) {
        if (bName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            System.out.println("chrome working");
        } else if (bName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            System.out.println("firefox working");
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
    public void findSurfPageName(WebDriver driver, String urlName) {
        driver.get(urlName);
    }

    /**
     * @param driver
     * @param locatingElement
     */
    public void waitForElementsAvailability(WebDriver driver, By locatingElement) {
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

    public WebElement getYourElement(WebDriver driver, By locatingElement) {
        waitForElementsAvailability(driver, locatingElement);
        return driver.findElement(locatingElement);
    }


    /**
     * @param driver
     * @param locatingElement
     */
    public void clickerOn(WebDriver driver, By locatingElement) {
        driver.findElement(locatingElement).click();
    }

    /**
     * @param driver
     */
    public void qBrowser(WebDriver driver) {
        driver.quit();
    }

    /**
     * @param driver
     */
    public void cBrowser(WebDriver driver) {
        driver.close();
    }


    /**
     * @param driver
     * @return
     */
    public String gettingAlertText(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println(alertText);
        alert.accept();
        return alertText;

    }

    public void slpBrowser(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
