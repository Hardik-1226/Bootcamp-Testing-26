# Notes_Testing

## 7 Principles of Testing

1. Testing should start as soon as possible, It saves times and money
2. Exaustive testing is impossible

Note: Exaustive testing

- We can’t able test all combination except some cases
1. Testing Shows presence of defects

CMM( Capability matuarity module):
There are 5 levels in cmm
H/W: coforge cmm type

We can’t prove 100% bug free applications.
4. Testing is context dependent

- each and every domain testing terminologies/ different
- Banking applications are differ from health care applications
1. Absence of error is a fallacy each module is tested by tester using different testing techniques but still tester will find deffects
- Note: project is divided into module
- projects are divided into submodules
- submodules are divided into micro units

## 6. Pesticide Paradox

same task repeatedly testing, tester will not find new bugs this is pesticide paradox.

## Defect Clustering

Whenever tester finds a new bug each and every bug will be recorder in different way.

## Software Development Life Cycle

## SDLC Phases

1. Software requirement specifications (SRS):

## Feasability Study Under SRS

1. Checking wheather application can be developed or not
2. Software and hardware requirements
3. Cost, time and budget these all are called as feasability factors

Use case document or FRS(Functional Requirement Specification)

## 2. Analysis

analysis done by senior developer , they’ll prepare technical designed documnet (TDD)
3. Designed Phase

Conducted by senior developer or archetect there are two types in designed

1. high level design
2. low level design
low level design are flow charts algorithm and psudo code. High level design:
3. root to leaf structure of entire application
4. Data flow of the application
5. Functional flow of the application

## 4. Coding

Converting design into implementation is called as coding. coding is done by developers based on diff technologies like C, C++ , Java , .Net etc…

## 5. Testing

Testing is the process of execution program intension is to find bugs
Type of testing :

1. White box testing :- Developer
2. Black Box testing : - Testers
3. User acceptance testing (end users)

## 6. Release and Maintance

SDLC Model

1. water fall model
2. Prototype model
3. Increamental model
4. Agile model
5. Rapid development Application

White Box : Testing an application using internal structure of programming knowledge is called as white box testing, also called as static testing.
Open box testing, Glass box testing, Opeque testing
Types in WHite box testing:

1. Statement technique coverages
2. Program technique coverages
3. loops coverages
4. output coverages
5. Cyclomatic complexity

White box is done by developers

![](Notes_Testing/imagesed814a01-6da1-4007-8a76-7e5eee6dca0c-05_851_604_1366_969.jpg)

there are two type of White box testing :

1. Unit testing
2. Intergration testing

Microunit of source code is called as unit.
2. Integration testing:

Integration testing is done by both developers and tester. checking the data flow between the modules, is called as integration testing.

There are two types :

1. Top down approach
2. Bottom up approach
(Top down approach is also called as stup
Bottonm up appraoch is also called as driver)
3. Hybrid approach/ Bin Bang appraoch:
is also called as sandwhich approach
4. Top down approach: The developer will check data flow between mine module and sub modules when mine module under costructions developers will use stubs( stub is a temporory module to avoid the interfraces between these models) under construction .
5. Bottom Up approach: developers will check data flow between sub module to mine module. then developers will uses driver (driver is a temporory module to avoid the interfraces between these model) to avoid connections between modules ,
6. Hybrid approach: Developers uses both . It;s a combination of stub and driver.

## Black Box testing techniques

testing an application without using internal structure of programming knowledge
Dynamic testin, Stuctural testing, close box testing There are 2 types :

1. Functional testing
2. Non- Functional Testing
functional testing describes :
3. Validate functionality of the software
4. functionality describes what software does
5. Concentrates on user requirements

Test case design technique:

1. Euivalence class partitioning(ECP)
2. Boundary Value Analysis (BVA)
3. Decision table
4. State transition
5. Error guessing
6. Euivalence class partitioning(ECP):

ECP can be validate to invalid date to valid data

Enter a Number: □ * Allow Digits from 1-500

| Normal Test Data | Divide values into Equivalence |  |
| --- | --- | --- |
| 1 | Classes |  |
| 2 |  | Test Data using ECP |
| 3 | -100 to $true$ ( Invalid) | -50 |
| 4 | $true$ (Valid) | 30 |
| . | $true$ (Valid) | 160 |
| - | $true$ (Valid) | 250 |
|  | $true$ (Valid) | 320 |
| - | $true$ (Valid) | 450 |
| 500 | $true$ (Invalid) | 550 |

Name: □ * Allow only alphabets

## Divide values into Equivalence Classes

A..Z → (Valid)

Test Data using ECP XYZ
a..z → (Valid) zyz
Special Characters → (Invalid) @#$%
Spaces $true$ (Invalid) Xy z
Numbers → $true$ (Invalid) 1234

## 2. Boundary value analysis (BVA):  FInd out BVA for eCommerce application which accepts age minimum 18 and maximum 35 .

## find out BVA for insuarance company which accept age 18 and 60

