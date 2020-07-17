package SeleniumMetodlarim.class5_WebTables;

import SeleniumMetodlarim.Util.ElementUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ders2_WebTable2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = null;
        driver = ElementUtil.browserLauncher(driver, "chrome");

        driver.get("http://www.w3schools.com/html/html_tables.asp");

        List<WebElement> rSizeFinder = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));
        int rSize = rSizeFinder.size();
        System.out.println("total rows: " + rSize);


        List<WebElement> cSizeFinder = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[2]/td"));
        int cSize = cSizeFinder.size();
        System.out.println("total column: " + cSize);


        //size() metodu ile tablonun satir ve sutun sayilarini bulunacak
        for (int i = 2; i <= rSize; i++) {
            for (int j = 1; j <= cSize; j++) {
                String totalXPath = "//table[@id='customers']/tbody/tr[" + i + "]/td[" + j + "]";
                WebElement tableElementsInner = driver.findElement(By.xpath(totalXPath));
                System.out.print(tableElementsInner.getText());
                System.out.println();
                WebElement tableElements = driver.findElement(By.xpath(totalXPath));
                if (tableElements.getText().equals("Magazzini Alimentari Riuniti")) {
                    System.out.println("the name is: " + tableElements.getText() + " is in: " + (i - 1));
                    break;
                }
            }
        }


        ElementUtil.slpBrowser(2000);
        ElementUtil.qBrowser(driver);

    }
}
