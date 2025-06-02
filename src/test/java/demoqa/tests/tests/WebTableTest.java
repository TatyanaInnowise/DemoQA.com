package demoqa.tests.tests;

import demoqa.pages.WebTablePage;
import demoqa.tests.base.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


@Epic("DemoQA Web Tables")
@Feature("Adding and Deleting Table Rows")
public class WebTableTest extends BaseTest {

    @BeforeEach
    public void webTablePage() {
        driver.get("https://demoqa.com/webtables");
    }

    @Test
    @Story("Add new record to the table")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Fills out the form with user data, submits it, and verifies that the new entry appears in the table.")

    public void addDataToTable() {
        WebTablePage page = new WebTablePage(driver);

        page.clickAddBtn();
        page.addDataToTable();
        page.clickSubmitBtn();

        String tableText = page.tableData();

        Assertions.assertTrue(tableText.contains("John"));
        Assertions.assertTrue(tableText.contains("Doe"));
        Assertions.assertTrue(tableText.contains("john@gmail.com"));
        Assertions.assertTrue(tableText.contains("22"));
        Assertions.assertTrue(tableText.contains("100500"));
        Assertions.assertTrue(tableText.contains("AQA"));
    }


    @Test
    @Story("Delete record from the table")
    @Severity(SeverityLevel.NORMAL)
    @Description("Deletes a row by name and verifies that it no longer appears in the table.")

    public void deleteRowFromTable() {
        WebTablePage page2 = new WebTablePage(driver);

        Assertions.assertTrue(page2.tableData().contains("Alden"), "No 'Alden' found before deletion");

        page2.deleteBtnClick();

        Assertions.assertFalse(page2.tableData().contains("Alden"), "row with name 'Alden' not deleted");

    }

}


