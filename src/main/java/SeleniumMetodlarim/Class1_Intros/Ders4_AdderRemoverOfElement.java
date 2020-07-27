package SeleniumMetodlarim.Class1_Intros;

import SeleniumMetodlarim.Util.ElementUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Ders4_AdderRemoverOfElement {
    public static void main(String[] args) {
        //setup browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = null;

        driver = ElementUtil.browserLauncher(driver, "chrome");

        driver.get("http://practice.cybertekschool.com/add_remove_elements/");

        System.out.println("##################### the title ##########################");
        System.out.println(driver.getTitle());


        By locatingElement = By.tagName("button");
        for (int i = 0; i < 10; i++) {
            WebElement element = driver.findElement(locatingElement);
            element.click();
        }

        //1. method
//        By locatingElementToRemove = By.className("added-manually");
//        for (int i = 0; i < 10; i++) {
//            WebElement element = driver.findElement(locatingElementToRemove);
//            element.click();
//        }

        //2. method
        By locatingElementToRemove2Method = By.xpath("//div[@id='elements']//button");
        //bazen bu sekilde olmasi hataya sebep oluyor ondan dolayi By.xpath("//div[@id='elements']//button");
        //bu sekilde kullanilmasi daha guvenli bu sadece elementleri listelrken ki durumda karsilastim
        List<WebElement> elementsToRemove = driver.findElements(locatingElementToRemove2Method);
        int sizeOfElement = elementsToRemove.size();
        System.out.println(sizeOfElement);
        for (int i = 0; i < sizeOfElement; i++) {
            elementsToRemove.get(i).click();
        }



        //tearDown
        ElementUtil.slpBrowser(2000);
        ElementUtil.qBrowser(driver);
    }

}
