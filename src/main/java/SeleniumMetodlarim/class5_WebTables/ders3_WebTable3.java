package SeleniumMetodlarim.class5_WebTables;

import SeleniumMetodlarim.Util.ElementUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ders3_WebTable3 {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = null;
        driver = ElementUtil.browserLauncher(driver, "chrome");

        driver.get("http://www.w3schools.com/html/html_tables.asp");

        System.out.println("###############################################################");
        List<WebElement> hSizeFinder = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[1]/th"));
        int hSize = hSizeFinder.size();
        System.out.println("total header: " + hSize);
        System.out.println();


        //Burada tablonun header, baslik kisimlarinin degerleri bulundu
        for (int i = 1; i <= hSize; i++) {
            String xPathForHeader = "//table[@id='customers']/tbody/tr[1]/th[" + i + "]";
            WebElement tableElementsInner = driver.findElement(By.xpath(xPathForHeader));
            System.out.print(tableElementsInner.getText());
            System.out.println();
        }
        System.out.println("###############################################################");

        List<WebElement> rSizeFinder = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));
        int rSize = rSizeFinder.size();
        System.out.println("total rows: " + rSize);
        System.out.println();

        List<WebElement> cSizeFinder = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[2]/td"));
        int cSize = cSizeFinder.size();
        System.out.println("total column: " + cSize);
        System.out.println();

        for (int j = 2; j <= rSize; j++) {
            for (int k = 1; k <= cSize; k++) {
                String totalXPath = "//table[@id='customers']/tbody/tr[" + j + "]/td[" + k + "]";
                WebElement tableElementsInner = driver.findElement(By.xpath(totalXPath));
                System.out.print(tableElementsInner.getText());
                System.out.println();
                WebElement tableElements = driver.findElement(By.xpath(totalXPath));
                if (tableElements.getText().equals("Magazzini Alimentari Riuniti")) {
                    System.out.println("the name is: " + tableElements.getText() + " is in: " + (j - 1));
                    System.out.println();
                    continue;
                }
            }
        }
        System.out.println("###############################################################");

        ElementUtil.slpBrowser(2000);
        ElementUtil.qBrowser(driver);
    }

}
