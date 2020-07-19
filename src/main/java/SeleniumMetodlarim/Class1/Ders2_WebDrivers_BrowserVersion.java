package SeleniumMetodlarim.Class1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ders2_WebDrivers_BrowserVersion {
    public static void main(String[] args) {
        //there may problem due to version selection!!!
        WebDriverManager.chromedriver().browserVersion("83.0.4103.116").setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com/");
        
        String url = driver.getCurrentUrl();
        String title = driver.getTitle();

        System.out.println("url is " + url + " title is "+title);

        //Thread sleep is not part of the Selenium, it is part of JAVA
        //it is a static wait
        //used to slow down element or thread on a webpage
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();

        System.out.println("Test finished");
    }
}
