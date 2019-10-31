# Getting Started
 This project is CodeMe Challenge .

## Technologies 
  * Spring Boot WebFlux ( For Async process)
  * Swagger 
  * Junit/Mockito
  * Spring Global handling
  * Microservices Architecture
  

## Installation steps 
* Install the gradle for building this project 
* Install the postman to call the api GET method  (http://localhost:8080/api/transactions?accountID=ACC334455&fromDate=20/10/18 11:47:23&toDate=20/10/18 17:47:23)

* Update the input.csv file under resources folder with required data .

* This project is developed using SpringBoot WebFlux using microservices architecture .
It can be executed as a Microservices or directly standalone java file can be used .
It supports both formats .
 
* Test/Junits are implemented using mockito framework (Both unit and integration testing is done) .

* Exception handling has been implemented using controller advice . 

* Swagger has been implemented , the api spec can be viewed from the below url's
   
   
   http://localhost:8080/v2/api-docs
   http://localhost:8080/swagger-ui.html#!/transactions-controller/transactionsUsingGET
   

## Execution steps 
* Command to build and test the project  : gradle clean build . 
* To run project using command line 

./gradlew bootrun
 
For Standalone execution Please follow below steps . 
By giving inputs directly in the InterviewApplicationStandAlone.java file and execute the program . 
 
 
 
## Assumptions : 

Expecting the date format will be correct . If format is wrong then it will throw the exception.
