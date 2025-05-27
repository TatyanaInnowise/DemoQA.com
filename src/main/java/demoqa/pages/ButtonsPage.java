package demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ButtonsPage {
    private By doubleClickBtn = By.id("doubleClickBtn");
    private By rightClickBtn = By.id("rightClickBtn");
    private By clickBtn = By.id("i5I7J");

    private By doubleClickMsg = By.id("doubleClickMessage");
    private By rightClickMsg = By.id("rightClickMessage");
    private By clickMsg = By.id("dynamicClickMessage");

    private WebDriver driver;
    private Actions actions;

    public ButtonsPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public void doubleClick() {
        WebElement button = driver.findElement(doubleClickBtn);
        actions.doubleClick(button).perform();
    }

    public void rightClick() {
        WebElement button = driver.findElement(rightClickBtn);
        actions.contextClick(button).perform();
    }

    public void click() {
        driver.findElement(clickBtn).click();
    }

    public String checkDoubleClickMsg() {
        return driver.findElement(doubleClickMsg).getText();
    }

    public String checkRightClickMsg() {
        return driver.findElement(rightClickMsg).getText();
    }

    public String checkClickMsg() {
        return driver.findElement(clickMsg).getText();
    }

    public void normalClickOnRightClickBtn() {
        driver.findElement(rightClickBtn).click();
    }

    public boolean isRightClickMsgShown() {
        try {
            return driver.findElement(rightClickMsg).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
}
