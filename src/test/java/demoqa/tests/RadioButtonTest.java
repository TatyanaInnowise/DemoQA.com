package demoqa.tests;

import base.BaseTest;
import demoqa.pages.RadioButtonPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RadioButtonTest extends BaseTest {

    @BeforeEach
    public void openRadioBtnPage() {
        driver.get("https://demoqa.com/radio-button");
    }

    @Test
    public void clickYesRadioBtn() {
        RadioButtonPage radioButtonPage5 = new RadioButtonPage(driver);

        radioButtonPage5.ClickYesRadioBtn();
        Assertions.assertEquals("Yes", radioButtonPage5.GetConfirmationText());
    }

    @Test
    public void clickImpressiveRadioBtn() {
        RadioButtonPage radioButtonPage6 = new RadioButtonPage(driver);

        radioButtonPage6.ClickImpressiveRadioBtn();
        Assertions.assertEquals("Impressive", radioButtonPage6.GetConfirmationText());
    }
}





