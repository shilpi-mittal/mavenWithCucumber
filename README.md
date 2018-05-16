# mavenWithCucumber #

This is a demo framework for test suite using Selenium Webdriver, TestNG and Cucumber JVM, using Maven.

#### Page object model 
is used to segregate page dependent information from test logic.
For each pages there should be one pageObject, listing all elements locators and the methods on those elements.

There are two modules under testModule:
*	Under functional module:
	*	Page objects are grouped at /src/main/java/pageObjects
	*	The functional tests on these pages are grouped at /src/test/java/functional
	*	Step definitions for Cucumber steps are at /src/test/java/stepDefinitions
	*	And Cucumber  feature file is at /src/test/resources/features 
*	Under TestCore module, we have utils, or say helpers, for our test cases, at /src/main/java/utils. All external methods are wrapped under utils method to save rework due to deprecated methods in upgraded versions. 

* Test cases are written in Java using Selenium Webdriver.
* To run test code, TestNG suite is written.
* Above test code a BDD layer is provided with the help of Cucumber JVM. To run the tests feature files can be executed.

### To run java test using IDE ###
*	only selenium jars are reqd.

### To compile a cucumber feature file ##
*	only cucumber-java-1.1.2.jar is reqd. 
*	make sure you have ‘cucumber for java’ plugin

### To run Cucumber scenario using IDE ###
*	cucumber-core-1.1.6.jar is reqd. and other jars too
*	go to run - edit config and add a configuration for cucumber java, set its main class as cucumber.api.cli.Main and feature/folder path as the path of feature file

# Maven #
It's a build tool. Each project/sub-project has a pom file, which is named as 'pom.xml'.  It specifies the dependencies required and tasks performed by the sub-project.

### to resolve dependencies ###
*	on console cd into the project and run 
    * mvn clean verify
    * mvn idea:idea
*	now dependencies should be resolved and you should be able to write tests

### Managing multiple build files ###
This project contains multiple sub-projects dependent on each other. Each sub-project has its own pom file. To manage this,
*	mention sub-modules in pom file as follows:
    * <modules>
    * <module>functionalTests</module>
    * <module>testCore</module>
    * </modules>
* or say,
    * <modules>
    * <module>testModule</module>
    * </modules>
* in the pom file of dependent module (eg. In functionalTestspom file as functional tests are dependent on testCore), add the following in dependencies:
    * <dependency>
    * <groupId>${project.parent.groupId}</groupId>
    * <artifactId>testCore</artifactId>
    * <version>${project.parent.version}</version>
    * </dependency>

In pom file for functionalTests module, we will mention the tasks/profiles for our test cases.
### to run testNG task ###
To run TestNG tests, we can create a profile in two ways
*	Using suite.xml file
	*	Suite.xml files help to group different TestNG test cases under different suites, it is located at
	*	testNGTest profile executes this suite
	*	To execute the task,
		* cd into the module, and say
		* mvn test –PtestNGTest
*	Using group tags
  * One can mention group names, or
	*	One can dynamically pass the group name via command line when executing the task. Only those tests will run which have the mentioned group tagged to them. 
	* To execute the task,
		* cd into the module, and say
		* 	mvn test -Ptesting -Dgroup=testNG

### to run cucumber task ###
*	To run cucumber feature file, create a profile mentioning either a feature file, or regex
*	Please refer profile with id 'cucumberTests' for the same .
*	To execute the task,
	  * cd into the module, and say
	  * mvn test -PcucumberTests
