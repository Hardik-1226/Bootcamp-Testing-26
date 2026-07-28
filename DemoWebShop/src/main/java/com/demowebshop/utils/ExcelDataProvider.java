package com.demowebshop.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * ExcelDataProvider - Reads test data from Excel (.xlsx) files using Apache POI.
 * Supports String, Numeric, Boolean, Formula and Blank cell types.
 *
 * @author DemoWebShop Automation Team
 * @version 1.0
 */
public class ExcelDataProvider {

    private static final Logger logger = LogManager.getLogger(ExcelDataProvider.class);
    private XSSFWorkbook wb;
    private XSSFSheet sheet;

    /**
     * Constructor - Loads the DemoWebShop test data Excel workbook.
     */
    public ExcelDataProvider() {
        try {
            File src = new File("./src/main/resources/TestData/DemoWebShopTestData.xlsx");
            FileInputStream fis = new FileInputStream(src);
            wb = new XSSFWorkbook(fis);
            fis.close();
            logger.info("DemoShop Test Data Workbook Loaded");
            logger.info("Total DemoShop Sheets: {}", wb.getNumberOfSheets());
            logger.info("Main Data Sheet: {}", wb.getSheetName(0));
        } catch (IOException e) {
            logger.error("Error reading DemoShop Excel data: {}", e.getMessage());
            throw new RuntimeException("Excel data file loading failed: " + e.getMessage(), e);
        }
    }

    /**
     * Constructor - Loads Excel workbook from the specified file path.
     *
     * @param filePath path to the Excel file
     */
    public ExcelDataProvider(String filePath) {
        try {
            File src = new File(filePath);
            FileInputStream fis = new FileInputStream(src);
            wb = new XSSFWorkbook(fis);
            fis.close();
            logger.info("Excel Workbook Loaded from: {}", filePath);
            logger.info("Total Sheets: {}", wb.getNumberOfSheets());
        } catch (IOException e) {
            logger.error("Error reading Excel data from {}: {}", filePath, e.getMessage());
            throw new RuntimeException("Excel data file loading failed: " + e.getMessage(), e);
        }
    }

    /**
     * Gets a string value from the specified cell.
     *
     * @param sheetName name of the sheet
     * @param row       row number (0-based)
     * @param col       column number (0-based)
     * @return cell value as String
     */
    public String getStringData(String sheetName, int row, int col) {
        logger.debug("Reading string data from sheet: {}, row: {}, col: {}", sheetName, row, col);
        try {
            sheet = wb.getSheet(sheetName);
            XSSFRow xssfRow = sheet.getRow(row);
            if (xssfRow == null) {
                logger.warn("Row {} is null in sheet {}", row, sheetName);
                return "";
            }
            XSSFCell cell = xssfRow.getCell(col);
            if (cell == null) {
                logger.warn("Cell at row {}, col {} is null in sheet {}", row, col, sheetName);
                return "";
            }
            return cell.getStringCellValue();
        } catch (Exception e) {
            logger.error("Error reading string data: {}", e.getMessage());
            return "";
        }
    }

    /**
     * Gets a numeric value from the specified cell.
     *
     * @param sheetName name of the sheet
     * @param row       row number (0-based)
     * @param col       column number (0-based)
     * @return cell value as double
     */
    public double getNumericData(String sheetName, int row, int col) {
        logger.debug("Reading numeric data from sheet: {}, row: {}, col: {}", sheetName, row, col);
        try {
            sheet = wb.getSheet(sheetName);
            XSSFRow xssfRow = sheet.getRow(row);
            if (xssfRow == null) {
                logger.warn("Row {} is null in sheet {}", row, sheetName);
                return 0.0;
            }
            XSSFCell cell = xssfRow.getCell(col);
            if (cell == null) {
                logger.warn("Cell at row {}, col {} is null in sheet {}", row, col, sheetName);
                return 0.0;
            }
            return cell.getNumericCellValue();
        } catch (Exception e) {
            logger.error("Error reading numeric data: {}", e.getMessage());
            return 0.0;
        }
    }

    /**
     * Gets the total number of rows in the specified sheet.
     *
     * @param sheetName name of the sheet
     * @return total number of rows (including header)
     */
    public int getRowCount(String sheetName) {
        logger.debug("Getting row count for sheet: {}", sheetName);
        sheet = wb.getSheet(sheetName);
        int rowCount = sheet.getLastRowNum() + 1;
        logger.info("Row count for sheet {}: {}", sheetName, rowCount);
        return rowCount;
    }

    /**
     * Gets the total number of columns in the first row of the specified sheet.
     *
     * @param sheetName name of the sheet
     * @return total number of columns
     */
    public int getColumnCount(String sheetName) {
        logger.debug("Getting column count for sheet: {}", sheetName);
        sheet = wb.getSheet(sheetName);
        int colCount = sheet.getRow(0).getLastCellNum();
        logger.info("Column count for sheet {}: {}", sheetName, colCount);
        return colCount;
    }

    /**
     * Gets any cell data as a formatted String regardless of cell type.
     * Handles String, Numeric, Boolean, Formula, and Blank cells.
     *
     * @param sheetName name of the sheet
     * @param row       row number (0-based)
     * @param col       column number (0-based)
     * @return cell value as formatted String
     */
    public String getCellData(String sheetName, int row, int col) {
        logger.debug("Reading cell data from sheet: {}, row: {}, col: {}", sheetName, row, col);
        try {
            sheet = wb.getSheet(sheetName);
            XSSFRow xssfRow = sheet.getRow(row);
            if (xssfRow == null) {
                logger.warn("Row {} is null in sheet {}", row, sheetName);
                return "";
            }
            XSSFCell cell = xssfRow.getCell(col);
            if (cell == null) {
                logger.warn("Cell at row {}, col {} is null in sheet {}", row, col, sheetName);
                return "";
            }

            CellType cellType = cell.getCellType();

            switch (cellType) {
                case STRING:
                    return cell.getStringCellValue();

                case NUMERIC:
                    DataFormatter formatter = new DataFormatter();
                    return formatter.formatCellValue(cell);

                case BOOLEAN:
                    return String.valueOf(cell.getBooleanCellValue());

                case FORMULA:
                    FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
                    return new DataFormatter().formatCellValue(cell, evaluator);

                case BLANK:
                    return "";

                default:
                    return "";
            }
        } catch (Exception e) {
            logger.error("Error reading cell data: {}", e.getMessage());
            return "";
        }
    }
}
