##  AdvancedAutomationFramework 
[ Selenium Test Automation Boilerplate] 

Ready-to-use UI Test Automation Architecture using Java and Selenium WebDriver.

This framework provides a boilerplate project to build UI test automation scripts using Selenium WebDriver with Java as programming language. It implements the Page Object Model design pattern for better test maintenance.

The framework provides an easy way to start writing UI test automation scripts with Selenium WebDriver in Java. It comes with a sample test script that shows how to use Page Objects to interact with web page elements.

## Key Features:

- Implements Page Object Model design pattern
- Provides a sample test script with Page Objects 
- Modular and scalable framework architecture
- Detailed logging using Log4j
- Centralized configuration using properties file
- Supports test execution on multiple browsers
- Integrates with TestNG for test management
- Contains utility classes for common test actions

The framework can be easily extended as per your project needs. It aims to reduce boilerplate code and provide a structured way of writing maintainable UI test automation scripts with Selenium and Java.

## Languages and Frameworks

The project uses the following:
- *[Java 11](https://openjdk.java.net/projects/jdk/11/)* as the programming language.
- *[Selenium WebDriver](https://www.selenium.dev/)* as the web browser automation framework using the Java binding.
- *[Univocity Parsers](https://www.univocity.com/pages/univocity_parsers_tutorial)* to parse and handle CSV files.
- *[TestNG](https://testng.org/doc/)* as the testing framework.
- *[AssertJ](https://assertj.github.io/doc/)* as the assertion library.
- *[Lombok](https://projectlombok.org/)* to generate getters.
- *[Owner](http://owner.aeonbits.org/)* to minimize the code to handle properties file.
- *[Extent Reports](https://www.extentreports.com/)* as the test reporting strategy.
- *[Selenium Shutterbug](https://github.com/assertthat/selenium-shutterbug)* for capturing screenshots.
- *[Gradle](https://gradle.org/)* as the Java build tool.
- *[IntelliJ IDEA](https://www.jetbrains.com/idea/)* as the IDE.

## Project Architecture
- [Config](#config)
- [Data](#data)
- [Driver](#driver)
- [Page](#page)
- [Report](#report)
- [Test](#test)
- [Workflow](#workflow)

## Project Structure
```

AdvancedAutomationFramework [ Selenium Test Automation Boilerplate] 

├───.apt_generated
├───.idea
├───.vscode
├───reports
├───src
│   ├───main
│   │   └───java
│   │       └───org
│   │           └───miteshdandade
│   │               ├───AbstractComponents
│   │               ├───pageobjects       
│   │               └───resources
│   └───test
│       └───java
│           ├───data
│           └───org
│               └───miteshdandade
│                   ├───data
│                   ├───TestComponents
│                   └───tests
├───target
│   ├───classes
│   │   └───org
│   │       └───miteshdandade
│   │           ├───AbstractComponents
│   │           ├───pageobjects
│   │           └───resources
│   ├───generated-sources
│   │   └───annotations
│   ├───generated-test-sources
│   │   └───test-annotations
│   └───test-classes
│       ├───data
│       └───org
│           └───miteshdandade
│               ├───data
│               ├───TestComponents
│               └───tests
└───testSuites

```