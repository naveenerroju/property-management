# Property Management API

This is a Spring Boot application that serves as an API for property management. It allows users to perform various operations related to managing properties and users.

## Features

- **Create, Read, Update, Delete (CRUD) Operations:** Perform CRUD operations for managing properties and users.
- **Join Table Relationship:** Properties are associated with users through a joined table to establish ownership.
- **Unit Tests:** Unit tests are included to ensure the functionality of the API endpoints.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- H2 Database (for testing)
- JUnit (for unit testing)
- Maven (for dependency management)

## Setup

1. **Clone the Repository:**
git clone https://github.com/naveenerroju/property-management.git
2. **Build the Project:**
cd property-management
mvn clean install
3. **Run the Application:**
java -jar target/property-management.jar
4. **Access the API:**
The API will be accessible at `http://localhost:8080/api`

## API Endpoints

### Properties
- **GET /api/properties:** Retrieve all properties.
- **GET /api/properties/{id}:** Retrieve a property by ID.
- **POST /api/properties:** Create a new property.
- **PUT /api/properties/{id}:** Update an existing property.
- **DELETE /api/properties/{id}:** Delete a property by ID.

### Users
- **GET /api/users:** Retrieve all users.
- **GET /api/users/{id}:** Retrieve a user by ID.
- **POST /api/users:** Create a new user.
- **PUT /api/users/{id}:** Update an existing user.
- **DELETE /api/users/{id}:** Delete a user by ID.

## Testing

Unit tests are included to ensure the functionality of the API endpoints. You can run the tests using Maven:
mvn test

## Contribution

Contributions to the project are welcome! Feel free to submit bug reports, feature requests, or pull requests.
