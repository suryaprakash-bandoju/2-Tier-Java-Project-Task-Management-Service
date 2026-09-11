# Task Management Service

A simple Task Management REST API built using Java and Spring Boot.

## Technologies

- Java 17
- Spring Boot
- Maven
- Spring Web
- JUnit 5

## Features

- Create tasks
- View all tasks
- View a task by ID
- Update tasks
- Delete tasks
- Unit tests

## Project Structure

```text
src/
├── main/
│   └── java/
│       └── com/example/taskmanagement/
│           ├── TaskManagementApplication.java
│           ├── controller/
│           │   └── TaskController.java
│           ├── service/
│           │   └── TaskService.java
│           ├── model/
│           │   └── Task.java
│           └── repository/
│               └── TaskRepository.java
│
└── test/
    └── java/
        └── com/example/taskmanagement/
            └── TaskServiceTest.java