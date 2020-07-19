package SeleniumMetodlarim.class6_MultipleChoiceDropDOwn;

import SeleniumMetodlarim.Util.ElementUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ders2_MultipleDropDownMethod {
    public static void main(String[] args) {
        //setup browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = null;
        driver = ElementUtil.browserLauncher(driver, "chrome");
        driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
        //xpath: //span[@class='comboTreeItemTitle']

        driver.findElement(By.id("justAnInputBox")).click();
        By elementsOfDropDown = By.className("comboTreeItemTitle");

        //finding elements
        List<WebElement> multElements = driver.findElements(By.className("comboTreeItemTitle"));
        int elementCount = multElements.size();
        System.out.println(elementCount);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ With Method ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        multipleDropDownMethod(driver, elementsOfDropDown, "choice 6 1", "choice 6 2", "choice 5", "choice 1");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");


        //tearDown
        ElementUtil.slpBrowser(2000);
        ElementUtil.qBrowser(driver);
    }

    public static void multipleDropDownMethod(WebDriver driver, By locatingElement, String... inputsForDropDown) {
        List<WebElement> webElement = driver.findElements(locatingElement);
        int elementCount = webElement.size();
        System.out.println("Size of DropDown menu: " + elementCount);
        for (int i = 0; i < elementCount; i++) {
            String elementText = webElement.get(i).getText();
            for (int j = 0; j < inputsForDropDown.length; j++) {
                if (elementText != null) {
                    if (elementText.equals(inputsForDropDown[j])) {
                        webElement.get(i).click();
                        System.out.println("You chose following from drop down: " + webElement.get(i).getText());
//                        webElement.add(webElement.get(i));
                        break;
                    }
                }
            }
        }
    }
}

class MultipleDropDownMethod {
    public static void multipleDropDownMethod(WebDriver driver, By locatingElement, String... inputsForDropDown) {
        List<WebElement> webElements = driver.findElements(locatingElement);
        int elementCount = webElements.size();
        System.out.println("Size of DropDown menu: " + elementCount);
        for (WebElement elements : webElements) {
            String elementText = elements.getText();
            for (String s : inputsForDropDown) {
                if (elementText != null) {
                    if (elementText.equals(s)) {
                        elements.click();
                        System.out.println("You chose following from drop down: " + elements.getText());
//                        webElement.add(webElement.get(i));
                        break;
                    }
                }
            }
        }
    }
}
