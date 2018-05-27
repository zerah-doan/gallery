# Test Plan

## 1	Introduction	
This test plan describes the testing approach and overall framework that will drive the testing of the gallery application hosted at https://basitali.github.io/test_gallery/dist/

### 1.1	 Scope
#### 1.1.1	In Scope
The scope of test is to assure following functionality:
- Upload image
- View image
- Delete image

running well on Chrome, Firefox and Edge browser

#### 1.1.2	Out of Scope
Any other functionality and browser which are not mentioned in In Scope

### 1.2	Quality Objective
-	Ensure the gallery application features work as expected
-	Ensure the functionalities work well on in-scope browsers

### 1.3	Roles and Responsibilities 
- QA Engineer who will:
     - Create test plan
     - Design test cases
     - Construct automation framework
     - Implement test scripts
     - Create guideline for running automation framework and test script     

## 2	Test Methodology
### 2.1	Overview
Due to requirement of project, ONLY test automation is carried out. And use Cucumber for framework.

### 2.2	Test Levels

Test automation for system test

### 2.3	Bug Triage
N/A

### 2.4	Suspension Criteria and Resumption Requirements
- Suspension criteria: in-scope functions are not ready for testing (having blocked issues that causes test cannot be executed)
- Resumption criteria: in-scope functions are ready for testing (not havinf any blocked issue)

### 2.5	Test Completeness
All the test script for in-scope functions are executed successfully

## 3	Test Deliverables

-	Test Plan
-	Test Scripts including framework 
- Guideline to run test script

## 4	Resource & Environment Needs
### 4.1	Testing Tools
- Language: Java
- IDE: InteliJ
- Build tool: Maven
- Framework: Cucumber
 
### 4.2	Test Environment
Any PC that could open the link of application


## 5	Terms/Acronyms 
N/A
