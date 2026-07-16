# July 1

Notes

		

# Day 1 – Software Testing Training Notes

**Date:** July 1, 2026

---

# 1. Types of Applications

```
Applications
│
├── Desktop / Standalone Application
│
├── Web / Two-Tier Application
│
└── Client-Server Application
```

## 1.1 Desktop / Standalone Application

A desktop application runs directly on a user's computer without requiring an internet connection or a server for its core functionality.

**Key Points**

- Installed on a local machine.
- Can work offline.
- Data is usually stored locally.
- Faster response as everything runs on the same system.

**Examples**

- VLC Media Player
- Notepad++
- Microsoft Paint
- Calculator

---

## 1.2 Web / Two-Tier Application

A web application runs through a web browser where the browser acts as the client and communicates with a web server.

**Key Points**

- Accessible from any device with a browser.
- Requires internet access.
- Easy to maintain since updates happen on the server.
- No installation required.

**Examples**

- Gmail
- Amazon
- Facebook
- Netflix

---

## 1.3 Client-Server Application

In a client-server application, multiple client systems communicate with a centralized server that processes requests and manages data.

**Key Points**

- Supports multiple users simultaneously.
- Centralized database and security.
- Easier data management.
- Commonly used in organizations.

**Examples**

- Banking Systems
- Hospital Management Systems
- ERP Software
- Library Management Systems

---

# 2. What is Software Testing?

Software testing is the process of verifying and validating a software application to ensure it meets the specified requirements and works correctly. Its primary purpose is to identify defects before the software reaches end users and to improve product quality.

---

# 3. Product vs Project

| Product | Project |
| --- | --- |
| A product is a software solution delivered to customers. | A project is a temporary effort undertaken to build a product or service. |
| Long-term lifecycle. | Has a fixed start and end date. |
| Focuses on continuous improvement. | Focuses on achieving specific objectives. |
| Customer-oriented. | Goal-oriented. |
| Maintained after release. | Ends once objectives are achieved. |

## Product Examples

1. Microsoft Windows – Operating System
2. Google Chrome – Web Browser
3. Microsoft Office – Productivity Suite
4. WhatsApp – Messaging Application
5. Spotify – Music Streaming Platform
6. Adobe Photoshop – Image Editing Software
7. Zoom – Video Conferencing Tool
8. Slack – Team Communication Platform
9. Instagram – Social Media Application
10. ChatGPT – AI Assistant

## Project Examples

1. Developing an E-commerce Website
2. Building a Banking Application
3. Creating a Hospital Management System
4. Developing a College ERP
5. Migrating Data to Cloud
6. Mobile App Development
7. Payroll Automation System
8. Website Redesign Project
9. CRM Implementation
10. AI Chatbot Development

**Difference:**

A **product** is what customers use, while a **project** is the effort required to build or improve that product.

---

# 4. Necessity of Software Testing

Software testing is essential because it:

- Finds defects early.
- Reduces development cost.
- Improves software quality.
- Ensures customer satisfaction.
- Verifies business requirements.
- Enhances security and reliability.
- Prevents failures after deployment.
- Improves user experience.

---

# 5. Objectives (Motive) of Software Testing

- Verify that the software meets requirements.
- Detect defects before release.
- Ensure product reliability.
- Improve software quality.
- Build customer confidence.
- Reduce maintenance costs.
- Minimize business risks.
- Deliver a stable and secure application.

---

# 6. Defect vs Bug

| Defect | Bug |
| --- | --- |
| A mismatch between expected and actual behavior identified during testing. | A defect reported by developers or testers during coding or execution. |
| Found during testing. | Observed while developing or testing. |
| Represents an issue in the software. | Often refers to the coding error causing the issue. |

**Example:**

If the Login button should redirect to the dashboard but instead shows an error, the observed issue is a **defect**, while the incorrect code causing it is the **bug**.

---

# 7. Debugging vs Testing

| Testing | Debugging |
| --- | --- |
| Identifies defects. | Finds the root cause of defects. |
| Performed mainly by Testers. | Performed mainly by Developers. |
| Checks software quality. | Fixes the identified issue. |
| Does not modify code. | Involves code changes. |

---

# 8. Quality Assurance (QA) vs Quality Control (QC)

## Quality Assurance (QA)

QA is a **process-oriented** approach that focuses on preventing defects by improving development processes.

**Examples**

- Process reviews
- Documentation standards
- Coding guidelines
- Training
- Audits

## Quality Control (QC)

QC is a **product-oriented** approach that focuses on identifying defects in the finished software through testing.

**Examples**

- Functional Testing
- Regression Testing
- Smoke Testing
- Performance Testing
- User Acceptance Testing

**Simple Difference**

- **QA:** Prevents defects.
- **QC:** Detects defects.

---

# 9. Seven Principles of Software Testing

### 1. Testing shows the presence of defects, not their absence.

Testing can reveal defects but can never prove that software is completely error-free.

### 2. Exhaustive testing is impossible.

Testing every possible input and scenario is not practical due to time and resource constraints.

### 3. Early testing saves time and cost.

Finding defects in the early stages is much cheaper than fixing them after release.

### 4. Defect clustering.

A small number of modules usually contain most of the defects.

### 5. Pesticide paradox.

Repeating the same test cases eventually finds fewer new defects. Test cases should be updated regularly.

### 6. Testing is context dependent.

Testing strategies differ based on the type of application, domain, and business requirements.

### 7. Absence-of-errors fallacy.

Even if software has no known defects, it is still unsuccessful if it does not meet user needs or business requirements.

---

# Key Takeaways

- Software testing ensures quality, reliability, and customer satisfaction.
- Testing identifies defects, while debugging fixes them.
- QA focuses on improving processes, whereas QC focuses on validating the product.
- Every application type requires a different testing strategy.
- Following testing principles helps build robust and high-quality software.

---

# 10. Sample Bug Identification Scenario

## Objective

Learn how to identify and report a bug by following a simple user flow in an e-commerce application.

### Test Steps

1. Open the browser.
2. Navigate to the application URL.
3. Sign in using a valid email ID and password.
4. Go to the **Vitamins & Supplements** category.
5. Click on **Vitamins**.
6. Select **Vitamin C**.
7. Click **Add to Basket** until the quantity reaches **5**.
8. Click **Continue Shopping**.
9. Open the shopping basket and verify that **5 items** are displayed.
10. Remove one item from the basket.

---

## Expected Result

- After removing one item, the basket count should automatically update from **5** to **4**.
- The basket should accurately reflect the current quantity.

---

## Actual Result

- The selected item is removed from the basket.
- However, the basket count still displays **5** instead of **4**.

**End of Day 1 Notes**