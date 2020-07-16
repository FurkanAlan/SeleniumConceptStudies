package SeleniumMetodlarim.Class1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ders1_WebDrivers_TitleVerify {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com/");

        String titleGetter = driver.getTitle();

//        switch (titleGetter) {
//            case titleGetter.equalsIgnoreCase("Google"):
//                System.out.println("GG");
//                break;
//            case titleGetter.equalsIgnoreCase("Microsoft"):
//                System.out.println("Wrong address");
//                break;
//            default :
//                System.out.println("Try again");
//        }
        String resultTitle = (titleGetter.equalsIgnoreCase("Google"))? "Cool, Well Done ":
                (titleGetter.equalsIgnoreCase("Microsoft"))? "Wrong Adress": "Try Again";

        System.out.println(resultTitle);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }

}
