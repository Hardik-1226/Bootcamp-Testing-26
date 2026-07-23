# Java + Selenium Automation Training

This repository is a personal training workspace for learning **Java fundamentals** and **Selenium-based test automation**. It is not a single production application — it's a collection of small, independent practice projects and case studies built while learning core Java concepts, browser automation, and test frameworks.

## Overview

The codebase focuses on:

- Learning Java fundamentals (OOP concepts, exception handling, file handling, etc.)
- Practicing Selenium WebDriver for browser automation
- Using TestNG for test execution
- Exploring Cucumber BDD flows
- Building small automation case studies and utilities

## Technologies Used

- **Java 17**
- **Maven**
- **Selenium WebDriver**
- **TestNG**
- **Cucumber**
- **JUnit**
- **WebDriverManager**

The main dependency setup can be found in `pom.xml`, and the Cucumber-based project has its own setup in `Testing-Training/CucumberJavaProject/pom.xml`.

## Project Structure

All training modules live under the `Testing-Training` directory, organized by topic:

### Java Fundamentals

Basic Java learning topics such as abstraction, constructors, inheritance, interfaces, exception handling, file handling, access modifiers, and control statements.

- `Testing-Training/Abstraction`
- `Testing-Training/constructorsInJava`
- `Testing-Training/InhritenceInJava`
- `Testing-Training/interfaces`

### Selenium Automation Practice

Browser automation examples covering launching browsers, navigation, alerts, locators, mouse hover, drag and drop, screenshots, multiple frames, and page object model style code.

- `Testing-Training/NavigationCommands`
- `Testing-Training/MouseOverMoments`
- `Testing-Training/DragAndDrop`
- `Testing-Training/SelaniumWebDriverScreenShots`
- `Testing-Training/multipleFrame`

### Data-Driven and BDD Testing

Projects covering CSV-based parameterization, Cucumber BDD tests, and example test cases for registration and form flows.

- `Testing-Training/DataDrivenUsingCSVFile`
- `Testing-Training/CucumberJavaProject`

### Case Study Projects

Practice case studies and mini automation exercises.

- `Testing-Training/sleneiumWebDriverCaseStudy`
- `Testing-Training/18_July`
- `Testing-Training/WebDriverParameterizationUsingCSVFile`

### Common Layout

Most subprojects follow a similar structure:

```
<project-folder>/
├── pom.xml                  # Maven project file
├── src/
│   ├── main/java/            # Source files
│   └── test/java/            # Test classes
└── test-output/ or target/   # Generated reports
```

## Prerequisites

- Java 17 (JDK)
- Maven
- A supported browser (e.g., Chrome) for Selenium tests
- An IDE such as IntelliJ IDEA or Eclipse (recommended)

## How to Run a Project

Each module under `Testing-Training` is largely self-contained. To run one:

1. Navigate to the desired project folder, e.g.:
   ```bash
   cd Testing-Training/<project-folder>
   ```
2. Run tests using Maven:
   ```bash
   mvn test
   ```
3. For TestNG-based projects, check for a `testng.xml` file and run it directly from your IDE if preferred.
4. For the Cucumber project, run the feature files via the configured test runner in `Testing-Training/CucumberJavaProject`.

Generated reports (if any) will typically appear under `test-output/` or `target/`.

## Notes and Learning Goals

This is **not** a single app with one main workflow — it's a learning repository made up of many smaller, independent automation exercises. Think of it as:

- A training codebase for Java and Selenium
- A collection of hands-on practice modules
- A workspace for continuous automation learning

New folders may be added over time as new concepts are explored.
