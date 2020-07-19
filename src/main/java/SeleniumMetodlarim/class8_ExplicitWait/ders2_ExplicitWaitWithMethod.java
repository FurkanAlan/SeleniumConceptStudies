package SeleniumMetodlarim.class8_ExplicitWait;

import SeleniumMetodlarim.Util.ElementUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ders2_ExplicitWaitWithMethod {
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

        //Application of web page elements

        System.out.println("######################### Example 1 ##########################");

        By loginUserName = By.id("username");
        By loginPassword = By.id("password");
        By loginButton = By.id("loginBtn");


        System.out.println("####################### Explicitly Wait With Methods ###################################");
        getElementWithExpWaitApplied(driver, loginUserName).sendKeys("test123@gmail.com");
        String textFromField = getElementWithExpWaitApplied(driver, loginPassword).getTagName();
        String textFromField2 = getElementWithExpWaitApplied(driver, loginPassword).getLocation().toString();
        System.out.println(textFromField);
        System.out.println(textFromField2);
        System.out.println("#################################################################");


        //tearDown
        ElementUtil.slpBrowser(2000);
        ElementUtil.qBrowser(driver);
    }

    public static WebElement getElementWithExpWaitApplied(WebDriver driver, By locatingElement) {
        WebDriverWait waitForElementOrPage = new WebDriverWait(driver, 10);
        waitForElementOrPage.until(ExpectedConditions.presenceOfElementLocated(locatingElement));
        return driver.findElement(locatingElement);
    }
}