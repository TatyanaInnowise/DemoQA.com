package demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicPage {
    private final By visibleAfterFiveSecBtn = By.id("visibleAfter");
    private final By colorChangeBtn = By.id("colorChange");

    private final WebDriver driver;

    public DynamicPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getInitialBtnColor() {
        return driver.findElement(colorChangeBtn).getCssValue("color");
    }

    public String getNewBtnColor() {
        return driver.findElement(colorChangeBtn).getCssValue("color");
    }

    public void waitBtnColorChange(String initialColor) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(d -> !d.findElement(colorChangeBtn).getCssValue("color").equals(initialColor));
    }

    public boolean isVisibleAfterFiveSecBtnDisplayed() {
        return driver.findElement(visibleAfterFiveSecBtn).isDisplayed();
    }

    public void waitForVisibleBtn() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(d -> d.findElement(visibleAfterFiveSecBtn).isDisplayed());
    }
}
