# Blog Application - Backend

A REST API for a blog app, built with Spring Boot.

## Tech Stack
- Java
- Spring Boot
- Spring Data JPA
- Spring Security (Basic Auth)
- Maven
- MySQL

## Features
- Get all posts
- Create, update and delete posts
- Create, update and delete need login (Basic Auth)

## How to Run
1. Install Java and Maven.
2. Create a database and update `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_db_name
spring.datasource.username=your_username
spring.datasource.password=your_password
```

3. Run the app:

```bash
mvn spring-boot:run
```

4. The API runs on `http://localhost:8080`.

## Frontend
Frontend repo: https://github.com/InukolluKiranKumar/BLOG-APPLICATION_FRONTEND
