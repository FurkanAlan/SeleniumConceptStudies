package SeleniumMetodlarim.class5_WebTables;

import SeleniumMetodlarim.Util.ElementUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ders5_Calender {
    public static void main(String[] args) {
        //setup browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = null;

        driver = ElementUtil.browserLauncher(driver, "chrome");

        driver.get("https://www.path2usa.com/travel-companions");

        System.out.println("##################### the title ##########################");
        System.out.println(driver.getTitle());
        ElementUtil.slpBrowser(10000);
//        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);


        By locatingElement = By.id("travel_date");
        //Calender Element
        WebElement element = ElementUtil.getElementWithExpWaitApplied(driver, locatingElement, 10);
        //Clicking the calender element to open the calender.
        element.click();

        // 20 april 2021
        List<WebElement> listOfMonths = driver.findElements(By.className("month"));
        int sizeOfMonths = listOfMonths.size();
        System.out.println(sizeOfMonths);

        By transitionElementToLocator = By.xpath("//th[contains(text(),'July 2020')]");
        WebElement transitionElement = driver.findElement(transitionElementToLocator);
        transitionElement.click();

        By nextPage = By.xpath("//div[@class='datepicker-months']//th[@class='next'][contains(text(),'»')]");
        WebElement nexPageElement = driver.findElement(nextPage);
        nexPageElement.click();


        By locatingMonthPicked = By.xpath("//span[contains(text(),'Apr')]");
        WebElement monthElement = driver.findElement(locatingMonthPicked);
        monthElement.click();

        By locatingDayPicked = By.xpath("//td[contains(text(),'27')]");
        WebElement dayElement = driver.findElement(locatingDayPicked);
        dayElement.click();


        //tearDown
        ElementUtil.slpBrowser(2000);
        ElementUtil.qBrowser(driver);
    }
}

class DatePicker {
    public static void main(String[] args) {

        // setting up the chrome driver.
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //opening the target url
        driver.get("https://www.path2usa.com/travel-companions");
        ElementUtil.slpBrowser(10000);

        //Clicking the calender element to open the calender.
        driver.findElement(By.xpath("//input[@id='travel_date']")).click();

//        WebElement datePicker = driver.findElement(By.cssSelector("[class='datepicker-days'] " +
//                "th[class='datepicker-switch']"));
//        String monthList = datePicker.getText();
//
//        WebElement changePage = driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='next" +
//                "'][contains(text(),'»')]"));


        while (!driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='datepicker-switch']")).getText().contains("May")) {
            //this will click till finding the moth April.
            driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='next'][contains(text(),'»')]")).click();
            ElementUtil.slpBrowser(1000);
        }


        //Size of days
        List<WebElement> dates = driver.findElements(By.className("day"));
        int count = dates.size();
        System.out.println(count);

        // iterating to find input date, 20
        for (int i = 0; i < count; i++) {
            //We are getting the each day
            String text = dates.get(i).getText();
            System.out.println(text);

            // it will loop and will break the loop at picked date.
            if (text.equalsIgnoreCase("20")) {
                dates.get(i).click();
                break;
            }
        }

        //tearDown
        ElementUtil.slpBrowser(2000);
//        ElementUtil.qBrowser(driver);
    }
//    https://github.com/mehmetgul/MySeleniumLibrary/blob/master/src/test/java/mehmetgul/mylib/calendars/SelectFutureDateCalendar.java
}
