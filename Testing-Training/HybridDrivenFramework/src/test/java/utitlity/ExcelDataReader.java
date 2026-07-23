package utitlity;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataReader {

    XSSFWorkbook wb;

    public ExcelDataReader() {

        try {
            File src = new File("./TestData/TestData.xlsx");
            FileInputStream fis = new FileInputStream(src);

            wb = new XSSFWorkbook(fis);

        } catch (Exception e) {
            System.out.println("Unable to load Excel file: " + e.getMessage());
        }
    }

    // Read String data using sheet index
    public String getStringData(int sheetIndex, int row, int column) {

        return wb.getSheetAt(sheetIndex)
                 .getRow(row)
                 .getCell(column)
                 .getStringCellValue();
    }

    // Read String data using sheet name
    public String getStringData(String sheetName, int row, int column) {

        return wb.getSheet(sheetName)
                 .getRow(row)
                 .getCell(column)
                 .getStringCellValue();
    }

    // Read Numeric data
    public double getNumericData(String sheetName, int row, int column) {

        return wb.getSheet(sheetName)
                 .getRow(row)
                 .getCell(column)
                 .getNumericCellValue();
    }
}