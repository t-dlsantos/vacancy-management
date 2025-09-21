# Vacancy Management API

A Spring Boot REST API for managing job vacancies, where companies can post jobs and candidates can apply for positions.

## 🚀 Overview

This is my first project using the Spring Boot framework. It's a job vacancy management system that allows companies to create job postings and candidates to apply for them.

## 📋 Features

- **Company Management**
  - Company registration and authentication
  - Create and manage job postings

- **Candidate Features**
  - Candidate registration and authentication
  - Apply for job positions

## 🛠 Technologies

- **Spring Boot** - Main framework
- **Spring Security** - Authentication and authorization
- **PostgreSQL** - Database
- **Docker** - Containerization
- **Maven** - Dependency management
- **Swagger/OpenAPI** - API documentation

## 📝 API Documentation

The API is documented using Swagger/OpenAPI. You can access the documentation by running the application and visiting:

```
http://localhost:8080/swagger-ui.html
```

### API Documentation Screenshot

![Swagger Screenshot](/swagger_ui.png)

## 🚦 Getting Started

### Prerequisites

- Java 21
- Docker and Docker Compose
- Maven

### Running the Application

1. Clone the repository
    ```bash
   git clone https://github.com/t-dlsantos/vacancy-management.git
    ```
2. Start the database using Docker Compose:
   ```bash
   docker-compose up -d
   ```
3. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```

The application will be available at `http://localhost:8080`