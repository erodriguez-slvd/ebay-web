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
<!-- USEFUL DOCUMENTATION -->
## Useful Documentation

* [eBay](https://www.ebay.com)
* [Selenium](https://www.selenium.dev/documentation/overview/)
* [Selenium Github Example](https://github.com/SeleniumHQ/seleniumhq.github.io/tree/trunk/examples)
* [TestNG](https://testng.org/doc/documentation-main.html)
