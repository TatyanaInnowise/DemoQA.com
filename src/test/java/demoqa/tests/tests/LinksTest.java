package demoqa.tests.tests;

import demoqa.pages.LinksPage; // ✅ импортируй Page Object
import demoqa.pages.WebTablePage;
import demoqa.tests.base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LinksTest extends BaseTest {

    private LinksPage linksPage;

    @BeforeEach
    public void openLinksPage() {
        driver.get("https://demoqa.com/links");
        linksPage = new LinksPage(driver); //
    }

    @Test
    public void testClickBadRequestLink() {
        LinksPage page = new LinksPage(driver);
        page.clickBadRequestLink();

        String statusText = page.showStatusText();

        Assertions.assertTrue(
                statusText.contains("400 and status text Bad Request"),
                "Expected: " + statusText);
    }

    @Test
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




