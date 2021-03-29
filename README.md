# MakeMyTripAssignment
Make My trip assignment

Purpose- perform automation testing for flight booking and application login

Programming Language- Java

Project Management Tool- Maven
groupID- com.learn
ArtifactID- MakeMyTripAssignment

Dependency- Selenium,TestNG

DriversExe= contains different executables for different browser and Os TYPE.

"Source" folder consist

1. Config Loader- Helps in loading configuration properties of project.
2. Constants- contains static data and test data.
3. Driver setup- It does Webdriver creation based on OS type and browser type.
4. Page Events- Contains locators of Web pages
5. Page Operations- Contains classes to interact with web page with Webelements.(Page Object Model Pattern)
6. Utils- contains Selenium utils, Properties utils, generic utils.

"Test" folder consist

1. Base Test- Parent class of all test class for driver setup and driver quit job and perform actions which are common in all test classes.
2. Test class- FlightBookingTest and LoginTest contains assertions for automated test cases using TESTNG
3. xml- contains testng.xml for executing Test module "Flight booking" and "Login Test".

