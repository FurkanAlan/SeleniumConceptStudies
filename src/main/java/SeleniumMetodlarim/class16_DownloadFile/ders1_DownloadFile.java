package SeleniumMetodlarim.class16_DownloadFile;

import SeleniumMetodlarim.Util.ElementUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ders1_DownloadFile {
    public static void main(String[] args) {
        //setup browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = null;

        String dFilePath = System.getProperty("user.dir") + "/src/main/java/downloadLocation";

        Map<String, Object> chosenPref = new HashMap<String, Object>();
        chosenPref.put("profile.default_content_settings.popup", 0);
        chosenPref.put("download.default_directory", dFilePath);
        System.out.println(chosenPref);
//        DesiredCapabilities


        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setExperimentalOption("prefs", chosenPref);
        driver = new ChromeDriver(browserOptions);
        driver.get("https://www.seleniumhq.org/download/");

        By downloadFile = By.xpath("//tr[2]//td[6]//a[1]");
        WebElement elementOfDownloadFile = driver.findElement(downloadFile);
        elementOfDownloadFile.click();

        System.out.println("##################### the title ##########################");
        System.out.println(driver.getTitle());


        //tearDown
        ElementUtil.slpBrowser(5000);
        ElementUtil.qBrowser(driver);
    }

}

class AutoSuggestDropDown {
    public static void main(String[] args) {

        //Setting up the chrome driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //Opening the target url
        driver.get("http://www.ksrtc.in");

        //clicking the element
        driver.findElement(By.xpath("//input[@id='fromPlaceName']")).click();
        ElementUtil.slpBrowser(2000);

        //entering the keys to the element.
        driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys("BANG");
        ElementUtil.slpBrowser(2000);

        //in hidden elements getText() method doesn't work.It will display nothing.
        //driver.findElement(By.xpath("//input[@id='fromPlaceName']")).getText();

        //We are using JavaScript DOm to get the value from element.
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //using javascripts method to get the element same as selenium.
        String script = "return document.getElementById(\"fromPlaceName\").value;";
        //We are executing the script and getting the value and assigning that value to a string
        String text = (String) js.executeScript(script);

        System.out.println("Text is : " + text);

        int i = 0;

        //putting a while loop t get the desired value and stop it.
        while (!text.equalsIgnoreCase("BANGALORE INTERNATION AIRPORT")) {
            i++;
            ElementUtil.slpBrowser(2000);
            driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.DOWN);
            text = (String) js.executeScript(script);
            System.out.println("Inside while loop : " + text);

            //After finding the desired value, click on it.
            if (text.equalsIgnoreCase("BANGALORE INTERNATION AIRPORT")) {
                driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.ENTER);
            }

            System.out.println(i);
            // putting if condition in case if the target value not available, to stop the loop
            if (i > 10) {
                System.out.println("Element not found");
                break;
            }
        }

    }
}

//https://github.com/mehmetgul/MySeleniumLibrary/blob/master/src/test/java/mehmetgul/mylib/dropdown/AutoSuggestDropDown.java