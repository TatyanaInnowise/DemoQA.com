package demoqa.tests.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Test;
import demoqa.tests.base.BaseTest;
import demoqa.pages.TextBoxPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.jupiter.api.BeforeEach;

@Epic("DemoQA Text Box")
@Feature("Form Submission and Validation")
public class TextBoxTest extends BaseTest {

    @BeforeEach
    public void openTextBoxPage() {
        driver.get("https://demoqa.com/text-box");
    }

    @Test
    @Story("Submit form with valid data")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Fills in all form fields with valid data and verifies that the confirmation block displays correct values.")

    public void sendForm() {

        TextBoxPage textBoxPage = new TextBoxPage(driver);

        textBoxPage.enterFullName("John Doe");
        textBoxPage.enterEmail("john.doe@example.com");
        textBoxPage.enterCurrentAddress("123 Abc St");
        textBoxPage.enterPermanentAddress("456 Def St");
        textBoxPage.clickSubmit();

        textBoxPage.showConfirmationBlock();

        Assertions.assertTrue(textBoxPage.showConfirmationBlock().contains("John Doe"));
        Assertions.assertTrue(textBoxPage.showConfirmationBlock().contains("john.doe@example.com"));
        Assertions.assertTrue(textBoxPage.showConfirmationBlock().contains("123 Abc St"));
        Assertions.assertTrue(textBoxPage.showConfirmationBlock().contains("456 Def St"));

    }

    @Test
    @Story("Validation error on invalid email")
    @Severity(SeverityLevel.NORMAL)
    @Description("Tries to submit the form with an invalid email and checks that the email field shows an error.")

    public void errorForInvalidEmail() {

        TextBoxPage textBoxPage = new TextBoxPage(driver);

        textBoxPage.enterFullName("John Doe");
        textBoxPage.enterEmail("john.doe");
        textBoxPage.enterCurrentAddress("123 Abc St");
        textBoxPage.enterPermanentAddress("456 Def St");

        textBoxPage.clickSubmit();

        WebElement emailField = driver.findElement(By.id("userEmail"));
        String classAttribute = emailField.getAttribute("class");
        Assertions.assertTrue(classAttribute.contains("field-error"));
    }
}






