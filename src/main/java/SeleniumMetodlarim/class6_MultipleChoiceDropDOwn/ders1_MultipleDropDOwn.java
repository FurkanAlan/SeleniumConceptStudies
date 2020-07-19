package SeleniumMetodlarim.class6_MultipleChoiceDropDOwn;

import SeleniumMetodlarim.Util.ElementUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ders1_MultipleDropDOwn {
    public static void main(String[] args) {
        //setup browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = null;
        driver = ElementUtil.browserLauncher(driver, "chrome");
        driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
        //xpath: //span[@class='comboTreeItemTitle']

        driver.findElement(By.id("justAnInputBox")).click();

        //finding elements
        List<WebElement> multElements = driver.findElements(By.className("comboTreeItemTitle"));
        int elementCount = multElements.size();
        System.out.println(elementCount);

        //looping to get text from DropDown
        for (int i = 0; i < elementCount; i++) {
            String txtFromList = multElements.get(i).getText();
            System.out.println(txtFromList);
        }

        //To choose specific value from DropDown
        for (int i = 0; i < elementCount; i++) {
            String txtFromList = multElements.get(i).getText();
//            System.out.println(txtFromList);
            if (txtFromList != null) {
                if (txtFromList.equals("choice 6 1")) {
                    String chosenFromDropDown = multElements.get(i).getText();
                    multElements.get(i).click();
                    System.out.println(chosenFromDropDown);
                    break;
                }
            }
        }



        //tearDown
        ElementUtil.slpBrowser(2000);
        ElementUtil.qBrowser(driver);
    }
}

