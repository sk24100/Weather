## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)
* [Execution of Project](#execution)
* [Defects in Weather API](#defects)
* [Defects in PHPTravels](#defects)
 

## General info
 * This project is about testing the wheather API using Rest Assured.
 * Creating automation framework for UI based testing on PHPTravels.net in JAVA.
	
## Technologies
Project is created with:
* Concepts of JAVA
* Rest Assured concepts for creating framework for validation the API scenarios.
* Page Object Design Patter (POM) for creating automation framework for UI testing.
* Extent Reports for reporting purpose of the entire suite.
	
## Setup

* **Clone repository:**

        git clone https://github.com/sk24100/Wheather/tree/Saurabh-QloyalCodeTest
 
* **Prerequisites:**
    * Install the latest version of [Java](https://java.com) (1.8) and [Maven](https://maven.apache.org/download.html).
    * Set the environment variable: 
    * You may need to set your `JAVA_HOME`and `MAVEN_HOME`


After you done with it you have to do **mvn clean test**
* $ mvn clean
* $ mvn test

## Execution of Project

  Maven project will trigger the POM.xml and which in turn will run the Testng.xml suite. Testng contains 2 tests namely -
  
  1) _api-test_
  2) _ui-smoke-test_

## Defects in Weather API

  1) API is still returing data on passing negative value of Postal code in Request Params.
  

## Defects in PHPTravels
 1) Travellers input field data doesnt change on entering the value in the field ( Without clicking on + and - buttons ).
 2) After entering the data for Hotel search based on City and hitting on Submit, the corresponding page list of options appear but City name dissappears in the search box. Though, checkin and checkout data remains intact.
 3) Clearing of filter options is not there.
 4) Star Grade and Price based filters not working.
 5) On entering City in the filter page and hitting on Search button Checkin and Checkout dates changes to 1970 and no search data returned.
 6) On Hotel details page clicking on search again is autopopulating value in Children field to 1.
 
 **I tried booking the hotel with dummy credit card but i was unable to proceed further. Hence, i have only included my scripts till Booking page.**
 

