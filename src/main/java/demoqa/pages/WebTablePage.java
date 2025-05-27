package demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebTablePage {
    private By addBtn = By.id("addNewRecordButton");

    private By firstName = By.id("firstName");
    private By lastName = By.id("lastName");
    private By email = By.id("userEmail");
    private By age = By.id("age");
    private By salary = By.id("salary");
    private By department = By.id("department");

    private By submitBtn = By.id("submit");

    private By table = By.xpath("//div[@class='rt-tbody']");

    private By deleteBtn = By.id("delete-record-2");


    private WebDriver driver;

    public WebTablePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddBtn() {
        driver.findElement(addBtn).click();
    }

    public void addDataToTable() {
        WebElement input1 = driver.findElement(firstName);
        input1.click();
        input1.sendKeys("John");

        WebElement input2 = driver.findElement(lastName);
        input2.click();
        input2.sendKeys("Doe");

        WebElement input3 = driver.findElement(email);
        input3.click();
        input3.sendKeys("john@gmail.com");

        WebElement input4 = driver.findElement(age);
        input4.click();
        input4.sendKeys("22");

        WebElement input5 = driver.findElement(salary);
        input5.click();
        input5.sendKeys("100500");

        WebElement input6 = driver.findElement(department);
        input6.click();
        input6.sendKeys("AQA");
    }

    public void clickSubmitBtn() {
        driver.findElement(submitBtn).click();
    }

    public String tableData() {
        return driver.findElement(table).getText();
    }

    public void deleteBtnClick() {
        driver.findElement(deleteBtn).click();
    }
}

