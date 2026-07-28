# Data Driven Testing using CSV Files

This folder isolates and demonstrates how Data Driven Testing is implemented using CSV files within the DemoWebShop Automation Framework.

## Files Included:
- **`LoginData.csv`**: The actual test data source containing email, password, and expected outcome.
- **`CSVReaderUtil.java`**: A utility class utilizing OpenCSV to parse the CSV file dynamically.
- **`CSVDataDrivenTest.java`**: The TestNG test class that reads the data from the CSV file and iterates through it to verify different login scenarios on DemoWebShop.

*Note: These files are exact copies of the live files used in the `src/` directory. They are placed here for assignment/reference purposes.*
