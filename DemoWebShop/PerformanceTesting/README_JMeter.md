# JMeter Performance Testing - DemoWebShop

## Overview

This JMeter test plan performs load testing on **https://demowebshop.tricentis.com/** with the following pages:

| # | Page           | URL Path                |
|---|----------------|-------------------------|
| 1 | Home Page      | `/`                     |
| 2 | Login Page     | `/login`                |
| 3 | Register Page  | `/register`             |
| 4 | Search         | `/search?q=computer`    |
| 5 | Product Page   | `/computing-and-internet` |
| 6 | Cart Page      | `/cart`                 |

## Test Configuration

| Setting        | Value |
|----------------|-------|
| Threads (Users)| 5     |
| Ramp-up Time   | 10s   |
| Loop Count     | 2     |
| Total Requests | 60    |

---

## Prerequisites

- Download JMeter from: https://jmeter.apache.org/download_jmeter.cgi
- Extract and add `bin/` folder to system PATH
- Verify: `jmeter --version`

---

## How to Run

### GUI Mode (For Debugging)

```bash
jmeter -t PerformanceTesting/DemoWebShop.jmx
```

This opens JMeter GUI where you can:
1. View and edit the test plan
2. Run tests with **Play** button (green arrow)
3. View results in **View Results Tree**
4. Check **Aggregate Report** for statistics

### Non-GUI Mode (For Actual Testing)

```bash
jmeter -n -t PerformanceTesting/DemoWebShop.jmx -l PerformanceTesting/results/results.jtl
```

**Flags:**
- `-n` = Non-GUI mode
- `-t` = Test plan file
- `-l` = Log results to JTL file

### Generate HTML Dashboard Report

```bash
jmeter -g PerformanceTesting/results/results.jtl -o PerformanceTesting/Report
```

**Flags:**
- `-g` = Input JTL results file
- `-o` = Output report directory (must not exist or be empty)

### One Command - Run and Generate Report

```bash
jmeter -n -t PerformanceTesting/DemoWebShop.jmx -l PerformanceTesting/results/results.jtl -e -o PerformanceTesting/Report
```

**Flags:**
- `-e` = Generate report after test
- `-o` = Output report directory

---

## Test Plan Components

| Component              | Purpose                                    |
|------------------------|--------------------------------------------|
| HTTP Request Defaults  | Base URL and protocol for all requests     |
| HTTP Header Manager    | Browser-like headers (User-Agent, Accept)  |
| HTTP Cookie Manager    | Manages session cookies automatically      |
| CSV Data Set Config    | Reads login data from LoginData.csv        |
| Thread Group           | Configures virtual users and loops         |
| Response Assertions    | Validates HTTP 200 status codes            |
| View Results Tree      | Detailed request/response viewer           |
| Aggregate Report       | Statistics (avg, min, max, throughput)      |
| Summary Report         | Quick summary of test results              |

---

## Results Location

| Report Type     | File Path                                    |
|-----------------|----------------------------------------------|
| View Results    | `PerformanceTesting/results/view_results.jtl` |
| Aggregate       | `PerformanceTesting/results/aggregate_report.jtl` |
| Summary         | `PerformanceTesting/results/summary_report.jtl` |
| HTML Dashboard  | `PerformanceTesting/Report/index.html`       |

---

## Tips

1. **Always use Non-GUI mode** for actual performance testing
2. **Clear old results** before re-running: delete the `results/` and `Report/` folders
3. **Increase threads gradually** - start with 5, then 10, 20, 50
4. **Check error rate** in Aggregate Report - should be 0% for healthy app
