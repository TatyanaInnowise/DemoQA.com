package demoqa.tests;

import base.BaseTest;
import demoqa.pages.CheckBoxPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CheckBoxTest extends BaseTest {


    @BeforeEach
    public void openCheckboxPage() {
        driver.get("https://demoqa.com/checkbox");
    }
        @Test
        public void selectAllChildCheckboxes(){

            CheckBoxPage checkBoxPage3 = new CheckBoxPage(driver);
            checkBoxPage3.clickCollapseBtn();
            checkBoxPage3.clickCheckboxBoss();

            Assertions.assertTrue(checkBoxPage3.areChildCheckboxesChecked(), "Not all checkboxes are selected");
        }

        @Test
        public void deselectParentDeselectedChildren(){
            CheckBoxPage checkBoxPage4 = new CheckBoxPage(driver);



        }




}


