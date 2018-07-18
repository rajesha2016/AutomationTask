# UI and API AutomationTask:

Tools & Frameworks used:

Eclipse Editor- Oxygen.2 Release(4.7.2),

TestNg framework- v6.14.3,

Design Pattern- Singleton Design Pattern of JAVA  & Page Object Model, 

Selenium-WebDriver,

Build Tool- Maven

# Framework Understanding:

I have used Singleton Design Pattern of Java to have one session of WebDriver. The implemented class is WebDriverSingleton.java inside "leverton.automation.framework package".

Page Object Model to store all webelements of Login page InvalidUILoginPage.java and action inside test class InvalidUILoginTest.java for UI test.

I am using TestNG framework to write my test for both UI & API. TestInitialization.java class initialize the test for TestNG @BeforeTest pass the AUT URL and @AfterTest close all session of browser. Utilities.java class has all necessary methods that are needed for both UI & API test.

TestDataProviderClass.java is the Test data class for both UI & API tests. TestNG @DataProvider annotation used for Parameterizing the tests.

config.properties file holds the URL of both UI & API.

# Test Execution:

Note: I have developed in Windows OS, if you are running this project in Mac OS request to change in following two places.
1. Inside 'WebDriverSingleton.java' class constructor where chromedriver.exe path has mentioned. Change the statement ' System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\\chromedriver.exe"); ' to ' System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chromedriver.exe"); ' as per Mac OS standard
2. 'Utilities.java' class inside initConfig() method where config.properties file path has mentioned. Change the statement ' FileInputStream readConfig = new FileInputStream(System.getProperty("user.dir")+ "\\\config.properties"); ' to ' FileInputStream readConfig = new FileInputStream(System.getProperty("user.dir")+ "/config.properties"); ' as per Mac OS standard


Clone or download project from the GITHUB url to eclipse and right click on the testng.xml file inside the "com.automation.task" project and run as TestNG Suite. It will run both API and UI test. Another way is run respective classes invdividually from eclipse "InvalidUILoginTest.java" and "CountryValidationAPITest.java"

