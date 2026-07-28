# DemoWebShop JMeter Load Testing

This folder contains a JMeter test plan (`.jmx`) designed to load test the read-heavy paths of the DemoWebShop application.

## Prerequisites
1. Download and install [Apache JMeter](https://jmeter.apache.org/download_jmeter.cgi) (requires Java 8+).
2. Ensure the `bin` directory of your JMeter installation is added to your system's PATH.

## Running the Test (GUI Mode)
*Use GUI mode only for creating or debugging tests, NOT for actual load testing.*

1. Open JMeter GUI by running `jmeter` in your terminal.
2. Go to **File -> Open** and select `DemoWebShop_LoadTest.jmx`.
3. Adjust the **Thread Group** properties (number of users, ramp-up time) as needed.
4. Click the green **Start** button in the toolbar to run the test.
5. Check the **View Results Tree** or **Summary Report** listeners to see the results.

## Running the Test (CLI / Headless Mode)
*Always use CLI mode for actual load testing to ensure accurate metrics.*

Run the following command from this directory:
```bash
jmeter -n -t DemoWebShop_LoadTest.jmx -l results.csv -e -o ./html_report
```

### Parameters:
- `-n`: Run JMeter in Non-GUI (headless) mode.
- `-t`: Specifies the path to the `.jmx` test plan.
- `-l`: Path to log results to a CSV file.
- `-e`: Generate a dashboard report at the end of the load test.
- `-o`: The output folder for the HTML dashboard report.
