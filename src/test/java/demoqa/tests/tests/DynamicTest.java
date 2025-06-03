package demoqa.tests.tests;

import demoqa.pages.DynamicPage;
import demoqa.tests.base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DynamicTest extends BaseTest {

    private DynamicPage page;

    @BeforeEach
    public void openDynamicPropertiesPage(){
        driver.get("https://demoqa.com/dynamic-properties");
        page = new DynamicPage(driver);
    }

    @Test
    @Story("Check color changes dynamically")
    @Severity(SeverityLevel.MINOR)
    @Description("Waits until the button color changes and verifies it.")
    public void testColorChange() {
        DynamicPage page = new DynamicPage(driver);

        String initialColor = page.getInitialBtnColor();
        page.waitBtnColorChange(initialColor);
        String newColor = page.getNewBtnColor();

        Assertions.assertNotEquals(initialColor, newColor, "Button color did not change.");
    }

    @Test
    @Story("Check delayed button appearance")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Waits for the button to appear after 5 seconds and asserts its visibility.")
    public void testVisibleAfterFiveSecondsButton() {
        DynamicPage page = new DynamicPage(driver);

        page.waitForVisibleBtn();

        Assertions.assertTrue(page.isVisibleAfterFiveSecBtnDisplayed(),
                "The 'Visible After 5 Seconds' button did not appear as expected.");
    }


}
