package com.demowebshop.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.demowebshop.base.BaseClass;
import com.demowebshop.pages.HomePage;
import com.demowebshop.pages.LoginPage;
import com.demowebshop.utils.ExcelDataProvider;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("DemoWebShop Automation")
@Feature("Data Driven - Excel")
public class ExcelDataDrivenTest extends BaseClass {

    private static final Logger logger = LogManager.getLogger(ExcelDataDrivenTest.class);

    @Test(priority = 1)
    @Story("Excel Data Driven Login")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify login with credentials from Excel file - LoginData sheet")
    public void verifyLoginWithExcelData() {
        logger.info("Starting verifyLoginWithExcelData test");

        HomePage homePage = new HomePage(driver);
        homePage.goToLogin();

        ExcelDataProvider excel = new ExcelDataProvider();

        int rowCount = excel.getRowCount("LoginData");
        logger.info("Total rows in LoginData sheet: {}", rowCount);

        for (int i = 1; i < rowCount; i++) {
            String email = excel.getStringData("LoginData", i, 0);
            String password = excel.getStringData("LoginData", i, 1);
            String expectedResult = excel.getStringData("LoginData", i, 2);

            logger.info("Testing Excel row {}: email={}, expected={}", i, email, expectedResult);

            LoginPage loginPage = new LoginPage(driver);

            try {
                HomePage resultPage = loginPage.login(email == null ? "" : email, password == null ? "" : password);
                if (expectedResult.equalsIgnoreCase("success")) {
                    Assert.assertTrue(resultPage.isUserLoggedIn(), "User should be logged in");
                    resultPage.logout();
                    logger.info("Excel row {} login successful", i);
                } else {
                    Assert.fail("Login should have failed for invalid credentials - Row " + i);
                }
            } catch (Exception e) {
                if (expectedResult.equalsIgnoreCase("success")) {
                    throw e;
                } else {
                    Assert.assertTrue(loginPage.isLoginErrorDisplayed(),
                            "Error should display for invalid credentials - Row " + i);
                    logger.info("Excel row {} login failed as expected", i);
                }
            }

            driver.navigate().to(config.getUrl() + "login");
        }

        logger.info("Excel data driven login test - COMPLETED");
    }

    @Test(priority = 2)
    @Story("Excel Single Row Login")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify login with first row of Excel data")
    public void verifyLoginWithFirstExcelRow() {
        logger.info("Starting verifyLoginWithFirstExcelRow test");

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.goToLogin();

        ExcelDataProvider excel = new ExcelDataProvider();

        String user = excel.getStringData("LoginData", 1, 0);
        String pass = excel.getStringData("LoginData", 1, 1);

        logger.info("Login attempt with Excel row 1: {}", user);

        homePage = loginPage.login(user, pass);

        String title = driver.getTitle();
        logger.info("Page Title: {}", title);

        Assert.assertTrue(homePage.isUserLoggedIn(),
                "User should be logged in with first Excel row data");
        logger.info("First Excel row login test - PASSED");
    }

    @Test(priority = 3)
    @Story("Excel Sheet Metadata")
    @Severity(SeverityLevel.MINOR)
    @Description("Verify Excel sheet row and column counts")
    public void verifyExcelSheetMetadata() {
        logger.info("Starting verifyExcelSheetMetadata test");

        ExcelDataProvider excel = new ExcelDataProvider();

        int rowCount = excel.getRowCount("LoginData");
        int colCount = excel.getColumnCount("LoginData");

        logger.info("LoginData - Rows: {}, Columns: {}", rowCount, colCount);

        Assert.assertTrue(rowCount > 1, "Sheet should have data rows");
        Assert.assertTrue(colCount >= 3, "Sheet should have at least 3 columns (Email, Password, Expected)");
        logger.info("Excel sheet metadata test - PASSED");
    }

    @Test(priority = 4)
    @Story("Excel Cell Data Types")
    @Severity(SeverityLevel.MINOR)
    @Description("Verify getCellData method handles different cell types")
    public void verifyCellDataReading() {
        logger.info("Starting verifyCellDataReading test");

        ExcelDataProvider excel = new ExcelDataProvider();

        String cellData = excel.getCellData("LoginData", 1, 0);
        logger.info("Cell data at (1,0): {}", cellData);

        Assert.assertNotNull(cellData, "Cell data should not be null");
        Assert.assertFalse(cellData.isEmpty(), "Cell data should not be empty");
        logger.info("Cell data reading test - PASSED");
    }
}
