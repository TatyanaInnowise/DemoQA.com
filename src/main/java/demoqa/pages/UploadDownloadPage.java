package demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class UploadDownloadPage {

    public By uploadBtn = By.id("uploadFile");
    public By downloadBtn = By.id("downloadButton");

    private WebDriver driver;

    public UploadDownloadPage(WebDriver driver) {
        this.driver = driver;
    }

    public void downloadFile() {
        driver.findElement(downloadBtn).click();
    }

    public void uploadFile() {
        driver.findElement(uploadBtn).sendKeys("/Users/tanya/Downloads/sampleFile.jpeg");
    }

    public boolean waitForFileDownload(String filePath, int timeoutInSeconds) {
        File file = new File(filePath);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(d -> file.exists());
    }

    public boolean waitForUploadConfirmation(int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uploadedFilePath"))).isDisplayed();
    }

    public String getUploadedFileName() {
        return driver.findElement(By.id("uploadedFilePath")).getText();
    }
}
