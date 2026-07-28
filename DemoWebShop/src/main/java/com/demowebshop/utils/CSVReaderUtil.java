package com.demowebshop.utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

/**
 * CSVReaderUtil - Reads test data from CSV files using OpenCSV library.
 * Supports reading all rows, specific rows, and header-based access.
 *
 * @author DemoWebShop Automation Team
 * @version 1.0
 */
public class CSVReaderUtil {

    private static final Logger logger = LogManager.getLogger(CSVReaderUtil.class);

    /**
     * Reads all data from the specified CSV file.
     *
     * @param filePath path to the CSV file
     * @return List of String arrays, each array represents a row
     */
    public static List<String[]> readCSVData(String filePath) {
        logger.info("Reading CSV data from: {}", filePath);
        CSVReader reader = null;
        try {
            File file = new File(filePath);
            reader = new CSVReader(new FileReader(file));
            List<String[]> data = reader.readAll();
            logger.info("Total rows read from CSV: {}", data.size());
            return data;
        } catch (IOException | CsvException e) {
            logger.error("Error reading CSV file: {}", e.getMessage());
            throw new RuntimeException("CSV file reading failed: " + e.getMessage(), e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                    logger.debug("CSV reader closed successfully");
                } catch (IOException e) {
                    logger.error("Error closing CSV reader: {}", e.getMessage());
                }
            }
        }
    }

    /**
     * Reads CSV data excluding the header row.
     *
     * @param filePath path to the CSV file
     * @return List of String arrays (data rows only, no header)
     */
    public static List<String[]> readCSVDataWithoutHeader(String filePath) {
        logger.info("Reading CSV data without header from: {}", filePath);
        CSVReader reader = null;
        try {
            File file = new File(filePath);
            reader = new CSVReader(new FileReader(file));
            List<String[]> data = reader.readAll();
            if (!data.isEmpty()) {
                data.remove(0);
            }
            logger.info("Total data rows (excluding header): {}", data.size());
            return data;
        } catch (IOException | CsvException e) {
            logger.error("Error reading CSV file: {}", e.getMessage());
            throw new RuntimeException("CSV file reading failed: " + e.getMessage(), e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                    logger.debug("CSV reader closed successfully");
                } catch (IOException e) {
                    logger.error("Error closing CSV reader: {}", e.getMessage());
                }
            }
        }
    }

    /**
     * Gets a specific row of data from the CSV file.
     *
     * @param filePath path to the CSV file
     * @param rowIndex row index (0-based, includes header)
     * @return String array representing the row data
     */
    public static String[] getRow(String filePath, int rowIndex) {
        logger.info("Reading row {} from CSV: {}", rowIndex, filePath);
        List<String[]> allData = readCSVData(filePath);
        if (rowIndex >= 0 && rowIndex < allData.size()) {
            return allData.get(rowIndex);
        }
        logger.warn("Row index {} out of bounds for CSV: {}", rowIndex, filePath);
        return new String[]{};
    }

    /**
     * Gets the total number of rows in the CSV file (including header).
     *
     * @param filePath path to the CSV file
     * @return total number of rows
     */
    public static int getRowCount(String filePath) {
        List<String[]> allData = readCSVData(filePath);
        int count = allData.size();
        logger.info("Total rows in CSV: {}", count);
        return count;
    }
}
