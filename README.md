# Candidate Assessment Platform

## Overview
A simple assessment platform where:
- Admins can create questions.
- Candidates can take a quiz.
- Scores are stored and accessible via reports.

## Features
✅ Admin can create questions  
✅ Candidates can attempt questions  
✅ Quiz system fetches random questions  
✅ Score is calculated and stored  
✅ User authentication with JWT  

## Tech Stack
- **Backend:** Spring Boot (Java)
- **Database:** MySQL
- **Auth:** JWT Authentication
- **API Testing:** Postman

## Setup & Installation

### Prerequisites
- Java 17+
- MySQL
- Postman (for testing)

### Database Setup
1. Create a MySQL database:
   ```sql
   CREATE DATABASE candidate_assessment;
2. Update application.properties:
spring.datasource.url=jdbc:mysql://localhost:3306/candidate_assessment
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update

### Running the Project
1. Clone the repository:
git clone https://github.com/yourusername/candidate-assessment-platform.git
cd candidate-assessment-platform

### Build & run:
mvn clean install
mvn spring-boot:run

## API Endpoints

### Admin
| Method | Endpoint          | Description            |
|--------|------------------|------------------------|
| POST   | `/api/questions` | Create a new question |
| GET    | `/api/questions` | Get all questions     |

### Candidate
| Method | Endpoint      | Description              |
|--------|--------------|--------------------------|
| GET    | `/api/quiz`  | Get 5 random questions  |
| POST   | `/api/submit`| Submit quiz answers     |

### Reports
| Method | Endpoint            | Description               |
|--------|----------------------|---------------------------|
| POST   | `/api/register`      | Register candidate       |
| GET    | `/api/report/{id}`   | Get candidate's score    |


Use Token: Pass Authorization: Bearer <your_token> in requests
