package demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LinksPage {
    private By badRequestLink = By.id("bad-request");
    private By newTabLink = By.id("simpleLink");
    private By statusText = By.id("linkResponse");


    private WebDriver driver;

    public LinksPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickBadRequestLink() {
        driver.findElement(badRequestLink).click();
    }

    public String showStatusText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(statusText));

        return driver.findElement(statusText).getText();
    }

    public void clickHomeLink() {
        driver.findElement(newTabLink).click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }


}








