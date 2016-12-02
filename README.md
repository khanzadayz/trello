# Automation using page object pattern

## Page Object Model
POM a design pattern of creating an Object Repository for web UI elements.
Each web page has a corresponding page class.
The Page class will find the WebElements of that web page and also contains Page methods which perform operations on those WebElements.

## Automation tests scenario steps (total steps: 18)
- Trello website is opened and user logs in with credentials.
- A new board is created with name containing current date/time.
- 3 Priority tasks as created with Priority 1, 2 and 3 accordingly.
- 6 tasks are added to Priority 1 list.
- Comments are added to all the tasks.
- 2 tasks from Priority 1 list are moved to Priority 2 list.
- 2 tasks from Priority 1 list are moved to Priority 3 list.

## Prerequisites
- Java8
- windows or ubuntu OS
- maven

## Libraries
- Java8
- Selenium and misc libraries are included as maven dependencies.

## Test execution
- mvn compile
- mvn test (to run all test scenarios)
- right clicking in intellij idea and running single feature file
- RunCukesTest to run all scenarios.

## Browser
- tests uses Chrome browser and will should run on windows or linux machines
- tests could be executed on phantomjs (browserless exection) with a little bit of change in the java classes.

## Reporting
- Test report can be created using intellij built-in reports (in Run sidebar) or surefire reports in target folder
- Reports can be generated using ``mvn surefire-report:report`` or ``mvn site`` (full testing and dependency report)
- Extended reports are created in ``output/Run_***/report.html`` after executing RunCukesTest. Reports are not overwritten by each other. 

## Test execution in Jenkins (Selenium grid)
- Jenkins ready!!
