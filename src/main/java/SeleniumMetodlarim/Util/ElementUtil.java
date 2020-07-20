package SeleniumMetodlarim.Util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ElementUtil {
    //several common method storages
//    public static WebDriver driver;

    /**
     * FurkanAlan
     */


    /**
     * @param driver
     * @param bName
     * @return
     */
    //Browser Launcher
    public static WebDriver browserLauncher(WebDriver driver, String bName) {
        if (bName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            System.out.println("you chose chrome browser");
        } else if (bName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            System.out.println("you chose firefox browser");
        } else {
            System.out.println("Error, check it: " + bName);
        }
        return driver;
    }

    /**
     * @param driver
     * @param urlName
     */
    //url launcher
    public static void findSurfPageName(WebDriver driver, String urlName) {
        driver.get(urlName);
    }

    /**
     * @param driver
     * @return
     */
    public static String pTitleOf(WebDriver driver) {
        return driver.getTitle();
    }

    /**
     * @param driver
     * @param locatingElement
     * @param someThing
     */
    public static void sendData(WebDriver driver, By locatingElement, String someThing) {
        driver.findElement(locatingElement).sendKeys(someThing);
    }


    /**
     * @param driver
     * @param locatingElement
     */
    public static void waitForElementsAvailability(WebDriver driver, By locatingElement) {
        WebDriverWait webWait = new WebDriverWait(driver, 13);
        webWait.until(ExpectedConditions.presenceOfElementLocated(locatingElement));
    }

    /**
     * get your element
     *
     * @param driver
     * @param locatingElement
     * @return
     */

    public static WebElement getYourElement(WebDriver driver, By locatingElement) {
        waitForElementsAvailability(driver, locatingElement);
        return driver.findElement(locatingElement);
    }


    /**
     * @param driver
     * @param locatingElement
     */
    public static void clickerOn(WebDriver driver, By locatingElement) {
        driver.findElement(locatingElement).click();
    }

    /**
     * @param driver
     */
    public static void qBrowser(WebDriver driver) {
        driver.quit();
    }

    /**
     * @param driver
     */
    public static void cBrowser(WebDriver driver) {
        driver.close();
    }


    /**
     * @param driver
     * @return
     */
    public static String gettingAlertText(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println(alertText);
        alert.dismiss();
        return alertText;

    }

    public static void slpBrowser(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void screenShotGetter(WebDriver driver, String locationToSave, String fileNameAndExtension) {
        File resimCeken = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(resimCeken,
                    new File(System.getProperty("user.dir") + locationToSave + fileNameAndExtension));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("resim cekerken hata oldu");
        }
    }


    public static int getHeaderNumberTable(WebDriver driver) {
        List<WebElement> getheaderNumber = driver.findElements(By.xpath("//table[@id='customers']//th"));
        return getheaderNumber.size();
    }

    public static int getRowNumberTable(WebDriver driver) {
        List<WebElement> rowNumber = driver.findElements(By.xpath("//table[@id='customers']//tr"));
        return rowNumber.size();
    }

    public static int getColumnNumberTable(WebDriver driver) {
        List<WebElement> columnNumber = driver.findElements(By.xpath("//table[@id='customers']//tr[3]/td"));
        return columnNumber.size();
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


    /**
     * Explicitly Wait Method applied, ExpectedConditions.presenceOfElementLocated 10 seconds
     *
     * @param driver
     * @param locatingElement
     * @param timeOutForElement
     * @return
     */
    public static WebElement getElementWithExpWaitApplied(WebDriver driver, By locatingElement, int timeOutForElement) {
        WebDriverWait waitForElementOrPage = new WebDriverWait(driver, timeOutForElement);
        waitForElementOrPage.until(ExpectedConditions.presenceOfElementLocated(locatingElement));
        return driver.findElement(locatingElement);
    }


    public static void fluentWaitForElement(WebDriver driver, int timeOutDuration,
                                            int pollingEvery) {
        FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(timeOutDuration))
                .pollingEvery(Duration.ofSeconds(pollingEvery))
                .withMessage("Still W8 :)")
                .ignoring(NoSuchMethodException.class);
    }

    public static void elementForFluentWait(WebDriver driver, By locatingElement, int timeOutDuration, int pollingEvery, String expText) {
        FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(timeOutDuration))
                .pollingEvery(Duration.ofSeconds(pollingEvery))
                .withMessage("Still W8 :)")
                .ignoring(NoSuchMethodException.class);

        WebElement elementForFluentWait = fluentWait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver webDriver) {
                WebElement elementWaiter = webDriver.findElement(locatingElement);
                String textFromElement = elementWaiter.getText();
                if (textFromElement.equals(expText)) {
                    System.out.println("Got the text: " + textFromElement);
                    return elementWaiter;
                } else {
//                    System.out.println("Could not find the title, something wrong");
                    return null;
                }
            }
        });
    }


    public static void fileUploader(WebDriver driver, By locatingElement, String pathOfFile, int timeOutDuration) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutDuration);
        WebElement elementForFluentWaitMethod2 =
                wait.until(ExpectedConditions.presenceOfElementLocated(locatingElement));
        elementForFluentWaitMethod2.sendKeys(pathOfFile);
    }

    public static void multipleDropDownMethod(WebDriver driver, By locatingElement, String... inputsForDropDown) {
        List<WebElement> webElement = driver.findElements(locatingElement);
        int elementCount = webElement.size();
        System.out.println("Size of DropDown menu: " + elementCount);
        for (int i = 0; i < elementCount; i++) {
            String elementText = webElement.get(i).getText();
            for (int j = 0; j < inputsForDropDown.length; j++) {
                try {
                    if (elementText != null) {
                        if (elementText.equals(inputsForDropDown[j])) {
                            webElement.get(i).click();
                            System.out.println("You chose following from drop down: " + webElement.get(i).getText());
//                        webElement.add(webElement.get(i));
                            break;
                        }
                    }
                } catch (Exception e) {
                    System.out.println("There is some problem while choosing from DropDown menu!!!: " + e.getMessage() + " Exception is: " + e.getCause());
                    e.printStackTrace();
                }
            }
        }
    }
}

