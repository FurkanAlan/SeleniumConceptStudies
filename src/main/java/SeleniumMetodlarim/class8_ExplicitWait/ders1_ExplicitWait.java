package SeleniumMetodlarim.class8_ExplicitWait;

import SeleniumMetodlarim.Util.ElementUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ders1_ExplicitWait {
    public static void main(String[] args) {
        //setup browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = null;

        driver = ElementUtil.browserLauncher(driver, "chrome");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        //It works with web elements and not web elements.
        //Expl wait will w8 for specific elements in the page with given time and timeunit

        //As an example non-webelement
        driver.get("https://app.hubspot.com/login");
        //Waiting
        WebDriverWait waitForElementOrPage = new WebDriverWait(driver, 5);
        Boolean titleResult = waitForElementOrPage.until(ExpectedConditions.titleIs("HubSpot Login"));

        //console results
        System.out.println(waitForElementOrPage.until(ExpectedConditions.titleContains("Hub")));
        System.out.println(titleResult.toString());

        WebElement elementForExpWait = driver.findElement(By.id("username"));
        waitForElementOrPage.until(ExpectedConditions.visibilityOf(elementForExpWait));

        //Login Button is enabled
        System.out.println("'''''''''''''''''''''''' Login Button infos ''''''''''''''''''''''''''''");
        By loginButton = By.id("loginBtn");
        WebElement loginBtnWebElement = driver.findElement(loginButton);
        System.out.println("Login is enabled: "+loginBtnWebElement.isEnabled()+ ", is displayed: "+loginBtnWebElement.isDisplayed() + ", is selected: " + loginBtnWebElement.isSelected());

        //Application of web page elements
        System.out.println("######################### Example 1 ##########################");

        elementForExpWait.sendKeys("test123@gmail.com");

        System.out.println("######################### Example 2 ##########################");

        By passWord = By.id("password");
        waitForElementOrPage.until(ExpectedConditions.presenceOfElementLocated(passWord));
        WebElement elementForExpWaitPassWord = driver.findElement(passWord);
        elementForExpWaitPassWord.sendKeys("test111@12");

        System.out.println("####################### Title ###################################");
        System.out.println(driver.getTitle());

        System.out.println("#################################################################");



        //tearDown
        ElementUtil.slpBrowser(2000);
        ElementUtil.qBrowser(driver);
    }
}
