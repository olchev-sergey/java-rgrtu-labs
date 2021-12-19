# Spring RESTful Application
A RESTful API Application built on Spring Framework. When running this application a command line runner will be excetuted in order to populate the in-memory SQL database with entries from a JSON file. The resource of RESTful API is **People**, which will response JSON structure data based on endpoints.


## Technologies used:
  * Language: **Java**
  * Development Kit: **Java SDK 8**
  * Framework: **Spring Framework**
  * Build Automation Tool: **Apache Maven**
  * Database: **H2 (In-Memory)**
  * ORM: **Hibernate**
  * Unit Testing Framework: **JUnit**
  * Service API: **REST**
  * REST Testing Library: **REST Assured**
  * IDE: **IntelliJ IDEA (Ultimate Edition)**

## Getting Started
These instructions will get you a copy of the project up and running on you local machine for development and testing purposes.

## Local Installation
### Prerequisites
  #### Required
   * Java SDK 8
   * Java IDE (IntelliJ IDEA recommended)
   * Git
  #### Optional
   * Apache Maven
   * Spring Boot

**Note: If you want to use command line to run application and tests you need to install softwares mentioned in Optional above**

## Installing and Running Application
Please follow carefully step by step instructions below in order to get the app up and running locally.

1. Open Terminal

2. Get a clone of this project in local machine:
 ```
 git clone https://github.com/arianithetemi/spring-rest-app.git
 cd spring-rest-app.git
 ```
* Running application with IDE:
   - Open this project folder with any Java IDE (IntelliJ IDEA recommended)
   - Run the application using IDE Run Option
   
* Running the application with Command line:
   - Open Terminal
   - Change Directory to the project directory in terminal
   - Run the command below:
 ```
  sudo mvn spring-boot:run
 ```
 
**Note: After running the application please read the API documentation below the "Running Test Section"**
## Running Tests
For now there are three unit test cases for testing REST API.
Follow the instructions below in order to run automated tests.

 * Running tests with IDE:
    * Run with any IDE the "RestappApplicationTests.java" file located in project location "spring-rest-app/src/test/com.arianit.restapp/".
 * Running tests with command line:
    * Open the Terminal
    * Change directory to the project directory in terminal
    * Run the command below:
 ```
  sudo mvn test
 ```
 
 ## API Documentation 
 **Localhost base URL: http://localhost:8080**
 
 **Note: In order to test API RESTful Endpoints you need to use an HTTP Client Tool, Postman is recommended**
 
 ### Show People
 Returns json list of people data
 
 * **URL**
 
    /api/people/
    
 * **Method:**
    
    `GET`
    
 * **Success Response:**

    * **Code**: 200
    
      **Content:** 
      
      ```json
      [{
            "id": 1,
            "name": "Keeley Bosco",
            "email": "katlyn@jenkinsmaggio.net",
            "city": "Lake Gladysberg",
            "mac": "08:fd:0b:cd:77:f7",
            "timestamp": "2015-04-25 13:57:36 +0700",
            "creditcard": "1228-1221-1221-1431"
       }, {...}]
       ```
  
### Show Person
Returns json of a specific Person data based on its id
 
* **URL**
 
   /api/people/:id
   
*  **URL Params**

   **Required:**
 
   `id=[integer]`
    
* **Method:**
    
   `GET`
    
* **Success Response:**

   * **Code**: 200
    
     **Content:** 
      
     ```json
     {
          "id": 5,
          "name": "Dr. Araceli Lang",
          "email": "mavis_lehner@jacobi.name",
          "city": "Yvettemouth",
          "mac": "9e:ea:28:41:2a:50",
          "timestamp": "2015-04-25 21:02:11 +0700",
          "creditcard": "1211-1221-1234-2201"
      }
      ```

### Create Person

  Create new Person from json structure with values sent in body of request

* **URL**

  /api/people/

* **Method:**

  `POST`

* **Body Data (application/json)**

  ```json
     {
          "name": "John Doe",
          "email": "johndoe@gmail.com",
          "city": "Gjilan",
          "mac": "9e:ea:28:41:2a:50",
          "creditcard": "1111-2222-3333-4444"
      }
   ```
* **Success Response:**

  * **Code:** 200 <br />
    **Content:** 
    
    ```json
     {
        "id": 51,
        "name": "John Doe",
        "email": "johndoe@gmail.com",
        "city": "Gjilan",
        "mac": "9e:ea:28:41:2a:50",
        "timestamp": "2018-02-27 20:24:32 675+0100",
        "creditcard": "1111-2222-3333-4444"
      }
      ```
      
### Update Person Data

  Updates the values sent as json in request body of a specific Person by its ID, returns updated json Person structure

* **URL**

  /api/people/:id

* **Method:**

  `PUT`
  
* **URL Params**

  **Required:**
 
  `id=[integer]`

* **Body Data (application/json)**

  ```json
     {
        "name": "John Doe",
        "email": "johndoe@gmail.com",
        "city": "Prishtine"
     }
   ```
* **Success Response:**

  * **Code:** 200 <br />
    **Content:** 
    
    ```json
     {
        "id": 5,
        "name": "John Doe",
        "email": "johndoe@gmail.com",
        "city": "Prishtine",
        "mac": "9e:ea:28:41:2a:50",
        "timestamp": "2015-04-25 21:02:11 +0700",
        "creditcard": "1211-1221-1234-2201"
     }
    ```
    
### Delete Person
Deletes Person by its ID and returns a message if deleted successfully
 
* **URL**
 
   /api/people/:id
    
* **Method:**
    
   `DELETE`
   
* **URL Params**

  **Required:**
 
  `id=[integer]`
    
* **Success Response:**

   * **Code**: 200

     **Content:** 

     ```json
         {"message": "Person successfully deleted!"}
      ```
 
### Sort People Data
Returns json of people data sorted naturally by its name
 
* **URL**
 
   /api/people/sort/name
    
* **Method:**
    
   `GET`
    
* **Success Response:**

   * **Code**: 200

     **Content:** 

     ```json
     [{
         "id": 32,
         "name": "Alec Howell",
         "email": "derick.gaylord@beer.name",
         "city": "South Hollyport",
         "mac": "ca:8c:24:ef:65:98",
         "timestamp": "2015-04-25 00:38:05 +0700",
         "creditcard": "1234-2121-1221-1211"
         }, {...}]
      ```
      
## Accessing H2 DBMS
If you want to see the database you need to access into the H2 Console DBMS
Follow the instructions below:

1. Run the application
2. Go to http://localhost:8080/console
3. In **JDBC URL** input write: **jdbc:h2:mem:mydb;**
4. Click **Connect** and you have access to the data of in-memory database of this App
    
**Note: The database is in-memory database so when restarting the application the new or modified data added in database will be removed!**
   
 ## Author
  * **Arianit Hetemi**
