# Quantity Measurement App

A production-ready REST API for performing unit conversions, comparisons, and arithmetic across physical quantities — Length, Weight, Volume, and Temperature. Built with Spring Boot 3 and secured with JWT authentication and Google OAuth2.

---

## Live Demo

| Service | URL |
|---------|-----|
| **Frontend App** | [https://quantity-measurement-app.vercel.app](https://quantity-measurement-app-frontend-one-jet.vercel.app/) |
| **API Base URL** | [https://quantity-measurement-api.onrender.com/api/v1](https://quantitymeasurementapp-2-i500.onrender.com/api/v1) |
| **Swagger UI** | [https://quantity-measurement-api.onrender.com/swagger-ui.html](https://quantitymeasurementapp-2-i500.onrender.com/swagger-ui/index.html) |
| **Health Check** | [https://quantity-measurement-api.onrender.com/actuator/health](https://quantitymeasurementapp-2-i500.onrender.com/actuator/health) |

> Note: The backend is hosted on a free tier — the first request may take ~30 seconds to cold-start.

---

## Table of Contents

- [Features](#features)
- [Tech Stack](#tech-stack)
- [Architecture](#architecture)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Local Setup](#local-setup)
  - [Docker Setup](#docker-setup)
- [API Reference](#api-reference)
  - [Authentication](#authentication)
  - [Quantity Operations](#quantity-operations)
  - [Measurement History](#measurement-history)
- [Supported Units](#supported-units)
- [Environment Variables](#environment-variables)
- [Running Tests](#running-tests)
- [Project Structure](#project-structure)
- [Contributing](#contributing)
- [License](#license)

---

## Features

- **Unit Conversion** — Convert values across all supported units within a measurement type
- **Comparison** — Compare two quantities with automatic unit normalization
- **Arithmetic** — Add, subtract, and divide quantities across compatible units
- **Measurement History** — Every operation is persisted and queryable by type, operation, or error status
- **JWT Authentication** — Stateless token-based auth with 24-hour access tokens and 7-day refresh tokens
- **Google OAuth2** — Sign in with Google
- **Role-Based Access Control** — `USER` and `ADMIN` roles with protected admin endpoints
- **OpenAPI Docs** — Auto-generated, interactive Swagger UI
- **Actuator Endpoints** — Health, metrics, and info endpoints for monitoring

---

## Tech Stack

| Layer | Technology |
|-------|-----------|
| Language | Java 17 |
| Framework | Spring Boot 3.2.0 |
| Security | Spring Security · JWT · OAuth2 (Google) |
| Database | H2 (in-memory) |
| ORM | Spring Data JPA · Hibernate |
| API Docs | SpringDoc OpenAPI 3.0 |
| Build | Maven |
| Containerization | Docker (multi-stage) |
| Monitoring | Spring Actuator |
| Testing | JUnit 5 · Spring Boot Test · TestRestTemplate |

---

## Architecture

```
┌─────────────────────────────────────────────────┐
│                   Client (React)                │
│              localhost:5173 / Vercel            │
└───────────────────────┬─────────────────────────┘
                        │ HTTPS / JWT
┌───────────────────────▼─────────────────────────┐
│              Spring Boot REST API               │
│                                                 │
│  ┌──────────┐  ┌──────────┐  ┌───────────────┐  │
│  │   Auth   │  │Quantity  │  │   Security    │  │
│  │Controller│  │Controller│  │ JWT · OAuth2  │  │
│  └────┬─────┘  └────┬─────┘  └───────────────┘  │
│       │             │                            │
│  ┌────▼─────────────▼──────┐                     │
│  │       Service Layer     │                     │
│  │  QuantityMeasurement    │                     │
│  │  UserDetails · Auth     │                     │
│  └────────────┬────────────┘                     │
│               │                                  │
│  ┌────────────▼────────────┐                     │
│  │    Repository Layer     │                     │
│  │   JPA · H2 Database     │                     │
│  └─────────────────────────┘                     │
└─────────────────────────────────────────────────┘
```

---

## Getting Started

### Prerequisites

- Java 17+
- Maven 3.8+
- Docker (optional)
- Google OAuth2 credentials (optional — only required for OAuth2 login)

### Local Setup

```bash
# Clone the repository
git clone https://github.com/sandeep/quantity-measurement-app.git
cd quantity-measurement-app

# Set required environment variables (see Environment Variables section)
export JWT_SECRET=your-256-bit-secret
export GOOGLE_CLIENT_ID=your-google-client-id
export GOOGLE_CLIENT_SECRET=your-google-client-secret

# Build and run
mvn spring-boot:run
```

The API will be available at `http://localhost:8080`.

Swagger UI: `http://localhost:8080/swagger-ui.html`

### Docker Setup

```bash
# Build the image
docker build -t quantity-measurement-app .

# Run the container
docker run -p 8080:8080 \
  -e JWT_SECRET=your-256-bit-secret \
  -e GOOGLE_CLIENT_ID=your-google-client-id \
  -e GOOGLE_CLIENT_SECRET=your-google-client-secret \
  quantity-measurement-app
```

---

## API Reference

All endpoints are prefixed with `/api/v1`. Protected endpoints require a Bearer token in the `Authorization` header.

### Authentication

#### Register

```http
POST /auth/register
Content-Type: application/json

{
  "username": "john",
  "email": "john@example.com",
  "password": "securepassword"
}
```

#### Login

```http
POST /auth/login
Content-Type: application/json

{
  "username": "john",
  "password": "securepassword"
}
```

**Response:**
```json
{
  "accessToken": "eyJhbGciOiJIUzI1NiJ9...",
  "refreshToken": "eyJhbGciOiJIUzI1NiJ9...",
  "tokenType": "Bearer"
}
```

#### Register Admin _(ADMIN role required)_

```http
POST /auth/register/admin
Authorization: Bearer <token>
```

---

### Quantity Operations

All operations require authentication (`Authorization: Bearer <token>`).

#### Convert

```http
POST /api/v1/quantities/convert
Content-Type: application/json

{
  "value": 12.0,
  "fromUnit": "FEET",
  "toUnit": "INCHES"
}
```

#### Compare

```http
POST /api/v1/quantities/compare
Content-Type: application/json

{
  "firstValue": 1.0,
  "firstUnit": "FEET",
  "secondValue": 12.0,
  "secondUnit": "INCHES"
}
```

#### Add

```http
POST /api/v1/quantities/add
Content-Type: application/json

{
  "firstValue": 2.0,
  "firstUnit": "FEET",
  "secondValue": 2.0,
  "secondUnit": "INCHES"
}
```

#### Subtract / Divide

Same request body shape as **Add**, using `/subtract` and `/divide` respectively.

---

### Measurement History

```http
GET /api/v1/quantities/history
GET /api/v1/quantities/history/operation/{operation}
GET /api/v1/quantities/history/type/{type}
GET /api/v1/quantities/history/errored
GET /api/v1/quantities/count/{operation}
```

---

## Supported Units

| Type | Units |
|------|-------|
| **Length** | `FEET`, `INCHES`, `YARDS`, `CENTIMETERS` |
| **Weight** | `GRAMS`, `KILOGRAMS`, `TONNES` |
| **Volume** | `LITERS`, `MILLILITERS`, `GALLONS` |
| **Temperature** | `CELSIUS`, `FAHRENHEIT`, `KELVIN` |

---

## Environment Variables

| Variable | Description | Required |
|----------|-------------|----------|
| `JWT_SECRET` | 256-bit secret for signing JWTs | Yes |
| `JWT_EXPIRATION` | Access token TTL in ms (default: 86400000) | No |
| `JWT_REFRESH_EXPIRATION` | Refresh token TTL in ms (default: 604800000) | No |
| `GOOGLE_CLIENT_ID` | Google OAuth2 client ID | No |
| `GOOGLE_CLIENT_SECRET` | Google OAuth2 client secret | No |

---

## Running Tests

```bash
# Run all tests
mvn test

# Run tests with Surefire HTML report (output: target/site/surefire-report.html)
mvn surefire-report:report

# Run a specific test class
mvn test -Dtest=LengthTest
```

The test suite includes:

| Class | Type | Coverage |
|-------|------|----------|
| `LengthTest` | Unit | Length unit conversions and arithmetic |
| `WeightTest` | Unit | Weight unit conversions and arithmetic |
| `VolumeTest` | Unit | Volume unit conversions and arithmetic |
| `TemperatureTest` | Unit | Temperature conversions |
| `QuantityMeasurementAppTest` | Integration | Full REST endpoint flows |
| `QuantityMeasurementControllerTest` | Controller | Controller-level request/response |

---

## Project Structure

```
src/
└── main/
    └── java/com/sandeep/quantitymeasurement/
        ├── QuantityMeasurementApp.java      # Application entry point
        ├── config/                          # Security, CORS, Swagger config
        ├── controller/                      # REST controllers
        │   ├── AuthController.java
        │   └── QuantityMeasurementController.java
        ├── domain/                          # Core domain: Quantity<U>, unit enums
        ├── exception/                       # GlobalExceptionHandler
        ├── model/                           # DTOs and JPA entities
        ├── repository/                      # Spring Data JPA repositories
        ├── security/                        # JWT filter, service, OAuth2 handler
        └── service/                         # Business logic
```

---


