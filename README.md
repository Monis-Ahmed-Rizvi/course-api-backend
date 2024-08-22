# Course API Backend

This is the backend for the Course API project, developed using Spring Boot.

## Project Overview

This API provides functionality to manage courses and course instances in an educational system. It allows for creating, reading, updating, and deleting courses, as well as managing course instances for specific years and semesters.

## Features

- RESTful API for managing courses and course instances
- CRUD operations for courses
- Management of course delivery instances
- Validation of input data
- Error handling and appropriate HTTP status codes

## Tech Stack

- Java 17
- Spring Boot 3.3.2
- Spring Data JPA
- H2 Database (for development)
- Maven for dependency management and building the project

## Setup

1. Clone the repository:
   ```
   git clone https://github.com/your-username/course-api-backend.git
   ```
2. Navigate to the project directory:
   ```
   cd course-api-backend
   ```
3. Build the project:
   ```
   mvn clean install
   ```
4. Run the application:
   ```
   mvn spring-boot:run
   ```

The application will start running at `http://localhost:8081`.

## API Endpoints

### Courses

- `POST /api/courses` - Create a new course
- `GET /api/courses` - List all courses
- `GET /api/courses/{id}` - Get details of a specific course
- `PUT /api/courses/{id}` - Update a course
- `DELETE /api/courses/{id}` - Delete a course

### Course Instances

- `POST /api/courses/{courseId}/instances` - Add a new instance to a course
- `POST /api/instances` - Create a new course instance
- `GET /api/instances/{year}/{semester}` - List courses delivered in a specific year and semester
- `GET /api/instances/{year}/{semester}/{courseId}` - Get details of a specific course instance
- `DELETE /api/instances/{year}/{semester}/{courseId}` - Delete a specific course instance

## Data Models

### Course
- `id`: Long
- `title`: String
- `courseCode`: String
- `description`: String

### CourseInstance
- `id`: Long
- `course`: Course
- `year`: Integer
- `semester`: Integer

## Testing

You can use tools like Postman to test the API endpoints. Make sure to set the appropriate HTTP method and include the required data in the request body for POST and PUT requests.

## Contributing

Please read CONTRIBUTING.md for details on our code of conduct and the process for submitting pull requests.

## License

This project is licensed under the MIT License - see the LICENSE.md file for details.