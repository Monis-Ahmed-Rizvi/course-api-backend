# Course Management System Backend

This is the backend application for the Course Management System, built with Spring Boot.

## Features

- RESTful API for managing courses and course instances
- CRUD operations for courses and course instances
- In-memory H2 database for development
- Docker support for easy deployment

## Prerequisites

- Java 17 or later
- Maven 3.6 or later
- Docker (for containerization)

## Setup and Running

### Local Development

1. Clone the repository:
   ```
   git clone https://github.com/your-username/course-api-backend.git
   cd course-api-backend
   ```

2. Build the project:
   ```
   mvn clean install
   ```

3. Run the application:
   ```
   mvn spring-boot:run
   ```

The API will be available at `http://localhost:8081`.

### Docker Deployment

1. Build the Docker image:
   ```
   docker build -t course-api-backend .
   ```

2. Run the container:
   ```
   docker run -p 8081:8081 course-api-backend
   ```

## API Endpoints

- `POST /api/courses`: Create a new course
- `GET /api/courses`: List all courses
- `GET /api/courses/{id}`: Get a specific course
- `DELETE /api/courses/{id}`: Delete a course
- `POST /api/instances`: Create a new course instance
- `GET /api/instances/{year}/{semester}`: List course instances for a specific year and semester
- `GET /api/instances/{year}/{semester}/{courseId}`: Get a specific course instance
- `DELETE /api/instances/{year}/{semester}/{courseId}`: Delete a course instance

## Docker Compose

To run both the frontend and backend together, use the `docker-compose.yaml` file in the root of this repository:

```
docker-compose up
```

## Contributing

Please read [CONTRIBUTING.md](CONTRIBUTING.md) for details on our code of conduct and the process for submitting pull requests.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.