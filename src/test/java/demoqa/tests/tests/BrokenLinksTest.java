package demoqa.tests.tests;

import demoqa.pages.BrokenLinksPage;
import demoqa.tests.base.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


@Epic("DemoQA Broken Links")
@Feature("Valid and Broken Link Checks")
public class BrokenLinksTest extends BaseTest {

    private BrokenLinksPage brokenLinksPage;

    @BeforeEach
    public void openBrokenLinksPage() {
        driver.get("https://demoqa.com/broken");
        brokenLinksPage = new BrokenLinksPage(driver);
    }

    @Test
    @Story("Click valid link and check if navigation is correct")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Clicks the valid link and asserts that the redirected URL matches the expected one.")
    public void isPageNotBroken() {
        brokenLinksPage.clickValidLink();


        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        String expectedUrl = "https://demoqa.com/";
        String actualUrl = driver.getCurrentUrl();

        Assertions.assertEquals(expectedUrl, actualUrl, "URLs do not match");
    }

    @Test
    @Story("Click broken link and verify error handling")
    @Severity(SeverityLevel.NORMAL)
    @Description("Clicks the broken link and asserts that the redirected URL is not equal to the expected home page URL.")

    public void isPageBroken() {
        brokenLinksPage.clickBrokenLink();

        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        String unexpectedUrl = "https://demoqa.com/";
        String actualUrl = driver.getCurrentUrl();

        Assertions.assertNotEquals(unexpectedUrl, actualUrl, "Broken link unexpectedly redirected to the home page.");
    }

}




