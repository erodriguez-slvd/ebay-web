<!-- PROJECT LOGO -->
<div align="center">
  <h1 align="center">eBay</h1>
  <p align="center">Web Testing Project pure Selenium</p>
</div>

<!-- TABLE OF CONTENTS -->
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
   <li><a href="#implementation-details">Implementation details</a></li>
   <li><a href="#useful-documentation">Useful Documentation</a></li>
  </ol>

<!-- ABOUT THE PROJECT -->
## About The Project

The project focuses on testing the eBay website, using core testing tools such as Selenium WebDriver in Java. The goal of the project is to improve testing skills and gain experience in web testing.

### Built With

* Programming Language: Java
* Build Tool: Maven
* Frameworks: Selenium WebDriver

### Prerequisites

- [ ] Install Java +11
- [ ] Install and configure [Apache Maven 3.6.0+](http://maven.apache.org/)
- [ ] Add the selenium-java and testng dependencies to the pom.xml

### Installation

- [ ] Clone the repo.
- [ ] Run mvn clean install in terminal.

<!-- IMPLEMENTATION DETAILS -->
## Implementation details

### Switch to new window

- Clicking a link which opens in a new window will focus the new window or tab on screen, but WebDriver will not know which window the Operating System considers active. To work with the new window you will need to switch to it.

```
    Set<String> handles=driver.getWindowHandles();
    Iterator it=handles.iterator();
    String parent= (String) it.next();
    String child= (String) it.next();
    driver.switchTo().window(child);
```
### WebDriverWait

- Sometimes webpage takes more time than the speed of webdriver and in such cases we face Exceptions such as TimeoutException, NoSuchElementFoundException etc. Synchronization in selenium in achieved by using waits.
- The WebDriver is directed to wait until a certain condition occurs before proceeding with executing the code.

```
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    wait.until(ExpectedConditions.elementToBeClickable(locator));
```
### Screenshot with Selenium and TestNG Listeners

- To capture screenshots in Selenium, one has to utilize the method TakesScreenshot. This notifies WebDriver that it should take a screenshot in Selenium and store it.
1. Add **commons-io** dependency to the pom.
2. Create a class that implements ITestListener. In this project it is done in BaseTest.
3. Override the **onTestFailure** method.
4. Add the code to take a screenshot with this method.
5. Get the Test method name and take a screenshot with the test name. Then place it in the desired destination folder.
6. Finally, add the annotation @Listeners(BaseTest.class) to the Test classes.

### Selenium Grid

- Selenium Grid allows the execution of WebDriver scripts on remote machines by routing commands sent by the client to remote browser instances. 
- Grid aims to:
  Provide an easy way to run tests in parallel on multiple machines
  Allow testing on different browser versions
  Enable cross-platform testing
- When to use Grid? To run your tests in parallel, against different browser types, browser versions, operating systems. To reduce the time needed to execute a test suite 
#### Setup
1. Prerequisites: Java 11+, browser installed, browser driver downloaded.
2. Download the Selenium Server jar file from the latest release.
3. Start the Grid using the command: java -jar selenium-server-<version>.jar standalone
4. Verify the hub is running opening your browser in http://localhost:4444/.
5. Point your WebDriver tests to http://localhost:4444

<!-- USEFUL DOCUMENTATION -->
## Useful Documentation

* [eBay](https://www.ebay.com)
* [Selenium](https://www.selenium.dev/documentation/overview/)
* [Selenium Grid](https://www.selenium.dev/documentation/grid/)
* [Selenium Grid Setup Tutorial](https://medium.com/maestral-solutions/selenium-grid-setup-the-complete-guide-cf000a2be50f)
* [Selenium Github Example](https://github.com/SeleniumHQ/seleniumhq.github.io/tree/trunk/examples)
* [TestNG](https://testng.org/doc/documentation-main.html)
