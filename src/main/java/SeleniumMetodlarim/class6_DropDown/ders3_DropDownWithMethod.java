package SeleniumMetodlarim.class6_DropDown;

import SeleniumMetodlarim.Util.ElementUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ders3_DropDownWithMethod {
    public static void main(String[] args) {

//        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "resources/drivers" +
//                "/chromedriver");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = null;
        driver = ElementUtil.browserLauncher(driver, "chrome");
        driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
        System.out.println("########################## DropDown Example 1 #####################################");


        By dropDownList = By.xpath("//select[@id='select-demo']");
        selectDropDownMenuWithIndex(driver, dropDownList, 1);
        System.out.println("########################## DropDown Example 2 #####################################");


        By dropDownMenu = By.id("multi-select");
        selectDropDownMenuWithIndex(driver, dropDownMenu, 0);
        System.out.println("######################### DropDown Example 3 ######################################");

        selectDropDownMenuWithText(driver, dropDownMenu, "Texas");

        ElementUtil.slpBrowser(2000);
        ElementUtil.qBrowser(driver);
    }

    public static WebElement elementGetter(WebDriver driver, By locatingElement) {
        return driver.findElement(locatingElement);
    }

    public static void selectDropDownMenuWithIndex(WebDriver driver, By locatingElement, int indexNumber) {
        WebElement webElement = elementGetter(driver, locatingElement);
        Select selectFromMenu = new Select(webElement);
        selectFromMenu.selectByIndex(indexNumber);
        String selectFromMenuName = selectFromMenu.getOptions().get(indexNumber).getText();
        System.out.println(selectFromMenuName);
    }

    public static List<String> selectDropDownMenuWithText(WebDriver driver, By locatingElement, String valueFromMenu) {
        List<String> listOfElement = new ArrayList<>();
        WebElement webElement = elementGetter(driver, locatingElement);
        Select selectFromMenu = new Select(webElement);
        selectFromMenu.selectByVisibleText(valueFromMenu);
        String textResult = driver.findElement(locatingElement).getText();
        listOfElement.add(textResult);
        return listOfElement;
    }


}
