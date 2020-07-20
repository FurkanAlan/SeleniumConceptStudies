package SeleniumMetodlarim.class10_FileUpload;

import SeleniumMetodlarim.Util.ElementUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class ders1_FileUploader {
    public static void main(String[] args) {
        //setup browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = null;

        driver = ElementUtil.browserLauncher(driver, "chrome");


        //As an example non-webelement
        driver.get("http://kaigabu.soc.or.jp/example/fup.html");

        System.out.println("##################### first method ##########################");

        //Fluent wait set up
        FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(8))
                .pollingEvery(Duration.ofSeconds(2))
                .withMessage("Still W8 :)")
                .ignoring(NoSuchMethodException.class);

        System.out.println("################################################");


        By locatingElement = By.xpath("//input[@name='note']");

        WebElement elementForFluentWaitMethod2 =
                fluentWait.until(ExpectedConditions.presenceOfElementLocated(locatingElement));

        String filePath = System.getProperty("user.dir") + "/src/main/java/imgOutput/resim1.jpg";
//        elementForFluentWaitMethod2.sendKeys(filePath);

        System.out.println("################################################");

        System.out.println("##################### second method ##########################");
        ElementUtil.fileUploader(driver, locatingElement, filePath,10);



        //tearDown
        ElementUtil.slpBrowser(5000);
        ElementUtil.qBrowser(driver);
    }
}
