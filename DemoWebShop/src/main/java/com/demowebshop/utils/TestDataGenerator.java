package com.demowebshop.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * TestDataGenerator - Utility to generate Excel test data files.
 * Creates DemoWebShopTestData.xlsx with LoginData and RegistrationData sheets.
 * Run this class once to generate test data before executing tests.
 *
 * @author DemoWebShop Automation Team
 * @version 1.0
 */
public class TestDataGenerator {

    private static final Logger logger = LogManager.getLogger(TestDataGenerator.class);
    private static final String FILE_PATH = "./src/main/resources/TestData/DemoWebShopTestData.xlsx";

    /**
     * Main method - Generates the Excel test data file.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        generateTestData();
    }

    /**
     * Generates the DemoWebShopTestData.xlsx file with all required test data sheets.
     */
    public static void generateTestData() {
        logger.info("Generating DemoWebShop test data Excel file");

        XSSFWorkbook workbook = new XSSFWorkbook();

        createLoginDataSheet(workbook);
        createRegistrationDataSheet(workbook);

        try {
            File file = new File(FILE_PATH);
            File parentDir = file.getParentFile();
            if (!parentDir.exists()) {
                parentDir.mkdirs();
            }

            FileOutputStream fos = new FileOutputStream(file);
            workbook.write(fos);
            fos.close();
            workbook.close();

            logger.info("Test data Excel file generated successfully: {}", FILE_PATH);
            System.out.println("DemoWebShopTestData.xlsx generated successfully at: " + FILE_PATH);
        } catch (IOException e) {
            logger.error("Failed to generate test data file: {}", e.getMessage());
            System.err.println("Error generating test data: " + e.getMessage());
        }
    }

    /**
     * Creates the LoginData sheet with test credentials.
     *
     * @param workbook the workbook to add the sheet to
     */
    private static void createLoginDataSheet(XSSFWorkbook workbook) {
        XSSFSheet sheet = workbook.createSheet("LoginData");

        String[][] loginData = {
                {"Email", "Password", "ExpectedResult"},
                {"test@test.com", "Password@123", "success"},
                {"invalid@test.com", "WrongPassword", "failure"},
                {"admin@demowebshop.com", "Admin@123", "success"},
                {"user@invalid.com", "", "failure"},
                {"", "Password@123", "failure"}
        };

        for (int i = 0; i < loginData.length; i++) {
            XSSFRow row = sheet.createRow(i);
            for (int j = 0; j < loginData[i].length; j++) {
                XSSFCell cell = row.createCell(j);
                cell.setCellValue(loginData[i][j]);
            }
        }

        for (int i = 0; i < 3; i++) {
            sheet.autoSizeColumn(i);
        }

        logger.info("LoginData sheet created with {} data rows", loginData.length - 1);
    }

    /**
     * Creates the RegistrationData sheet with test registration data.
     *
     * @param workbook the workbook to add the sheet to
     */
    private static void createRegistrationDataSheet(XSSFWorkbook workbook) {
        XSSFSheet sheet = workbook.createSheet("RegistrationData");

        String[][] registrationData = {
                {"Gender", "FirstName", "LastName", "Email", "Password", "ExpectedResult"},
                {"Male", "John", "Doe", "john.doe@test.com", "Password@123", "success"},
                {"Female", "Jane", "Smith", "jane.smith@test.com", "SecurePass@456", "success"},
                {"Male", "Test", "User", "test.user@test.com", "TestPass@789", "success"},
                {"Female", "Demo", "Account", "demo@test.com", "Demo@1234", "success"}
        };

        for (int i = 0; i < registrationData.length; i++) {
            XSSFRow row = sheet.createRow(i);
            for (int j = 0; j < registrationData[i].length; j++) {
                XSSFCell cell = row.createCell(j);
                cell.setCellValue(registrationData[i][j]);
            }
        }

        for (int i = 0; i < 6; i++) {
            sheet.autoSizeColumn(i);
        }

        logger.info("RegistrationData sheet created with {} data rows", registrationData.length - 1);
    }
}