![](Notes_Testing/imagesed814a01-6da1-4007-8a76-7e5eee6dca0c-09_1065_1548_708_311.jpg)

3. Decision table:
is also called as cause effect table
DT is used conditions and actions
if we have more condition and corresponding actions.
Q. Create DT using google images minimum 5. Create test cases with explanation
4. State transition technique:

State transaction is used input is given one sequence at a time.

Case Study: create state transition using google images minimum 5
flipkart
naukri
facebook
Myntra
Swiggy
5. Error guessing :

Tester will enter multiple inputs in the application checking correctness and completeness of the application under test

Software Testing Life Cylces( STLC):

1. Test plan specification
2. Test the senerios
3. Test case design or test case preparation
4. Test Execution levels
5. Defect reporting
6. test closer

Note: what’s the diff between SDLC and STLC.

Test Plan : It is a doc prepared by project manager/test team leader/ test engineers.
2. Test plan describes
what to test?
When to test?
How to test?
Whom to test??
Where to test? etc…
3. According to IEEE 829 test plan elements or

1. Test Plan Identifier
2. Document History
3. Introduction
4. Test Items
5. Features to be Tested
6. Features NOT to be Tested
7. Test Environment
8. Test Approach
9. Entry and Exit Criteria
10. Test Deliverables
11. Resource Needs
12. Schedule
13. Approvals

## Test Scenario

1. Scenario means What to test??
2. test Scenario is also called as test codition the
3. possible areas to be tested.
4. Test Scenario is derived from use case
5. Test Scenario Overview is any functionality when application is under test

## Test Case

Test case means how to test.
It is a detailed decription of any functinality how to test.
Test case is a document prepared by test engineers
Test case is a set of actions to be execute so validate perticular feature or functionality of your software application
It contains :

- test case id
- test steps
- test data
- preconditions
- expected value
- action values
- status of applications

Characterstics of Good Test Cases:

1. Test Case should not miss any of the functionality of the application
2. Same Test cases should not repeat multiple times or many times.
3. Test cases should be free from grammar mistakes or spelling mistakes
4. Test cases should be understand by Layman
5. Test cases should always be followed by should be keyword

Test case type:

1. Input domain test case design note: BVA and ECP are input domain test cases
2. Graphical user interface test case design
3. Functionality test case design

## Testing Levels

1. Unit testing
2. Integration testing
3. Ssytem testing
4. User acceptance testing these all are called as testing levels

## Test Execution levels

1. Level 0: Build acceptance / Build verification
2. Level 1: Smoke sanity testing
3. Level 2: Regression testing
4. Level 3: Final regression testing

## 1. Build Acceptance testing:

Note: once build recieved from developer testers will deploed this build into testing envirnment
Build is nothing but setup.exe file
Once tester deploy build into testing envirnment using file transfer protocol (FTP).
2. Level 1: Smoke testing: Testing the stability of the application
: sanity: Checking main functionality or imporatant functionality
2. Regression testing: Whenever tester test on initial build functionalities modify build fuinctionality should not affect and vice-verca.
4. Final regression Testing: In case team leader or project manager not satisfied with regression testing they will conduct final regression testing

## Defect Classification

DC is done by two steps:

1. Severity: it affects functionality of the application .
Severity describe the seriousness of the defect that impacts the business value or business flow
Severity is normally given by quality control team(testers)
Severity is classified into 4 ways:
2. Blocker
3. Critical
4. Major
5. Minor
6. Blocker: Unable to perform any operations
7. Critical: It works only part of the funcitons
8. Major: It affects on the functionality.
9. Minor: It affects only on the function of the functionality
10. Priority:

It does not affect the functionalities
It affects on the business value
there are 3 categories :

1. $true$ High
2. p2/Medium
3. p3/Low
4. Status :

Bug life cycle

Day 4

1. New
2. Assigned
- Duplicate: same bug is repeated multiple times , then the bug is treated as duplicate
- Rejected: The bug has no genuine meaning.
- Deffered Status: These kind of the bug will be fixed in next version. It does’nt affect on the current version

Requirement Tracibility Matrix (RTM):
There are 3 types of RTM:

1. Forward Tracibility
2. Backword Tracibility
3. BiDirectional Tracibility
4. Forward Tracibility: This is a doc which is used to map requirement to testcases. this will help you ensure project is moving to right direction
5. Backword tracibility: This is a document which is used to map test cases to requirement.
6. BiDirectional tracibility: It’s a combination of both forward tracibility and backword tracibility and vice-verca.

Testing Methodologies/ terminalogies:

1. Smoke testing
2. Senity testing
3. Regression testing
4. Exploratory testing
5. Ad-hoc testing
6. Monkey Testing / Gorilla testing
7. Localisation testing or Internationalisation testing
8. Automation testing
9. Manual testing

Exploratory testing: Due to lack of domain knowledge the tester will test the Application with help of developers is called as exploratory testing.

Ad-Hoc testing: When requirements are not clear or requirements are not properly documented so the tester will test the application using ideas is called as adhoc testing.

