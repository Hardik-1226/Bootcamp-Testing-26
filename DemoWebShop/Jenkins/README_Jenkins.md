# Jenkins CI/CD - DemoWebShop Automation Framework

## Overview

The `Jenkinsfile` defines a **Declarative Pipeline** with the following stages:

| Stage                   | What it Does                           |
|-------------------------|----------------------------------------|
| Checkout                | Pulls code from Git repository         |
| Build                   | Compiles the Maven project             |
| Generate Test Data      | Creates Excel test data file           |
| Run Selenium Tests      | Executes TestNG test suite             |
| Run API Tests           | Executes REST Assured tests            |
| Generate Allure Report  | Creates Allure HTML report             |

---

## Prerequisites

1. **Jenkins** installed (https://www.jenkins.io/download/)
2. **Java 22** configured in Jenkins → Global Tool Configuration
3. **Maven** configured in Jenkins → Global Tool Configuration
4. **Allure Plugin** installed in Jenkins → Manage Plugins

### Install Required Jenkins Plugins

Go to **Manage Jenkins** → **Manage Plugins** → **Available**:
- ✅ Allure Jenkins Plugin
- ✅ HTML Publisher Plugin
- ✅ Git Plugin
- ✅ Maven Integration Plugin
- ✅ Pipeline Plugin

---

## How to Create Jenkins Job

### Step 1: Create New Pipeline Job

1. Open Jenkins Dashboard
2. Click **New Item**
3. Enter name: `DemoWebShop-Automation`
4. Select **Pipeline**
5. Click **OK**

### Step 2: Configure Git Repository

1. Scroll to **Pipeline** section
2. Select **Pipeline script from SCM**
3. Select **Git** as SCM
4. Enter your Git repository URL
5. Set **Script Path**: `Jenkins/Jenkinsfile`
6. Click **Save**

### Step 3: Configure Tools

Go to **Manage Jenkins** → **Global Tool Configuration**:

**JDK:**
- Name: `JDK22`
- JAVA_HOME: `C:\Program Files\Java\jdk-22` (your Java path)

**Maven:**
- Name: `Maven`
- MAVEN_HOME: `C:\apache-maven-3.9.x` (your Maven path)

### Step 4: Configure Allure

Go to **Manage Jenkins** → **Global Tool Configuration**:
- Name: `allure`
- Install automatically: ✅

---

## How to Run

### Manual Trigger
1. Go to `DemoWebShop-Automation` job
2. Click **Build Now**
3. Watch the build in **Console Output**

### Scheduled Trigger (Cron)
In job configuration, under **Build Triggers**:
- Check **Build periodically**
- Schedule: `H/30 * * * *` (every 30 minutes)
- Or: `H 9 * * 1-5` (weekdays at 9 AM)

### Git Trigger
- Check **Poll SCM**
- Schedule: `H/5 * * * *` (poll every 5 minutes)

---

## How to View Reports

### TestNG Report
1. Go to the build page
2. Click **TestNG Report** in the left sidebar

### Allure Report
1. Go to the build page
2. Click **Allure Report** in the left sidebar

### Screenshots
1. Go to the build page
2. Click **Build Artifacts**
3. Navigate to `screenshots/` folder

### Console Output
1. Go to the build page
2. Click **Console Output** for full logs

---

## Pipeline Stages Explained

```
┌──────────────┐
│   Checkout   │  ← Pull code from Git
└──────┬───────┘
       ▼
┌──────────────┐
│    Build     │  ← mvn clean compile
└──────┬───────┘
       ▼
┌──────────────┐
│  Test Data   │  ← Generate Excel file
└──────┬───────┘
       ▼
┌──────────────┐
│ Selenium     │  ← mvn test (TestNG suite)
│ Tests        │
└──────┬───────┘
       ▼
┌──────────────┐
│  API Tests   │  ← REST Assured tests
└──────┬───────┘
       ▼
┌──────────────┐
│ Allure       │  ← Generate HTML report
│ Report       │
└──────┬───────┘
       ▼
┌──────────────┐
│  Archive     │  ← Save screenshots,
│  Artifacts   │     reports, logs
└──────────────┘
```

---

## Troubleshooting

| Issue                          | Solution                                     |
|--------------------------------|----------------------------------------------|
| Maven not found                | Configure Maven in Global Tool Configuration |
| Java version mismatch          | Set JDK22 in Global Tool Configuration       |
| Allure plugin missing          | Install Allure Plugin from Manage Plugins     |
| Tests fail                     | Check Console Output for error details        |
| No screenshots                 | Tests passed; screenshots only on failure     |
