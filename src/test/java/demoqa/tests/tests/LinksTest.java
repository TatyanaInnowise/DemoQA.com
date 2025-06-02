package demoqa.tests.tests;

import demoqa.pages.LinksPage;
import demoqa.tests.base.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@Epic("DemoQA Links")
@Feature("Link Navigation and Status Validation")
public class LinksTest extends BaseTest {

    private LinksPage linksPage;

    @BeforeEach
    public void openLinksPage() {
        driver.get("https://demoqa.com/links");
        linksPage = new LinksPage(driver);
    }
    @Test
    @Story("Verify broken link response")
    @Severity(SeverityLevel.NORMAL)
    @Description("Clicks on the 'Bad Request' link and checks that the status message contains the expected 400 response.")
    @DisplayName("Check status after clicking 'Bad Request' link")

    public void testClickBadRequestLink() {
        LinksPage page = new LinksPage(driver);
        page.clickBadRequestLink();

        String statusText = page.showStatusText();

        Assertions.assertTrue(
                statusText.contains("400 and status text Bad Request"),
                "Expected: " + statusText);
    }
    @Test
    @Story("Check redirection to Home page")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Clicks on the 'Home' link, switches to the new tab, and verifies the redirection URL.")
    @DisplayName("Verify URL after clicking 'Home' link")

    public void compareUrls() {
        LinksPage page = new LinksPage(driver);
        page.clickHomeLink();

        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }


        String expectedUrl = "https://demoqa.com/";
        String actualUrl = page.getCurrentUrl();

        Assertions.assertEquals(expectedUrl, actualUrl, "URLs do not match");
    }

}




