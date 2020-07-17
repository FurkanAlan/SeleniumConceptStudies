package SeleniumMetodlarim.class4_ScreenShot;

import SeleniumMetodlarim.Util.ElementUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ders1_SreenShot {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = null;
        driver = ElementUtil.browserLauncher(driver, "chrome");

        driver.manage().window().maximize(); //full page
        driver.manage().deleteAllCookies();  //kuky eater

        driver.get("https://app.hubspot.com/login");
        ElementUtil.slpBrowser(5000);

        //jpeg, png, tiff
        File resimCeken = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(resimCeken, new File(System.getProperty("user.dir") +"/src/main/java/imgOutput/resim3" +
                    ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }


        ElementUtil.slpBrowser(2000);
        ElementUtil.qBrowser(driver);
    }
}
