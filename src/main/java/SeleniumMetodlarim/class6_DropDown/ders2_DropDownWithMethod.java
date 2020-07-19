package SeleniumMetodlarim.class6_DropDown;

import SeleniumMetodlarim.Util.ElementUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ders2_DropDownWithMethod {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "resources/drivers" +
                "/chromedriver");

//        WebDriverManager.chromedriver().setup();
        WebDriver driver = null;
        driver = ElementUtil.browserLauncher(driver, "chrome");
        driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");

        WebElement opList = driver.findElement(By.id("multi-select"));
        System.out.println("############################ Select with Index with " +
                "Method ###################################");

        selectDropDownMenuWithIndex(opList, 0);

        System.out.println("############################# Select with Text with Method " +
                "##################################");

        selectDropDownMenuWithText(opList, "Texas");

        ElementUtil.slpBrowser(2000);
        ElementUtil.qBrowser(driver);
    }

    public static void selectDropDownMenuWithIndex(WebElement webElement, int indexNumber) {
        Select selectFromMenu = new Select(webElement);
        selectFromMenu.selectByIndex(indexNumber);
        String chosenText = selectFromMenu.getOptions().get(indexNumber).getText();
        System.out.println(chosenText);
    }

    public static void selectDropDownMenuWithText(WebElement webElement, String valueFromMenu) {
        Select selectFromMenu = new Select(webElement);
        selectFromMenu.selectByVisibleText(valueFromMenu);
    }
}
