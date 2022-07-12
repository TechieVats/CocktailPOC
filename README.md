## DERIVCO API Assessment

This README would normally document whatever steps are necessary to get your application up and running.


## Set up

clone the repository into Intellij IDEA using version control

## Execution
Use TestRunner to execute the test and to generate the reports

### What is this repository for? ###
Assessment for Derivco

1 . CockTailDB API Automation
    1.Test scenarios has been mentioned in the feature file named Cocktail.feature.
    2.Implementation for the same is available in : src/test/java/StepDefinitions/Cocktail.java
    3.Path for feature file : src/test/resources/features/Cocktail.feature
    4. Pojo classes has been implemented to handle the response elements.


## Validations performed

1. Status code validation for each call
2. Message validation for response wherever required.
3. Applicable assertions has been placed using AssertJ.
4. Schema validation performed for each call. Schema stored into schema package under test resources.

## Scenarios Coverage
1. Mentioned Scenarios:
   1. To verify that the user is able to search the ingredients by name
   2. To verify that user is able to search the cocktails by name
2. Extra Scenarios
   1. To verify that the user is able to filter the cocktails by nature of alcohol content
   2. To verify that the user is able to lookup a random cocktail


## Coding Standards

1.Reusable functions: Reusable functions has been defined in the "utils" package under "APIUtility.java". To decrease the
complexity of the code.
2.Clean code: to make sure the code should look clean and will be easy to maintain , all the functions has been
named meaningfully to avoid unnecessary comments within the code.

## Logging

log4j2 has been used to perform logging in the framework to showcase the flow the tests which are running.

## Report
report for test execution has been present in report directory under the name ExecutionReport.html.

## Configuration
This directory has been created to declare variables globally

## CICD Configuration
All the test undertag @API can be run under the circleCI pipeline each time when a user make a push into the repository(GitHub).

## Tools
API Automation : Rest Assured
Reporting: Extent Reports
Build Tool: Maven
BDD: Cucumber
IDE: Intellij IDEA
Testing Framework: Junit
Assertion Library: AssertJ
Language : Java
Logging  : log4j2
CICD: CircleCI
Version Control: GitHub

## Nonfunctional Test 
1. 1000 users making a request for a random cocktail- It can be performed via rest assured as well.
2. Security testing to check for any vulnerabilities or authorization issues while accessing the api from an external environment-
   Assumptions made- cocktail api have a basic auth either using credentials/token/api key.
