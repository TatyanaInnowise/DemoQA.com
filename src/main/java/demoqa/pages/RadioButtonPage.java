package demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RadioButtonPage {

    private By RadioBtnYes = By.xpath("//label[@for='yesRadio']");
    private By RadioBtnImpressive = By.xpath("//label[@for='impressiveRadio']");
    private By ConfirmationText = By.xpath("//span[@class=text-success]");

    private WebDriver driver;

    public RadioButtonPage(WebDriver driver) {
        this.driver = driver;
    }

    public void ClickYesRadioBtn() {
        driver.findElement(RadioBtnYes).click();
    }

    public void ClickImpressiveRadioBtn() {
        driver.findElement(RadioBtnImpressive).click();
    }

    public String GetConfirmationText() {
        return driver.findElement(ConfirmationText).getText();
    }

}
