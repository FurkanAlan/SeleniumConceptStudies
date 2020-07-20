package SeleniumMetodlarim.class14_ActionClass;

import SeleniumMetodlarim.Util.ElementUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ders2_MoveToElement {
    public static void main(String[] args) {
        //setup browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = null;

        driver = ElementUtil.browserLauncher(driver, "chrome");

        driver.get("https://www.att.com/");

        System.out.println("##################### the title of main menu ##########################");
        System.out.println(driver.getTitle());

        By locatingElement1 = By.xpath("//span[contains(@class,'z1-tier1-text')][contains(text(),'Wireless')]");
        By locatingElement2 = By.xpath("//span[contains(@class,'z1-tier1-text')][contains(text(),'Prepaid')]");

        WebElement movingToWebElement1 = driver.findElement(locatingElement1);
        WebElement movingToWebElement2 = driver.findElement(locatingElement2);


        Actions actions = new Actions(driver);
        actions.moveToElement(movingToWebElement1).build().perform();
        actions.moveToElement(movingToWebElement2).build().perform();
        movingToWebElement2.click();



        System.out.println("##################### the title of sub menu ##########################");
        System.out.println(driver.getTitle());


        //tearDown
        ElementUtil.slpBrowser(2000);
        ElementUtil.qBrowser(driver);
    }

}
