package demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class TextBoxPage {
    private By fullNameField = By.id("userName");
    private By emailField = By.id("userEmail");
    private By currentAddressField = By.id("currentAddress");
    private By permanentAddressField = By.id("permanentAddress");
    private By submitButton = By.id("submit");
    private By confirmationBlock = By.xpath("//div[@class='border col-md-12 col-sm-12']");

    private WebDriver driver;

    public TextBoxPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterFullName(String name) {
        driver.findElement(fullNameField).sendKeys(name);
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterCurrentAddress(String address) {
        driver.findElement(currentAddressField).sendKeys(address);
    }

    public void enterPermanentAddress(String address) {
        driver.findElement(permanentAddressField).sendKeys(address);
    }


    //method clickSubmit was done with gpt, because ad hided Submit button (ElementClickInterceptedException)
    public void clickSubmit() {
        WebElement submitBtn = driver.findElement(submitButton);

        // Удалить рекламу, если она перекрывает кнопку
        ((JavascriptExecutor) driver).executeScript(
                "const ad = document.getElementById('adplus-anchor'); if (ad) ad.remove();"
        );

        // Прокрутка к кнопке
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitBtn);

        // Явное ожидание, пока кнопка станет кликабельной
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));

        // Клик по кнопке через JavaScript
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitBtn);
    }

    public String showConfirmationBlock() {
        return driver.findElement(confirmationBlock).getText();
    }


}







