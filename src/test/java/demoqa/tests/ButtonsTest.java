package demoqa.tests;

import base.BaseTest;
import demoqa.pages.ButtonsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ButtonsTest extends BaseTest {

    @BeforeEach
    public void openButtonsPage() {
        driver.get("https://demoqa.com/buttons");
    }

    @Test
    public void clickDoubleClickMeBtn() {
        ButtonsPage buttonPage7 = new ButtonsPage(driver);
        buttonPage7.doubleClick();

        Assertions.assertEquals("You have done a double click", buttonPage7.checkDoubleClickMsg());
    }

    @Test
    public void normalClickOnRightClickBtn() {
        ButtonsPage buttonPage8 = new ButtonsPage(driver);
        buttonPage8.normalClickOnRightClickBtn();

        Assertions.assertFalse(buttonPage8.isRightClickMsgShown());
    }


}
