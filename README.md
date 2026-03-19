# Portfolio Management API

A robust backend system for managing investment portfolios, assets, and transactions. Built with **Java 17** and **Spring Boot**, this project demonstrates enterprise-grade REST API design, layered architecture principles, and seamless database integration.

**Perfect for**: Learning Spring Boot architecture, REST API best practices, financial backend systems, and database-driven applications.

---

## 🎯 Key Features

✅ **Portfolio Management** - Create and manage multiple investment portfolios  
✅ **Asset Tracking** - Add, update, and monitor assets within portfolios  
✅ **Transaction Recording** - Log buy/sell transactions with full history  
✅ **Performance Metrics** - Track portfolio performance and returns  
✅ **RESTful API** - Clean, standardized HTTP endpoints  
✅ **Data Persistence** - Reliable MySQL database with JPA  

---

## 🛠 Tech Stack

| Layer | Technology | Purpose |
|-------|-----------|---------|
| **Backend** | Java 17 | Modern, type-safe language |
| **Framework** | Spring Boot 3.x | Rapid development & convention over config |
| **Data Access** | Spring Data JPA | Object-relational mapping |
| **Database** | MySQL 8.0+ | Persistent storage |
| **API** | REST | Stateless, scalable communication |
| **Build Tool** | Maven | Dependency management & compilation |

---

## 🏗 System Architecture

The application follows a **layered architecture** pattern for clean separation of concerns:

```
┌─────────────────────────────────────┐
│         Client Application          │
└────────────────┬────────────────────┘
                 │ HTTP Request
                 ▼
┌─────────────────────────────────────┐
│      Controller Layer               │
│  (PortfolioController)              │
│  - Handles HTTP requests            │
│  - Input validation & routing       │
└────────────────┬────────────────────┘
                 │ Business Logic Call
                 ▼
┌─────────────────────────────────────┐
│      Service Layer                  │
│  (PortfolioService)                 │
│  - Business logic & validation      │
│  - Transaction management           │
│  - Data transformation              │
└────────────────┬────────────────────┘
                 │ Database Operations
                 ▼
┌─────────────────────────────────────┐
│      Repository Layer               │
│  (PortfolioRepository)              │
│  - JPA queries & CRUD operations    │
│  - Entity mapping                   │
└────────────────┬────────────────────┘
                 │ ORM Mapping
                 ▼
┌─────────────────────────────────────┐
│         MySQL Database              │
│  - Portfolio | Asset | Transaction  │
└─────────────────────────────────────┘
```

### Architecture Benefits
- **Separation of Concerns** - Each layer has distinct responsibilities
- **Testability** - Easy to unit test each component independently
- **Maintainability** - Changes in one layer don't affect others
- **Scalability** - Easy to add new features and endpoints

---

## 📂 Project Structure

```
portfolio-management-api/
├── src/main/java/com/example/portfolio/
│   ├── controller/
│   │   ├── PortfolioController.java          # REST endpoints
│   │   ├── AssetController.java
│   │   └── TransactionController.java
│   │
│   ├── service/
│   │   ├── PortfolioService.java             # Business logic
│   │   ├── AssetService.java
│   │   └── TransactionService.java
│   │
│   ├── repository/
│   │   ├── PortfolioRepository.java          # Database access
│   │   ├── AssetRepository.java
│   │   └── TransactionRepository.java
│   │
│   ├── model/
│   │   ├── Portfolio.java                    # Entity classes
│   │   ├── Asset.java
│   │   ├── Transaction.java
│   │   ├── dto/                              # Data Transfer Objects
│   │   │   ├── PortfolioDTO.java
│   │   │   └── TransactionDTO.java
│   │   └── exception/                        # Custom exceptions
│   │       └── ResourceNotFoundException.java
│   │
│   ├── config/
│   │   └── JpaConfig.java                    # Spring configuration
│   │
│   └── PortfolioApplication.java             # Main Spring Boot class
│
├── src/main/resources/
│   ├── application.properties                 # Application config
│   ├── application-dev.properties
│   └── application-prod.properties
│
├── src/test/java/                             # Unit & integration tests
├── pom.xml                                    # Maven dependencies
├── README.md
└── .gitignore
```

---

## 🔌 API Endpoints

### Portfolio Endpoints

