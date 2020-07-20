package SeleniumMetodlarim.class14_ActionClass;

import SeleniumMetodlarim.Util.ElementUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ders3_RightClick {
    public static void main(String[] args) {
        //setup browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = null;

        driver = ElementUtil.browserLauncher(driver, "chrome");

        driver.get("https://www.att.com/");

        System.out.println("##################### the title of main menu ##########################");
        System.out.println(driver.getTitle());

        By locatingElement1 = By.xpath("//span[contains(@class,'z1-tier1-text')][contains(text(),'Wireless')]");

        WebElement rightClickToElement = driver.findElement(locatingElement1);


        Actions actions = new Actions(driver);
        actions.click(rightClickToElement).build().perform();

        By locatingElement2 = By.xpath("//a[contains(@class,'_1hxmk')]//span[contains(@class,'')][contains(text()," +
                "'Phones & devices')]");

        WebElement contextClickToElement = ElementUtil.getElementWithExpWaitApplied(driver,locatingElement2,5);


        System.out.println("##################### the title of sub menu ##########################");
        actions.contextClick(contextClickToElement).build().perform();
        System.out.println(driver.getTitle());

        //tearDown
        ElementUtil.slpBrowser(2000);
        ElementUtil.qBrowser(driver);
    }

}
