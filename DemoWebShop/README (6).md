# PROJECT_SPEC.md

# DemoWebShop Automation Framework – Enterprise Specification

## Goal
Create an enterprise-grade Selenium Automation Framework for **https://demowebshop.tricentis.com/** that closely follows the framework demonstrated in the provided training slides.

---

# Tech Stack

- Java 22
- Maven
- Selenium 4.x
- TestNG
- Apache POI
- OpenCSV
- Cucumber
- Allure Reports
- Log4j2
- WebDriverManager
- Page Object Model (POM)
- Page Factory
- Data Driven Framework

---

# Project Structure

```text
DemoWebShopAutomationFramework/
│
├── pom.xml
├── testng.xml
├── README.md
├── .gitignore
├── screenshots/
├── allure-results/
├── test-output/
├── logs/
│
├── src
│   ├── main
│   │   ├── java
│   │   │
│   │   ├── com.demowebshop.base
│   │   │      BaseClass.java
│   │   │
│   │   ├── com.demowebshop.pages
│   │   │      BasePage.java
│   │   │      HomePage.java
│   │   │      LoginPage.java
│   │   │      RegisterPage.java
│   │   │      CartPage.java
│   │   │      CheckoutPage.java
│   │   │
│   │   └── com.demowebshop.utils
│   │          BrowserFactory.java
│   │          ConfigDataProvider.java
│   │          ExcelDataProvider.java
│   │          CSVReaderUtil.java
│   │          Helper.java
│   │          WaitHelper.java
│   │          ScreenshotHelper.java
│   │
│   └── resources
│       ├── Config
│       │      Config.properties
│       ├── TestData
│       │      DemoWebShopTestData.xlsx
│       │      LoginData.csv
│       └── log4j2.xml
│
└── src
    └── test
        ├── java
        │   ├── com.demowebshop.tests
        │   │      LoginTest.java
        │   │      RegistrationTest.java
        │   │      SearchProductTest.java
        │   │      CartTest.java
        │   │      CheckoutTest.java
        │   │      CSVDataDrivenTest.java
        │   │      ExcelDataDrivenTest.java
        │   ├── runner
        │   │      TestRunner.java
        │   └── stepDefinitions
        │          LoginSteps.java
        │          CartSteps.java
        └── resources
            └── features
                Login.feature
                Cart.feature
                Checkout.feature
```

---

# Responsibilities

## BaseClass.java
- @BeforeSuite
- @BeforeMethod
- @AfterMethod
- @AfterSuite
- Read browser and URL from Config.properties
- Launch browser using BrowserFactory
- Maximize browser
- Configure waits
- Capture screenshots on failure
- Close browser

## BrowserFactory.java
- Support Chrome
- Edge
- Firefox
- WebDriverManager
- Return WebDriver instance

## ConfigDataProvider.java
Read Config.properties.

Methods:
- getBrowser()
- getURL()
- getUsername()
- getPassword()

## ExcelDataProvider.java
Apache POI implementation.

Methods:
- getStringData()
- getNumericData()
- getRowCount()
- getColumnCount()

## CSVReaderUtil.java
Read CSV using OpenCSV.

## Helper.java
Contains reusable utilities:
- Screenshot
- Timestamp
- Random Email
- Scroll
- Highlight Element
- JS Click
- Explicit Wait

## LoginPage.java
PageFactory implementation.

Methods:
- enterEmail()
- enterPassword()
- clickLogin()
- login()

## HomePage.java
- Search Product
- Logout
- Verify Logo
- Verify Title

## RegisterPage.java
All registration elements and actions.

## CartPage.java
- Add Product
- Remove Product
- Update Quantity
- Verify Cart

## CheckoutPage.java
Complete checkout flow.

---

# Test Classes

Every test must:
- Extend BaseClass
- Use TestNG
- Use Assertions
- Use Allure annotations
- Use Page Objects only
- No duplicate Selenium code

---

# Data Driven Framework

Generate:
- LoginData.csv
- DemoWebShopTestData.xlsx

Support:
- CSV Login
- Excel Login
- Multiple Users
- Assertions
- Screenshot on failure

---

# Cucumber

Generate:
- Feature files
- Step Definitions
- Hooks
- Test Runner

---

# pom.xml

Include latest compatible versions of:
- Selenium
- TestNG
- WebDriverManager
- Apache POI
- OpenCSV
- Log4j2
- Cucumber
- Allure
- Maven Surefire
- Allure Maven Plugin

---

# Config.properties

```properties
browser=chrome
url=https://demowebshop.tricentis.com/
username=test@test.com
password=Password@123
```

---

# Coding Standards

- Proper package names
- SOLID principles
- POM Design Pattern
- Java naming conventions
- Meaningful comments only
- No TODOs
- No placeholder code
- Every class must compile

---

# AI Generation Instructions

Generate **every file** listed above.

For each file output:

1. File Path
2. File Name
3. Complete Java/XML/CSV/Properties code

Never summarize.

Never skip a file.

Never use placeholder methods.

Generate production-ready code matching this architecture.
