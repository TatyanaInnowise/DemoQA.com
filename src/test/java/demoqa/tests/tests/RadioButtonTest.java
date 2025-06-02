package demoqa.tests.tests;

import demoqa.tests.base.BaseTest;
import demoqa.pages.RadioButtonPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Epic("DemoQA Radio Buttons")
@Feature("Radio Button Selection")
public class RadioButtonTest extends BaseTest {

    @BeforeEach
    public void openRadioBtnPage() {
        driver.get("https://demoqa.com/radio-button");
    }


    @Test
    @Story("Select 'Yes' radio button")
    @Description("Verifies that selecting the 'Yes' radio button shows the correct confirmation text.")
    @Severity(SeverityLevel.NORMAL)

    public void clickYesRadioBtn() {
        RadioButtonPage radioButtonPage5 = new RadioButtonPage(driver);

        radioButtonPage5.ClickYesRadioBtn();
        Assertions.assertEquals("Yes", radioButtonPage5.GetConfirmationText());
    }

    @Test
    @Story("Select 'Impressive' radio button")
    @Description("Verifies that selecting the 'Impressive' radio button shows the correct confirmation text.")
    @Severity(SeverityLevel.NORMAL)

    public void clickImpressiveRadioBtn() {
        RadioButtonPage radioButtonPage6 = new RadioButtonPage(driver);

        radioButtonPage6.ClickImpressiveRadioBtn();
        Assertions.assertEquals("Impressive", radioButtonPage6.GetConfirmationText());
    }
}





