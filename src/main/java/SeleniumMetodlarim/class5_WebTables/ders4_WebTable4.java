package SeleniumMetodlarim.class5_WebTables;

import SeleniumMetodlarim.Util.ElementUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ders4_WebTable4 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = null;
        driver = ElementUtil.browserLauncher(driver, "chrome");

        driver.get("http://www.w3schools.com/html/html_tables.asp");

        System.out.println("###############################################################");


        int cNumber = getColumnNumberTable(driver);
        int rNumber = getRowNumberTable(driver);
        int hNumber = getHeaderNumberTable(driver);
        System.out.println(cNumber + " is column number " + rNumber + " is row number " + hNumber + " is header number");

        System.out.println("###########################Getting Row Values by " +
                "applying different column numbers####################################");

        String firstPartXPath = "//*[@id='customers']/tbody/tr[";
        String secondPartXPathFirstColumn = "]/td[1]";
        String secondPartXPathSecondColumn = "]/td[2]";
        String secodedPartXPathThirdColumn = "]/td[3]";

        getDataFromTableRow(driver, firstPartXPath, secondPartXPathFirstColumn);
        System.out.println();
        getDataFromTableRow(driver, firstPartXPath, secondPartXPathSecondColumn);
        System.out.println();
        getDataFromTableRow(driver, firstPartXPath, secodedPartXPathThirdColumn);


        System.out.println("######################### second method ######################################");

        String xPathPart1 = "//table[@id='customers']/tbody/tr[";
        String xPathPart2 = "]/td[";
        String xPathPart3 = "]";

//        getDataFromTableRowColumn(driver, xPathPart1, xPathPart2, xPathPart3);
       List <String> abc =  getDataFromTableRowColumnReturnType(driver,xPathPart1,xPathPart2,xPathPart3);

//       abc.stream().collect(Collectors.toList());
//        new ArrayList<>(abc);


        //"//table[@id='customers']/tbody/tr["
        //"]/td["
        //"]"

        ElementUtil.slpBrowser(2000);
        ElementUtil.qBrowser(driver);
    }

    public static int getHeaderNumberTable(WebDriver driver) {
        List<WebElement> getheaderNumber = driver.findElements(By.xpath("//table[@id='customers']//th"));
        int headSize = getheaderNumber.size();
        return headSize;
    }

    public static int getRowNumberTable(WebDriver driver) {
        List<WebElement> rowNumber = driver.findElements(By.xpath("//table[@id='customers']//tr"));
        int rowSize = rowNumber.size();
        return rowSize;
    }

    public static int getColumnNumberTable(WebDriver driver) {
        List<WebElement> columnNumber = driver.findElements(By.xpath("//table[@id='customers']//tr[3]/td"));
        int columnSize = columnNumber.size();
        return columnSize;
    }


    /**
     * @param driver
     * @param xPathPart1
     * @param xPathPart2
     * @return
     */
    public static List<String> getDataFromTableRow(WebDriver driver, String xPathPart1, String xPathPart2) {
        List<String> textRowList = new ArrayList<String>();
        for (int i = 2; i <= getRowNumberTable(driver); i++) {
            String totalXPath = xPathPart1 + i + xPathPart2;
            String textFromRows = driver.findElement(By.xpath(totalXPath)).getText();
            System.out.println(textFromRows);
            textRowList.add(textFromRows);
        }
        return textRowList;
    }


    /**
     * Example pattern;   String xPathPart1 = "//table[@id='customers']/tbody/tr[";
     * String xPathPart2 = "]/td[";
     * String xPathPart3 = "]";
     *
     * @param driver
     * @param xPathPart1
     * @param xPathPart2
     * @param xPathPart3
     * @return
     */
    // Can get all the data from table
    public static void getDataFromTableRowColumn(WebDriver driver, String xPathPart1, String xPathPart2, String xPathPart3) {
//        List<String> textFromRowsColumnList = new ArrayList<String>();
        for (int i = 2; i <= getRowNumberTable(driver); i++) {
            for (int j = 1; j <= getColumnNumberTable(driver); j++) {
                String totalXPath = xPathPart1 + i + xPathPart2 + j + xPathPart3;
                String textFromRowsColumn = driver.findElement(By.xpath(totalXPath)).getText();
                System.out.println(textFromRowsColumn);
//                textFromRowsColumnList.add(textFromRowsColumn);
            }
        }
//        return textFromRowsColumnList;
    }


    /**
     * Example pattern;   String xPathPart1 = "//table[@id='customers']/tbody/tr[";
     * String xPathPart2 = "]/td[";
     * String xPathPart3 = "]";
     *
     * @param driver
     * @param xPathPart1
     * @param xPathPart2
     * @param xPathPart3
     * @return
     */
    //2. way
    public static List<String> getDataFromTableRowColumnReturnType(WebDriver driver, String xPathPart1, String xPathPart2,
                                                                   String xPathPart3) {
        ArrayList<String> textFromRowsColumnList = new ArrayList<String>();
        for (int i = 2; i <= getRowNumberTable(driver); i++) {
            for (int j = 1; j <= getColumnNumberTable(driver); j++) {
                String totalXPath = xPathPart1 + i + xPathPart2 + j + xPathPart3;
                String textFromRowsColumn = driver.findElement(By.xpath(totalXPath)).getText();
                System.out.println(textFromRowsColumn);
                textFromRowsColumnList.add(textFromRowsColumn);
            }
        }
        return textFromRowsColumnList;
    }
}
