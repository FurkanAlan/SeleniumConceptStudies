package SeleniumMetodlarim.class14_ActionClass;

import SeleniumMetodlarim.Util.ElementUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ders1_DragDrop {
    public static void main(String[] args) {
        //setup browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = null;

        driver = ElementUtil.browserLauncher(driver, "chrome");

        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        By dragItem = By.id("column-a");
        By dropItem = By.id("column-b");

        WebElement itemToDrag = driver.findElement(dragItem);
        WebElement itemToDrop = driver.findElement(dropItem);

        Actions actions = new Actions(driver);
        actions.dragAndDrop(itemToDrag,itemToDrop).build().perform();
//        actions.dragAndDrop(itemToDrag,itemToDrop).release().build().perform();
//        actions.clickAndHold(itemToDrag).moveToElement(itemToDrop).release().build().perform();


        System.out.println("##################### the title ##########################");
        System.out.println(driver.getTitle());


        //tearDown
        ElementUtil.slpBrowser(2000);
        ElementUtil.qBrowser(driver);
    }

}
