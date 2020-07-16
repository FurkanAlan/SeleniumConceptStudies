package SeleniumMetodlarim.class2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;

public class Ders1_Alerts {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.get("http://demo.guru99.com/test/delete_customer.php");

//        driver.findElement(By.xpath("//input[@name='cusid']"));
        driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys("111111");
        driver.findElement(By.name("submit")).click();


        Thread.sleep(2000);

        // Switching to Alert
        Alert alert = driver.switchTo().alert();

        //Get the first Alert Text
        String alertText = alert.getText();

        System.out.println(alertText);
        System.out.println(counterOfWord(alertText));


        alert.accept();

        //Get the second Alert Text
        String alertText2 = alert.getText();
        System.out.println(alertText2);


        alert.dismiss();

        Thread.sleep(2000);

        driver.quit();

        System.out.println("Test Done");
    }

    public static long counterOfWord(String str) {
        return Arrays.stream(str.split(" "))
                .count();
    }
}
