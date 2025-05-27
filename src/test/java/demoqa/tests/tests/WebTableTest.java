package demoqa.tests.tests;

import demoqa.pages.WebTablePage;
import demoqa.tests.base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WebTableTest extends BaseTest {

    @BeforeEach
    public void webTablePage() {
        driver.get("https://demoqa.com/webtables");
    }

    @Test
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
    public void deleteRowFromTable() {
        WebTablePage page2 = new WebTablePage(driver);

        Assertions.assertTrue(page2.tableData().contains("Alden"), "No 'Alden' found before deletion");

        page2.deleteBtnClick();

        Assertions.assertFalse(page2.tableData().contains("Alden"), "row with name 'Alden' not deleted");

    }

}


