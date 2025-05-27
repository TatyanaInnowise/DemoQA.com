package demoqa.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;


public class CheckBoxPage {
    private By collapseArrow = By.xpath("//label[@for='tree-node-home']/preceding-sibling::button");
    private By checkboxBoss = By.xpath("//span[text()='Desktop']/preceding-sibling::span");
    private By listOfChilds = By.xpath("//label[@for='tree-node-home']/ancestor::li/ol/li");
    private By checkedChildCheckboxes = By.xpath("//span[contains(@class,'rct-checkbox')]//svg[contains(@class,'check')]");
    private By allChildCheckboxes = By.xpath("//label[@for='tree-node-home']/ancestor::li/ol//span[@class='rct-checkbox']");
    private By allChildCheckboxIcons = By.xpath("//label[@for='tree-node-home']/ancestor::li//ol//span[@class='rct-checkbox']/svg");

    private WebDriver driver;

    public CheckBoxPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCollapseBtn() {
        driver.findElement(collapseArrow).click();
    }

    public void clickCheckboxBoss() {
        driver.findElement(checkboxBoss).click();
    }

    public boolean areChildCheckboxesChecked() {
        List<WebElement> checkboxes = driver.findElements(allChildCheckboxIcons);
        for (WebElement checkbox : checkboxes) {
            String iconClass = checkbox.getAttribute("class");
            if (!iconClass.contains("check")) {
                return false;
            }
        }
        return true;
    }

}