| Method | Endpoint | Description | Request Body |
|--------|----------|-------------|--------------|
| **POST** | `/api/portfolios` | Create new portfolio | `{ "name": "string" }` |
| **GET** | `/api/portfolios` | List all portfolios | — |
| **GET** | `/api/portfolios/{id}` | Get portfolio details | — |
| **PUT** | `/api/portfolios/{id}` | Update portfolio | `{ "name": "string" }` |
| **DELETE** | `/api/portfolios/{id}` | Delete portfolio | — |

### Asset Endpoints

| Method | Endpoint | Description | Request Body |
|--------|----------|-------------|--------------|
| **POST** | `/api/assets` | Add asset to portfolio | `{ "portfolioId": 1, "symbol": "AAPL", "quantity": 10, "purchasePrice": 150.50 }` |
| **GET** | `/api/portfolios/{id}/assets` | List portfolio assets | — |
| **PUT** | `/api/assets/{id}` | Update asset details | `{ "quantity": 15, "purchasePrice": 155.00 }` |
| **DELETE** | `/api/assets/{id}` | Remove asset | — |

### Transaction Endpoints

| Method | Endpoint | Description | Request Body |
|--------|----------|-------------|--------------|
| **POST** | `/api/transactions` | Record transaction | `{ "assetId": 1, "type": "BUY", "quantity": 5, "price": 150.50, "timestamp": "2024-01-15T10:30:00" }` |
| **GET** | `/api/portfolios/{id}/transactions` | Get transaction history | — |
| **GET** | `/api/transactions/{id}` | Get transaction details | — |

---

## 📝 Request/Response Examples

### Create Portfolio

**Request:**
```bash
curl -X POST http://localhost:8080/api/portfolios \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Retirement Portfolio 2024"
  }'
```

**Response (201 Created):**
```json
{
  "id": 1,
  "name": "Retirement Portfolio 2024",
  "createdAt": "2024-01-15T10:30:00",
  "totalValue": 0.00,
  "assetCount": 0
}
```

### Add Asset

**Request:**
```bash
curl -X POST http://localhost:8080/api/assets \
  -H "Content-Type: application/json" \
  -d '{
    "portfolioId": 1,
    "symbol": "AAPL",
    "quantity": 10,
    "purchasePrice": 150.50,
    "currentPrice": 155.25
  }'
```

**Response (201 Created):**
```json
{
  "id": 101,
  "portfolioId": 1,
  "symbol": "AAPL",
  "quantity": 10,
  "purchasePrice": 150.50,
  "currentPrice": 155.25,
  "totalValue": 1552.50,
  "gainLoss": 47.50
}
```

### Record Transaction

**Request:**
```bash
curl -X POST http://localhost:8080/api/transactions \
  -H "Content-Type: application/json" \
  -d '{
    "assetId": 101,
    "type": "BUY",
    "quantity": 5,
    "price": 155.00,
    "timestamp": "2024-01-15T11:00:00"
  }'
```

**Response (201 Created):**
```json
{
  "id": 1001,
  "assetId": 101,
  "type": "BUY",
  "quantity": 5,
  "price": 155.00,
  "totalAmount": 775.00,
  "timestamp": "2024-01-15T11:00:00",
  "status": "COMPLETED"
}
```

---

## 🗄 Database Schema

The application uses three main entities with the following relationships:

```
PORTFOLIO (One-to-Many) ASSET (One-to-Many) TRANSACTION
   ├─ id (PK)            ├─ id (PK)           ├─ id (PK)
   ├─ name               ├─ portfolio_id (FK) ├─ asset_id (FK)
   ├─ created_at         ├─ symbol            ├─ type
   └─ updated_at         ├─ quantity          ├─ quantity
                         ├─ purchase_price    ├─ price
                         ├─ current_price     └─ timestamp
                         ├─ created_at
                         └─ updated_at
```

### Create Table Statements

**Portfolio Table:**
```sql
CREATE TABLE portfolio (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
```

**Asset Table:**
```sql
CREATE TABLE asset (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  portfolio_id BIGINT NOT NULL,
  symbol VARCHAR(10) NOT NULL,
  quantity DECIMAL(15, 2) NOT NULL,
  purchase_price DECIMAL(15, 2) NOT NULL,
  current_price DECIMAL(15, 2),
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  FOREIGN KEY (portfolio_id) REFERENCES portfolio(id) ON DELETE CASCADE
);
```

