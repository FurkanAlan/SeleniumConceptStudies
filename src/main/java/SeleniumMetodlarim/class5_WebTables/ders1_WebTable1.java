package SeleniumMetodlarim.class5_WebTables;

import SeleniumMetodlarim.Util.ElementUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ders1_WebTable1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
//        ElementUtil.browserLauncher(driver, "chrome");


        driver.get("http://www.w3schools.com/html/html_tables.asp");
        ////table[@id='customers']/tbody/tr[]/td[1]  tr=> table row, td=> table column, total 7 rows (starting from 2)
        // , 3 column (starting with 1)
        String xPathPart1 = "//table[@id='customers']/tbody/tr[";
        String xPathPart2 = "]/td[1]";

//        for (int i = 2; i < 8; i++) {
//            String tXPath = xPathPart1 + i + xPathPart2;
//            WebElement tableElements = driver.findElement(By.xpath(tXPath));
//            System.out.println(tableElements.getText());
//            if (tableElements.getText().equals("Magazzini Alimentari Riuniti")) {
//                System.out.println("the name is: " + tableElements.getText() + " is in: " + (i - 1));
//                break;
//            }
//        }

        System.out.println("###########################################");


        //Full table scan
//        for (int i = 2; i < 8; i++) {
//            for (int j = 1; j < 4; j++) {
//                String totalXPath = "//table[@id='customers']/tbody/tr[" + i + "]/td[" + j + "]";
//                WebElement tableElementsInner = driver.findElement(By.xpath(totalXPath));
//                System.out.print(tableElementsInner.getText());
//                System.out.println();
//            }
//        }


        System.out.println("###########################################");

        //Bu metod tum tablo yu taradigi icin daha fazla vakit alicaktir aranilan bir degerin bulunmasi
        for (int i = 2; i < 8; i++) {
            for (int j = 1; j < 4; j++) {
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
