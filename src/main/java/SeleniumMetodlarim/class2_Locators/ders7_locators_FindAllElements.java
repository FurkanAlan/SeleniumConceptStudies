package SeleniumMetodlarim.class2_Locators;

import SeleniumMetodlarim.Util.ElementUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ders7_locators_FindAllElements {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = null;
        driver = ElementUtil.browserLauncher(driver, "ChrOme");

        driver.get("https://app.hubspot.com/login");
        ElementUtil.slpBrowser(5000);
        driver.manage().window().fullscreen();
        driver.manage().deleteAllCookies();


        //finding All Elements
        List<WebElement> getAllLinks = driver.findElements(By.tagName("a"));


        System.out.println("Got all links, total: " + getAllLinks.size());

        for (int i = 0; i < getAllLinks.size(); i++) {
            String textFromLinks = getAllLinks.get(i).getText();
            System.out.println(textFromLinks);

            if (textFromLinks.equalsIgnoreCase("Sign up")) {
                getAllLinks.get(i).click();
                break;
            }
        }

        ElementUtil.screenShotGetter(driver, "/src/main/java/imgOutput/", "resim2.png");
        ElementUtil.slpBrowser(2000);
        ElementUtil.qBrowser(driver);
    }
}
