## :cake: Bakery Management Application

A full-stack bakery management system application, complete with a data-driven dashboard, a product form, menu, and a user-friendly pink-and-green interface.

## :sparkles: Technologies
| Frontend       | Backend           | Database  | Other / Frameworks      |
|----------------|-----------------|-----------|------------------------|
| HTML           | Spring Boot      | MySQL     | JSP                    |
| CSS            | Java Servlets    |           | JPA                    |
| JavaScript     |                  |           | JQuery                 |

## :rocket: Features
* View data-driven dashboard about product variety and stock
* View the company home page and a detailed product menu
* Use the Bakery API form to:
   * get all products
   * add a new product
   * update an existing product
   * delete a product using its ID

## :pushpin: The Process
I started by designing the backend architecture using Spring Boot, setting up the Model-View-Controller (MVC) structure to handle application data, business logic, and routing efficiently.
I then created the application pages, implementing the user interface with HTML, CSS, and JavaScript, and applied styling to ensure a clean, user-friendly experience. After the main functionality was in place, I added unit tests for the product repository using JUnit 5 and AssertJ, covering CRUD operations to ensure data integrity and reliable backend behavior.

## :mag: Running the Project
After cloning the repository, you can run the Bakery Application in one of two ways:
### Option 1: Run the packaged JAR
1. Navigate to the project directory containing `pom.xml`:
```
cd bakery/bakery
```

2. Build the project:
```
mvn clean package
```
3. Run the application:
```
java -jar target/bakery-0.0.1-SNAPSHOT.jar
```
4. Open your browser and visit:
```
http://localhost:8081/products
```
### Option 2: Run with Spring Boot Devtools (auto-reload)

1. Ensure the following line is present in src/main/resources/application.properties:
```
spring.devtools.restart.enabled=true
```
Make sure the Spring Boot Devtools dependency is included in pom.xml.

2. Run the application directly:
```
mvn spring-boot:run
```

3. Open your browser and visit:
```
http://localhost:8081/products
```

## :open_file_folder: Preview

https://github.com/user-attachments/assets/98654124-aabb-45d2-8827-763483a5fb43
