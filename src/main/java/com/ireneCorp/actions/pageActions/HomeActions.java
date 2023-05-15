package com.ireneCorp.actions.pageActions;

import com.ireneCorp.actions.base.BaseActions;

import org.apache.commons.compress.utils.OsgiUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

public class HomeActions extends BaseActions {
    public void Logout() {
        homePage.button_BurgerMenu().click();
        homePage.link_LogOut().click();
        Assert.assertTrue(loginPage.login_Page().isDisplayed());
    }

    public void ItemsList() {
        List<String> expectedItems = new ArrayList<>();
        expectedItems.add("Sauce Labs Backpack");
        expectedItems.add("Sauce Labs Bike Light");
        expectedItems.add("Sauce Labs Bolt T-Shirt");
        expectedItems.add("Sauce Labs Fleece Jacket");
        expectedItems.add("Sauce Labs Onesie");
        expectedItems.add("Test.allTheThings() T-Shirt (Red)");

        String textExpected = null;
        String textActual = null;
        for (String i : expectedItems) {
            textExpected = i;
        }
        for (WebElement j : homePage.list_OfItems()) {
            textActual = j.getText();
        }
        Assert.assertEquals(textActual, textExpected);
    }

    public void Item_PriceCheck() {
        try {
            // Taking data from Excel.
            File file = new File("src/test/resources/testData/SwagLabItemDetails.xlsx");
            FileInputStream fileInput = new FileInputStream(file);
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInput);
            XSSFSheet sheet = xssfWorkbook.getSheetAt(0);

            Map<String, String> map = new LinkedHashMap<>();

            for (int i = 1; i <=homePage.list_OfItems().size(); i++) {
                String ItemName = null;
                String Price = null;

                for (int j = 0; j <= 1; j++) {
                    Row row = sheet.getRow(i);
                    Cell cell = row.getCell(j);
                    if (j == 0) {
                        ItemName = cell.getStringCellValue();
                    } else {
                        Price = cell.getStringCellValue();
                    }
                    map.put(ItemName, Price);
                }
            }

            // Taking data from Web Application.
            Map<String, String> items_PriceMap = new LinkedHashMap<>();
            for (int i = 0; i <homePage.list_OfPrice().size(); i++) {
                items_PriceMap.put(homePage.list_OfItems().get(i).getText(),
                        homePage.list_OfPrice().get(i).getText());
            }

            Assert.assertTrue(map.equals(items_PriceMap));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

