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

This repository includes a `docker-compose.yaml` file for running both the frontend and backend services. However, please note that this file assumes a specific directory structure:

```
parent-directory/
├── course-api-frontend/
└── course-api-backend/
```

To use Docker Compose:

1. Ensure you have both the frontend and backend repositories cloned as sibling directories.
2. Navigate to the parent directory containing both repos.
3. Run:
   ```
   docker-compose -f course-api-backend/docker-compose.yaml up
   ```

This will pull the Docker images from DockerHub and run both services.

If you only want to run the backend service:

1. Build the Docker image:
   ```
   docker build -t course-api-backend .
   ```

2. Run the container:
   ```
   docker run -p 8081:8081 course-api-backend
   ```

Alternatively, you can pull the pre-built image from DockerHub:

```
docker pull moinsahmedrizvi/course-api-backend:latest
docker run -p 8081:8081 moinsahmedrizvi/course-api-backend:latest
```

## API Endpoints

### Courses

1. Create a new course
   - POST /api/courses
   - Request body: Course object

2. List all courses
   - GET /api/courses

3. View detailed information about a course
   - GET /api/courses/{id}
   - Example: GET /api/courses/23

4. Update a course
   - PUT /api/courses/{id}
   - Request body: Updated Course object

5. Delete a course
   - DELETE /api/courses/{id}
   - Example: DELETE /api/courses/24

### Course Instances

1. Create a new instance of a course delivery
   - POST /api/instances
   - Request body: CourseInstance object

2. Create a new instance for a specific course
   - POST /api/courses/{courseId}/instances
   - Request body: CourseInstance object

3. List course instances for a specific year and semester
   - GET /api/instances/{year}/{semester}
   - Example: GET /api/instances/2020/1

4. View detailed information about a course instance
   - GET /api/instances/{year}/{semester}/{courseId}
   - Example: GET /api/instances/2023/1/19

5. Delete a course instance
   - DELETE /api/instances/{year}/{semester}/{courseId}
   - Example: DELETE /api/instances/2022/2/8

## Data Models

### Course
- id: Long
- title: String
- courseCode: String
- description: String

### CourseInstance
- id: Long
- year: int
- semester: int
- course: Course

## Contributing

Please read [CONTRIBUTING.md](CONTRIBUTING.md) for details on our code of conduct and the process for submitting pull requests.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.