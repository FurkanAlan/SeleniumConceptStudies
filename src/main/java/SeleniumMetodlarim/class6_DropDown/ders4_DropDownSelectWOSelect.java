package SeleniumMetodlarim.class6_DropDown;

import SeleniumMetodlarim.Util.ElementUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

class DropDownTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = null;
        driver = ElementUtil.browserLauncher(driver, "chrome");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/jquery-dropdown-search-demo.html");

//        WebElement dropListElement = driver.findElement(By.id("multi-select"));
//
//        Select dropListElementSelected = new Select(dropListElement);
////        dropListElementSelected.selectByValue("Texas");
//
////        WebElement opListElementSelected = dropListElementSelected.getFirstSelectedOption();
////        String selectedTextFromDropDown = opListElementSelected.getText();
//
////        System.out.println(selectedTextFromDropDown);

        List<WebElement> opListed = driver.findElements(By.xpath("//select[@id='country']/option"));
        int sizeOfList = opListed.size();

        for (int i = 1; i < sizeOfList; i++) {
            String obText = opListed.get(i).getText();
            System.out.println(obText);
//            opListed.get(i).getAttribute("Texas").length();
        }
        WebElement elementToClick = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[1" +
                "]/div[2]/span[1]/span[1]/span[1]"));
        elementToClick.click();
        WebElement searchBox = driver.findElement(By.xpath("//span/input[@class='select2-search__field']"));
        searchBox.sendKeys("South Africa");


        ElementUtil.slpBrowser(2000);
        ElementUtil.qBrowser(driver);
    }
}


public class ders4_DropDownSelectWOSelect {
    public static void main(String[] args) {
        //        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "resources/drivers" +
//                "/chromedriver");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = null;
        driver = ElementUtil.browserLauncher(driver, "chrome");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
//        driver.get("https://www.seleniumeasy.com/test/jquery-dropdown-search-demo.html");
        driver.get("https://www.facebook.com");
        List<WebElement> facebookDropdownYears = driver.findElements(By.xpath("//select[@id='year']/option"));
        int sizeOfDropdownYears = facebookDropdownYears.size();

        for (int i = 0; i < sizeOfDropdownYears; i++) {
            String obText = facebookDropdownYears.get(i).getText();
            System.out.println(obText);
            if (obText.equals("1985")) {
                facebookDropdownYears.get(i).click();
                break;
            }
        }
    }
}

