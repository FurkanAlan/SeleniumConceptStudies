package SeleniumMetodlarim.class9_FluentWait;

import SeleniumMetodlarim.Util.ElementUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.io.IOException;
import java.time.Duration;
import java.util.function.Function;

public class ders1_FluentWait {
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
        driver.get("http://softwaretestingplace.blogspot.com/2017/02/selenium-fluent-wait.html?m=1");

        WebElement elementFinder = driver.findElement(By.tagName("button"));
        elementFinder.click();
        //Waiting


        //Application of web page elements

        System.out.println("######################### Example 1 ##########################");


        System.out.println("####################### Explicitly Wait With Methods ###################################");

        System.out.println("################################ The Title #################################");
        System.out.println(driver.getTitle());

        By locatingElement = By.id("demo");
        String expText = "Software Testing Material - DEMO PAGE";


        ElementUtil.elementForFluentWait(driver, locatingElement, 10, 2, expText);


//        FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
//                .withTimeout(Duration.ofSeconds(8))
//                .pollingEvery(Duration.ofSeconds(2))
//                .withMessage("Still W8 :)")
//                .ignoring(NoSuchMethodException.class);
//
//        WebElement elementForFluentWait = fluentWait.until(new Function<WebDriver, WebElement>() {
//            public WebElement apply(WebDriver webDriver) {
//                WebElement elementWaiter = webDriver.findElement(By.xpath("//p[@id='demo']"));
//                String textFromElement = elementWaiter.getText();
//                if (textFromElement.equals("Software Testing Material - DEMO PAGE") || textFromElement.contains("DEMO")) {
//                    System.out.println("Got the text: " + textFromElement);
//                    return elementWaiter;
//                } else {
//                    System.out.println("Could not find the title");
//                    return null;
//                }
//            }
//        });


        //tearDown
        ElementUtil.slpBrowser(2000);
        ElementUtil.qBrowser(driver);
    }
}


class SecondFluentWaitTest {
    public static void main(String[] args) {
        //setup browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = null;

        driver = ElementUtil.browserLauncher(driver, "chrome");


        //As an example non-webelement
        driver.get("http://softwaretestingplace.blogspot.com/2017/02/fluent-wait.html");

        WebElement elementFinder = driver.findElement(By.xpath("//button[contains(text(),'Fluent Wait - Click Me :-)')" +
                "]"));
        elementFinder.click();


        FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(8))
                .pollingEvery(Duration.ofSeconds(2))
                .withMessage("Still W8 :)")
                .ignoring(NoSuchMethodException.class);
        System.out.println("##################### first method ##########################");
        By locatingElement = By.id("softwareTestingMaterial");

        WebElement elementForFluentWaitMethod2 =
                fluentWait.until(ExpectedConditions.presenceOfElementLocated(locatingElement));
        String elementText = elementForFluentWaitMethod2.getText();
        if (elementText.contains("software") || elementText.contains("Testing") || elementText.contains("Material")) {
            System.out.println("Got the text: " + elementText);
        } else {
            System.out.println("Could not find the title");
        }



//        WebElement elementForFluentWait = fluentWait.until(new Function<WebDriver, WebElement>() {
//            public WebElement apply(WebDriver webDriver) {
//                WebElement elementWaiter = webDriver.findElement(By.id("softwareTestingMaterial"));
//                String textFromElement = elementWaiter.getText();
//                if (textFromElement.contains("software") || textFromElement.contains("Testing") || textFromElement.contains("Material")) {
//                    System.out.println("Got the text: " + textFromElement);
//                    return elementWaiter;
//                } else {
//                    System.out.println("Could not find the title");
//                    return null;
//                }
//            }
//        });


        //tearDown
        ElementUtil.slpBrowser(2000);
        ElementUtil.qBrowser(driver);
    }
}