package SeleniumMetodlarim.class6_DropDown;

import SeleniumMetodlarim.Util.ElementUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ders1_DropDownWithSelect {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = null;
        driver = ElementUtil.browserLauncher(driver, "chrome");

        driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
//        driver.get("https://www.facebook.com");

        WebElement opList = driver.findElement(By.id("multi-select"));
        Select select = new Select(opList);
        int sizeOptions = select.getOptions().size();
        System.out.println(sizeOptions);
        select.selectByIndex(0);
        select.selectByVisibleText("Texas");
        select.selectByValue("Ohio");
//        select.getAllSelectedOptions()
        boolean selChc = select.isMultiple();
        System.out.println(selChc);

        System.out.println("############################## Text From Options #################################");
        for (int i = 0; i < sizeOptions; i++) {
            String textOptions = select.getOptions().get(i).getText();
            System.out.println(textOptions);
        }

//        System.out.println(results);


        //select[@id='select-demo']
        //select/option[contains(text(),'Please select')]


        System.out.println("###############################################################");

//        ElementUtil.slpBrowser(2000);
//        ElementUtil.qBrowser(driver);
    }
}