**Transaction Table:**
```sql
CREATE TABLE transaction (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  asset_id BIGINT NOT NULL,
  type ENUM('BUY', 'SELL') NOT NULL,
  quantity DECIMAL(15, 2) NOT NULL,
  price DECIMAL(15, 2) NOT NULL,
  timestamp TIMESTAMP NOT NULL,
  status VARCHAR(50) DEFAULT 'COMPLETED',
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (asset_id) REFERENCES asset(id) ON DELETE CASCADE
);
```

---

## 🚀 Getting Started

### Prerequisites
- **Java 17** or higher
- **Maven 3.8+**
- **MySQL 8.0+**
- **Git**

### Installation

**1. Clone the repository:**
```bash
git clone https://github.com/archit-singh/portfolio-management-api.git
cd portfolio-management-api
```

**2. Configure database connection:**

Edit `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/portfolio_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

**3. Create database:**
```sql
CREATE DATABASE portfolio_db;
```

**4. Build the project:**
```bash
mvn clean install
```

**5. Run the application:**
```bash
mvn spring-boot:run
```

**6. Verify startup:**
```
Server running on: http://localhost:8080
```

### Quick Test

```bash
# Create a portfolio
curl -X POST http://localhost:8080/api/portfolios \
  -H "Content-Type: application/json" \
  -d '{"name":"My Portfolio"}'

# List all portfolios
curl http://localhost:8080/api/portfolios
```

---

## 🧪 Testing

Run unit and integration tests:
```bash
mvn test
```

Run specific test class:
```bash
mvn test -Dtest=PortfolioServiceTest
```

Generate test coverage report:
```bash
mvn jacoco:report
```

---

## 📋 Key Classes & Responsibilities

### Model Classes

**Portfolio.java**
```java
@Entity
public class Portfolio {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  
  @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL)
  private List<Asset> assets;
  
  // Getters, setters, constructors...
}
```

**Asset.java**
```java
@Entity
public class Asset {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String symbol;
  private BigDecimal quantity;
  private BigDecimal purchasePrice;
  
  @ManyToOne @JoinColumn(name = "portfolio_id")
  private Portfolio portfolio;
  
  // Getters, setters, constructors...
}
```

**Transaction.java**
```java
@Entity
public class Transaction {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Enumerated(EnumType.STRING)
  private TransactionType type; // BUY, SELL
  
  private BigDecimal quantity;
  private BigDecimal price;
  private LocalDateTime timestamp;
  
  @ManyToOne @JoinColumn(name = "asset_id")
  private Asset asset;
  
  // Getters, setters, constructors...
}
```

### Service Classes

**PortfolioService.java** - Orchestrates portfolio operations, validates data, manages transactions

**AssetService.java** - Handles asset creation, updates, and valuation calculations

**TransactionService.java** - Records transactions, updates asset quantities, maintains history

---

## 🔒 Security Considerations

This is a foundation API. For production, add:

- ✅ **Spring Security** - Authentication & authorization
- ✅ **JWT Tokens** - Stateless authentication
- ✅ **HTTPS/TLS** - Encrypted communication
- ✅ **Input Validation** - Prevent injection attacks
- ✅ **Rate Limiting** - Prevent abuse
- ✅ **CORS Configuration** - Control cross-origin requests

---

## 📈 Future Enhancements

- [ ] **Spring Security & JWT Authentication** - Secure API endpoints
- [ ] **Swagger/OpenAPI Documentation** - Interactive API docs with Swagger UI
- [ ] **Docker Support** - Containerized deployment
- [ ] **Advanced Analytics** - Portfolio returns, volatility, diversification metrics
- [ ] **Caching Layer** - Redis for performance optimization
- [ ] **Event-Driven Architecture** - Kafka for async processing
- [ ] **Microservices Migration** - Break into independent services
- [ ] **Mobile App Integration** - Native iOS/Android apps
- [ ] **Real-time Price Updates** - WebSocket integration
- [ ] **Audit Logging** - Track all changes for compliance

---

## 🤝 Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request



## 👨‍💻 Author

**Archit Singh**  
Backend Developer | Java | Spring Boot | REST APIs  
📧 Email: archit@example.com  
🔗 GitHub: [@archit-singh](https://github.com/archit-singh)  
💼 LinkedIn: [archit-singh](https://www.linkedin.com/in/archit-singh/)

---

## 📞 Support & Contact

- 📧 **Email**: archit@gmail.com
---

**Last Updated**: January 2024  
**Version**: 1.0.0
