# Postman Collection - DemoWebShop API Testing

## Overview

This Postman collection tests API endpoints using **FakeStoreAPI** (https://fakestoreapi.com).

It contains **17 requests** organized into 4 folders:

| Folder          | Requests |
|-----------------|----------|
| Authentication  | 2        |
| Products        | 7        |
| Cart            | 5        |
| Users           | 5        |

---

## How to Import

1. Open **Postman**
2. Click **Import** button (top left)
3. Select **File** tab
4. Choose `DemoWebShop_Postman_Collection.json`
5. Click **Import**
6. Import `Environment.json` the same way
7. Select **DemoWebShop Environment** from the environment dropdown (top right)

---

## How to Run in Postman

### Run Individual Request
1. Open any request from the collection
2. Click **Send**
3. Check **Test Results** tab at the bottom

### Run Entire Collection
1. Click the **three dots (...)** next to the collection name
2. Select **Run collection**
3. Click **Run DemoWebShop API Collection**
4. View results in the **Collection Runner**

### Run Specific Folder
1. Click the **three dots (...)** next to a folder (e.g., Products)
2. Select **Run folder**
3. View results

---

## How to Run Using Newman (CLI)

### Install Newman
```bash
npm install -g newman
```

### Run Collection
```bash
newman run DemoWebShop_Postman_Collection.json
```

### Run with Environment
```bash
newman run DemoWebShop_Postman_Collection.json -e Environment.json
```

### Run with HTML Report
```bash
npm install -g newman-reporter-htmlextra
newman run DemoWebShop_Postman_Collection.json -e Environment.json -r htmlextra
```

### Run Specific Folder
```bash
newman run DemoWebShop_Postman_Collection.json --folder "Products"
```

---

## Validations Included

Every request validates:
- ✅ Status Code (200, 400, 401)
- ✅ Response Time (< 3000ms or < 5000ms)
- ✅ Response Body fields
- ✅ JSON Schema (for GET All Products)
- ✅ Data type checks
- ✅ Content-Type headers

---

## Environment Variables

| Variable   | Value                          |
|------------|--------------------------------|
| baseUrl    | https://fakestoreapi.com       |
| webAppUrl  | https://demowebshop.tricentis.com |
| username   | mor_2314                       |
| password   | 83r5^_                         |
| token      | (auto-generated on login)      |

## Collection Variables

| Variable         | Description                    |
|------------------|--------------------------------|
| createdProductId | Saved after POST Create Product |
| createdCartId    | Saved after POST Add to Cart   |