Monkey Testing: due to lack of time the tester will test the application without following any rules and regulations , so the tester will test randomly of any funciton of the build without any sequence.

Gorilla testing: it’s a type of game software , it’s used for games application/software.

Localisation testing or internationalise testing: testing the application using regional languages that is called as ….

Internationalisation testing: testing the application using international language like english, japanese, spanish etc.

Manual testing: testing an application wihtout using any tools.

Automation testing: Testing an application with using tools like silanium, test complete, postman , appium etc.

Non-Functional testing types:

1. Graphical user interface testing (GUI testing)
2. Sanitation testing
3. Installation testing
4. Performance testing
5. Load testing
6. Peak testing
7. Stress testing
8. Spike testing
9. Endurance testing
10. Compatibility testing
11. Configuration testing
12. Security testing
13. Recovery testing

## GUI testing

It doesn’t impact on the functionality of the application. testers verifies user friendly factors of an application.

## Sanitation

Checking or adding extra features to the application

## Installation testing

During installation testing testers validate these factors:

1. Setup .exe files
2. Unistallation files
3. Update
4. repair
5. cancellation files
6. Disk space
7. Memory allocations
8. During installation any pop-up msgs

## Performance testing

1. Load testing: Gradually increase the load (load is nothing but data) on the application slowly check the speed of the application.
2. Speed Testing: Suddenly increase or decrease the load of the application check the speed of the application.
3. Endurance testing: Execute the application for a over period of a time ( one day , 2 day depends of the customer need)
4. Compatibility testing:
two types:
5. Forward compatibility: Testing the application using latest versions of browsers.(MS edge)
6. Backword compatibility : Testing the application using older version of browser.
7. Configuration testing: Checking the application using latest version of OS(Operating system) .
8. Security testing: To prevent from unwanted/Unauthorized users.
9. SQL injections
10. vulnerability
11. XML injections
12. recovery testing : When application working under normal conditions in case if it is goes to abnormal conditions testers verify wheather application is recovering back.
(Testers check the recovery functions)

## Test Closure

Once bug status is closed and defect status is closed by tester/team lead , quality control team. Based of the defected density team leader or project manager can close the status of the bug.

## QA Activity in real time

1. Understand functional requirement of the application
2. Identify test senerios
3. Design test cases for test senerios
4. Create test envirnment ( Test bid)
5. Log Test results
6. Defect Reporting
7. Participate in testing Activities
8. Participate in Standup meating
9. Involved in sprint restrospectue(Agile ceremonies)
1.Sprint planning
2.Sprint Review
10. Sprint Restrospecue
restrospecue : what went well, what not went well, need any changes

## Peer Reviews

Exchanging the test cases btw two testers or within the team.

JIRA is a test management tool which is used to store testing activities in proper manner with security.

Jira is a test management tool which is used to collaborate

Jira Products:

1. Jira software
2. Jira service management
3. Jira work management

It’s a 14 days trial version.
Jira is used to create bug, task, user story, and chain tracking

Bug: It’s a diviation from requirement

Epic: Epic is a bigger story which can be divided into smaller parts in projects.

Product backlog: Product backlog is a list of items need to complete successfully in project or product.

User story: User story is created by product owner

Scrum Master: Facilitates backlog refinement process

Business analysis: Helps together proper requirements in
each state.

Developer: Developer estimates the efforts and time require to complete within the sprint.

Testers: Identify bugs/ find out bugs during entire process using testing activities

UAT Testers provides business needs and feedback.

Sprint: Sprint is a cycle depends on the company 10 working days
Q. Create minimum 5 scrum sprints using JIRA management tool for Ecommerce, Banking, Healthcare, Insuarance and any predefined applications.

TDD( test Driven Development): Before write in code , test case should be executed then refactor in case test cases are failed.
BDD(Behavioural Driven Development): Focus more on behaviour of the application.

BBD follows Gerkin approach

1. Given : Given keyword is used for preconditions

Enter some credentials into applications
2. Then : Then keyword is used to create successful login, successful created etc.
3. And : Used for display any output like OTP.

Cucumber : We’ll use it for BDD.

Sprint Goals : Complete all functionalities in case if you find any bugs report in next sprints.

Jira workflow:
1st step is : Jira workflow todo
2nd : In progress
3rd : Testing
4th: Preview

// for sending the xl sheet to assigne on the jira 

We’ve to update daily on JIRA what we done today. Hi ….. I picked (user story number) jira user story I’ve completed Requirement tracibility matrix, Scenarios, CaseStudy here i’m attaching excell sheet for you preview . thanks regards

**8 july**

**Azure Devops**
it is a cloud based project management microsoft tool.

it help us to deployment and development, coding, testing, maintains without using SDLC

Azure devops we can use for project management, code management, test management continuous integration and continuous deployment 

**Azure** 
1 create organisation

2 create project 

3 create test plan 

4 create test cases

5 connect with git repo

6 create pipelines

7 execute test cases using YAML files

**Epic**

epic is bigger story/ larger story ****bring them into pieces

example end to end testing