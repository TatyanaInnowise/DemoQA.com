package demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BrokenLinksPage {
    private By validLink = By.xpath("//a[text()='Click Here for Valid Link']");
    private By brokenLink = By.xpath("//a[text()='Click Here for Broken Link']");

    private WebDriver driver;

    public BrokenLinksPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickValidLink(){
        driver.findElement(validLink).click();
    }

    public void clickBrokenLink(){
        driver.findElement(brokenLink).click();
    }




}
