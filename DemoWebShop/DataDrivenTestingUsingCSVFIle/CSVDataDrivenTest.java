package com.demowebshop.tests;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.demowebshop.base.BaseClass;
import com.demowebshop.pages.LoginPage;
import com.demowebshop.pages.HomePage;
import com.demowebshop.utils.CSVReaderUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("DemoWebShop Automation")
@Feature("Data Driven - CSV")
public class CSVDataDrivenTest extends BaseClass {

    private static final Logger logger = LogManager.getLogger(CSVDataDrivenTest.class);
    private static final String CSV_FILE_PATH = "./src/main/resources/TestData/LoginData.csv";

    @Test(priority = 1)
    @Story("CSV Data Driven Login")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify login with multiple credentials from CSV file")
    public void verifyLoginWithCSVData() {
        logger.info("Starting verifyLoginWithCSVData test");

        HomePage homePage = new HomePage(driver);
        homePage.goToLogin();

        List<String[]> csvData = CSVReaderUtil.readCSVDataWithoutHeader(CSV_FILE_PATH);
        logger.info("Total CSV data rows: {}", csvData.size());

        for (int i = 0; i < csvData.size(); i++) {
            String[] row = csvData.get(i);
            String email = row[0];
            String password = row[1];
            String expectedResult = row[2];

            logger.info("Testing CSV row {}: email={}, expected={}", i + 1, email, expectedResult);

            LoginPage loginPage = new LoginPage(driver);

            try {
                HomePage resultPage = loginPage.login(email == null ? "" : email, password == null ? "" : password);
                if (expectedResult.equalsIgnoreCase("success")) {
                    Assert.assertTrue(resultPage.isUserLoggedIn(), "User should be logged in");
                    resultPage.logout();
                } else {
                    Assert.fail("Login should have failed for invalid credentials - Row " + (i + 1));
                }
            } catch (Exception e) {
                if (expectedResult.equalsIgnoreCase("success")) {
                    throw e;
                } else {
                    Assert.assertTrue(loginPage.isLoginErrorDisplayed(),
                            "Error message should display for invalid credentials - Row " + (i + 1));
                    logger.info("Login failed as expected for row {}", i + 1);
                }
            }

            driver.navigate().to(config.getUrl() + "login");
            logger.info("Navigated back to login page for next iteration");
        }

        logger.info("CSV data driven login test - COMPLETED");
    }

    @Test(priority = 2)
    @Story("CSV Row Count Verification")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify CSV file has expected number of data rows")
    public void verifyCSVRowCount() {
        logger.info("Starting verifyCSVRowCount test");

        int totalRows = CSVReaderUtil.getRowCount(CSV_FILE_PATH);
        logger.info("Total rows in CSV (including header): {}", totalRows);

        Assert.assertTrue(totalRows > 1,
                "CSV file should have at least one data row besides header");
        logger.info("CSV row count verification test - PASSED");
    }

    @Test(priority = 3)
    @Story("CSV First Row Login")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify login with first data row from CSV")
    public void verifyFirstRowLogin() {
        logger.info("Starting verifyFirstRowLogin test");

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.goToLogin();

        String[] firstRow = CSVReaderUtil.getRow(CSV_FILE_PATH, 1);

        Assert.assertTrue(firstRow.length >= 3, "CSV row should have at least 3 columns");

        String email = firstRow[0];
        String password = firstRow[1];

        logger.info("Login attempt with first CSV row: {}", email);

        loginPage.login(email, password);

        String title = driver.getTitle();
        Assert.assertNotNull(title, "Page should load after login attempt");
        logger.info("First row login test - PASSED");
    }
}
