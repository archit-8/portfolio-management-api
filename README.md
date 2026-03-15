# Portfolio Management API

A backend application built using **Java and Spring Boot** that allows users to manage investment portfolios, track assets, and record transactions.

This project demonstrates **REST API design, layered architecture, and database interaction**, similar to systems used in financial platforms.

---

## Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- Maven
- MySQL
- REST API
- Docker (optional)

---

## System Architecture

The application follows a **layered architecture**.

Client → Controller → Service → Repository → Database

### Layers

**Controller Layer**
- Handles HTTP requests
- Exposes REST API endpoints

**Service Layer**
- Contains business logic
- Processes portfolio operations

**Repository Layer**
- Communicates with database
- Uses Spring Data JPA

**Database**
- Stores portfolio and transaction data

---

## Request Flow

1. Client sends API request
2. Controller receives request
3. Service layer processes business logic
4. Repository interacts with database
5. Response returned to client

---

## Project Structure


```
portfolio-management-api
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           └── portfolio
│   │   │               ├── controller
│   │   │               │   └── PortfolioController.java
│   │   │               │
│   │   │               ├── service
│   │   │               │   └── PortfolioService.java
│   │   │               │
│   │   │               ├── repository
│   │   │               │   └── PortfolioRepository.java
│   │   │               │
│   │   │               ├── model
│   │   │               │   └── Portfolio.java
│   │   │               │
│   │   │               └── PortfolioApplication.java
│   │   │
│   │   └── resources
│   │       └── application.properties
│
└── pom.xml
```



---

## Features

- Create Portfolio
- Add Assets to Portfolio
- Record Transactions
- Track Portfolio Performance
- View Transaction History

---

## API Endpoints

| Method | Endpoint | Description |
|------|------|------|
| POST | /portfolio | Create new portfolio |
| GET | /portfolio/{id} | Get portfolio details |
| POST | /transaction | Add transaction |
| GET | /transaction/history | Get transaction history |

---

## Example API Request

### Create Portfolio

POST /portfolio

Request

```json
{
  "name": "Retirement Portfolio"
}
```
Response
```json

{
  "id": 1,
  "name": "Retirement Portfolio"
}
```
Database Design

Main tables used in the system

Portfolio

Asset

Transaction

Relationships

Portfolio → contains → Assets
Portfolio → records → Transactions

How to Run the Project

Clone the repository
```json
git clone https://github.com/yourusername/portfolio-management-api
```
Move to project folder
```json
cd portfolio-management-api
```
Build project
```json
mvn clean install
```
Run Spring Boot application
```json
mvn spring-boot:run
```
Server will start on
```json
http://localhost:8080
```
Future Improvements

Authentication using Spring Security

Portfolio analytics

Docker container deployment

API documentation using Swagger

Author

Archit Singh

Backend Developer
Java | Spring Boot | REST APIs

