package SeleniumMetodlarim.class2_Locators;

import SeleniumMetodlarim.Util.ElementUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ders1_locators_id {
    //    ElementUtil eUtil = new ElementUtil();
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://app.hubspot.com/login");
        ElementUtil.slpBrowser(5000);
        WebElement uNameElement = driver.findElement(By.id("username"));
        //Standart usage 1.way
//        uNameElement.sendKeys("aaaaaa@gmail.com");
//
//        WebElement pwebElement = driver.findElement(By.id("password"));
//        pwebElement.sendKeys("deneme$123");
//
//        WebElement lgnElement = driver.findElement(By.id("loginBtn"));
//        lgnElement.click();


        //2.way
//        driver.findElement(By.id("username")).sendKeys("aaaaaa@gmail.com");
//        driver.findElement(By.id("password")).sendKeys("deneme$123");
//        driver.findElement(By.id("loginBtn")).click();

        //3.way
//        By uName = By.id("username");
//        WebElement uElement = driver.findElement(uName);
//        uElement.sendKeys("aaaaaa@gmail.com");
//
//        By pName = By.id("password");
//        WebElement pElement = driver.findElement(pName);
//        pElement.sendKeys("deneme$123");
//
//        By clcName = By.id("loginBtn");
//        WebElement clcElement = driver.findElement(clcName);
//        clcElement.click();

        //4.way, uses 3.way By variables
//        ElementUtil.getYourElement(driver, uName).sendKeys("aaaaaa@gmail.com");
//        ElementUtil.getYourElement(driver, pName).sendKeys("deneme$123");
//        ElementUtil.getYourElement(driver, clcName).click();


        ElementUtil.slpBrowser(2000);
        ElementUtil.qBrowser(driver);
    }
}

class PageFactoryClass{
    public static WebDriver driverPageFactory;

    //5.way
    @FindBy(id = "username")
    public static WebElement uName;

    @FindBy(id = "password")
    public static WebElement pName;

    @FindBy(id = "loginBtn")
    public static WebElement clcElement;

    public PageFactoryClass(){
        PageFactory.initElements(driverPageFactory,this);
    }
}
