# DemoWebShop Automation Framework

Enterprise-grade Selenium Automation Framework for [DemoWebShop](https://demowebshop.tricentis.com/).

## Tech Stack

| Technology        | Version  |
|-------------------|----------|
| Java              | 22       |
| Maven             | 3.9+     |
| Selenium          | 4.22.0   |
| TestNG            | 7.10.2   |
| Apache POI        | 5.3.0    |
| OpenCSV           | 5.9      |
| Cucumber          | 7.34.3   |
| Allure Reports    | 2.27.0   |
| Log4j2            | 2.23.1   |
| WebDriverManager  | 5.9.2    |

## Design Patterns

- Page Object Model (POM)
- Page Factory
- Data Driven Framework
- Singleton Configuration

## Project Structure

```
DemoWebShopAutomationFramework/
├── pom.xml
├── testng.xml
├── src/main/java/com/demowebshop/
│   ├── base/BaseClass.java
│   ├── pages/(BasePage, LoginPage, HomePage, RegisterPage, CartPage, CheckoutPage)
│   └── utils/(BrowserFactory, ConfigDataProvider, ExcelDataProvider, CSVReaderUtil, Helper, WaitHelper, ScreenshotHelper)
├── src/main/resources/
│   ├── Config/Config.properties
│   ├── TestData/(DemoWebShopTestData.xlsx, LoginData.csv)
│   └── log4j2.xml
├── src/test/java/com/demowebshop/
│   ├── tests/(LoginTest, RegistrationTest, SearchProductTest, CartTest, CheckoutTest, CSVDataDrivenTest, ExcelDataDrivenTest)
│   ├── runner/TestRunner.java
│   └── stepDefinitions/(LoginSteps, CartSteps)
└── src/test/resources/features/(Login.feature, Cart.feature, Checkout.feature)
```

## Setup

1. Clone the repository
2. Install Java 22 and Maven
3. Run `mvn clean install`

## Execution

```bash
# Run all tests
mvn clean test

# Run specific test suite
mvn clean test -DsuiteXmlFile=testng.xml

# Generate Allure report
mvn allure:serve
```

## Configuration

Edit `src/main/resources/Config/Config.properties` to configure browser, URL, and credentials.

## Reports

- **Allure Reports**: `mvn allure:serve`
- **TestNG Reports**: `test-output/index.html`
- **Screenshots**: `screenshots/` directory
- **Logs**: `logs/` directory
