package demoqa.tests.tests;

import demoqa.tests.base.BaseTest;
import demoqa.pages.ButtonsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import io.qameta.allure.*;


@Epic("DemoQA Buttons")
@Feature("Handling Different Click Types")
@Severity(SeverityLevel.CRITICAL)
public class ButtonsTest extends BaseTest {

    @BeforeEach
    public void openButtonsPage() {
        driver.get("https://demoqa.com/buttons");
    }


    @Test
    @Story("Double click on button")
    @Description("Verifies that a double-click on the button displays the correct message")
    @Severity(SeverityLevel.NORMAL)

    public void clickDoubleClickMeBtn() {
        ButtonsPage buttonPage7 = new ButtonsPage(driver);
        buttonPage7.doubleClick();

        Assertions.assertEquals("You have done a double click", buttonPage7.checkDoubleClickMsg());
    }

    @Test
    @Story("Single click on right-click button")
    @Description("Verifies that a normal click on the 'Right Click Me' button does not display the context message")
    @Severity(SeverityLevel.MINOR)

    public void normalClickOnRightClickBtn() {
        ButtonsPage buttonPage8 = new ButtonsPage(driver);
        buttonPage8.normalClickOnRightClickBtn();

        Assertions.assertFalse(buttonPage8.isRightClickMsgShown());
    }


}
