# Course Management System Backend

This is the backend application for the Course Management System, built with Spring Boot.

## Features

- RESTful API for managing courses and course instances
- CRUD operations for courses and course instances
- Pagination, sorting, and searching for courses
- H2 in-memory database for development
- Exception handling and validation

## Prerequisites

- Java 17 or later
- Maven 3.6 or later

## Installation

1. Clone the repository:
   ```
   git clone https://github.com/your-username/course-management-backend.git
   cd course-management-backend
   ```

2. Build the project:
   ```
   mvn clean install
   ```

## Running the Application

To start the application:

```
mvn spring-boot:run
```

The API will be available at `http://localhost:8081`.

## API Endpoints

- `GET /api/courses`: List all courses (with pagination, sorting, and search)
- `POST /api/courses`: Create a new course
- `GET /api/courses/{id}`: Get a specific course
- `PUT /api/courses/{id}`: Update a course
- `DELETE /api/courses/{id}`: Delete a course
- `GET /api/instances/{year}/{semester}`: List course instances for a specific year and semester
- `POST /api/instances`: Create a new course instance
- `DELETE /api/instances/{year}/{semester}/{courseId}`: Delete a course instance

## Project Structure

- `src/main/java/com/example/courseapi/`: Java source files
  - `config/`: Configuration classes
  - `controller/`: REST controllers
  - `dto/`: Data Transfer Objects
  - `exception/`: Custom exceptions and exception handling
  - `model/`: Entity classes
  - `repository/`: JPA repositories
  - `service/`: Service layer classes

## Database

The application uses an H2 in-memory database by default. You can access the H2 console at `http://localhost:8081/h2-console` when the application is running.

## Testing

To run the tests:

```
mvn test
```

## Contributing

Please read [CONTRIBUTING.md](CONTRIBUTING.md) for details on our code of conduct, and the process for submitting pull requests.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.