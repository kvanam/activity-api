# Activity API

A Spring Boot REST API that provides random activities to help combat boredom. This application fetches activity suggestions from the [Bored API](https://www.boredapi.com/).

## Overview

Activity API is a lightweight microservice built with Spring Boot that exposes a single endpoint to retrieve random activities with detailed information including activity type, participant count, price, and accessibility details. Perfect for finding things to do when you're looking for inspiration.

## Features

- **Random Activity Endpoint**: Fetch random activities with comprehensive details
- **Spring Boot 4.1.0**: Modern, reliable Spring Boot framework
- **Java 21**: Built with the latest Java language features
- **Project Lombok**: Reduces boilerplate code with powerful annotations
- **Spring Boot Actuator**: Built-in health checks and application metrics
- **Comprehensive Logging**: SLF4J logging integration for debugging
- **Maven Wrapper**: Includes Maven wrapper for easy builds without local Maven installation

## Technology Stack

- **Runtime**: Java 21
- **Framework**: Spring Boot 4.1.0
- **Web**: Spring Boot Starter Web MVC
- **Monitoring**: Spring Boot Actuator
- **Code Generation**: Project Lombok
- **Build Tool**: Maven 3.6.0+
- **Testing**: JUnit 5 (Jupiter)

## Project Structure

```
activity-api/
├── src/
│   ├── main/
│   │   ├── java/com/kish/activity_api/
│   │   │   ├── ActivityApiApplication.java         # Spring Boot entry point
│   │   │   ├── controller/
│   │   │   │   └── ActivityController.java         # REST endpoint controller
│   │   │   └── model/
│   │   │       └── Activity.java                   # Activity data model
│   │   └── resources/
│   │       └── application.yaml                    # Spring configuration
│   └── test/
│       └── java/com/kish/activity_api/
│           └── ActivityApiApplicationTests.java    # Application context test
├── .mvn/                                           # Maven wrapper configuration
├── mvnw & mvnw.cmd                                 # Maven wrapper scripts
├── pom.xml                                         # Maven project configuration
└── README.md                                       # This file
```

## Getting Started

### Prerequisites

- **Java 21** or higher
- **Maven 3.6.0** or higher (or use the included Maven wrapper)

### Installation & Running

1. **Clone the repository:**
   ```bash
   git clone <repository-url>
   cd activity-api
   ```

2. **Build the project:**
   ```bash
   mvn clean install
   ```
   
   Or using Maven wrapper:
   ```bash
   ./mvnw clean install          # Unix/Linux/macOS
   mvnw.cmd clean install        # Windows
   ```

3. **Run the application:**
   ```bash
   mvn spring-boot:run
   ```
   
   Or using Maven wrapper:
   ```bash
   ./mvnw spring-boot:run        # Unix/Linux/macOS
   mvnw.cmd spring-boot:run      # Windows
   ```

4. **Access the API:**
   The application starts on `http://localhost:8080`

## API Documentation

### Get Random Activity

Fetches a random activity from the Bored API.

**Endpoint:**
```
GET /api/v1/activity
```

**cURL Example:**
```bash
curl http://localhost:8080/api/v1/activity
```

**Response Example:**
```json
{
  "activity": "Learn Express.js",
  "type": "education",
  "participants": 1,
  "price": 0.1,
  "accessibility": "Few to no challenges",
  "duration": "hours",
  "kidFriendly": true,
  "link": "https://expressjs.com/",
  "key": "3943506",
  "availability": 0.25
}
```

**Response Fields:**
| Field | Type | Description |
|-------|------|-------------|
| `activity` | String | Description of the activity |
| `type` | String | Category (e.g., education, recreational, social, cooking) |
| `participants` | Integer | Suggested number of participants |
| `price` | Double | Estimated cost on a scale of 0.0 - 1.0 |
| `accessibility` | String | Difficulty or accessibility description |
| `duration` | String | Expected duration (e.g., hours, minutes, days) |
| `kidFriendly` | String | Whether suitable for children |
| `link` | String | External reference URL for the activity |
| `key` | String | Unique identifier for this activity |
| `availability` | Double | Availability score on a scale of 0.0 - 1.0 |

### Actuator Endpoints

The application includes Spring Boot Actuator endpoints for monitoring:

- Health check: `GET /actuator/health`
- Application info: `GET /actuator/info`
- Metrics: `GET /actuator/metrics`

## Configuration

Application configuration is managed through `src/main/resources/application.yaml`:

```yaml
spring:
  application:
    name: activity-api
```

### Custom Configuration

To customize the application, update `application.yaml` or add an `application-{profile}.yaml` file:

```yaml
server:
  port: 8080

logging:
  level:
    root: INFO
    com.kish.activity_api: DEBUG
```

### Environment-Specific Profiles

Run with specific profiles:
```bash
mvn spring-boot:run -Dspring-boot.run.arguments="--spring.profiles.active=dev"
```

## Building & Testing

### Build Without Running
```bash
mvn clean install
```

### Run Tests
```bash
mvn test
```

### Run Specific Test Class
```bash
mvn test -Dtest=ActivityApiApplicationTests
```

### Clean Build Artifacts
```bash
mvn clean
```

### Package as JAR
```bash
mvn clean package
```

The compiled JAR will be available in `target/activity-api-0.0.1-SNAPSHOT.jar`

## Troubleshooting

### Port Already in Use
If port 8080 is already in use:
```yaml
server:
  port: 8081
```

Or via command line:
```bash
./mvnw spring-boot:run -Dspring-boot.run.arguments="--server.port=8081"
```

### Build Failures
Check your Java version:
```bash
java -version
```

Ensure you have Java 21 or higher installed.

### Cannot Connect to Bored API
- Verify your internet connection
- Check that `https://www.boredapi.com/api/activity` is accessible
- The Bored API may have rate limits or temporary outages

### Maven Build Issues
Clear the local Maven cache:
```bash
rm -rf ~/.m2/repository
mvn clean install
```

## Implementation Notes

- The application uses `RestTemplate` from Spring to make HTTP calls to the external Bored API
- All responses are logged at INFO level for debugging and monitoring
- Package naming uses underscores (`activity_api`) instead of hyphens due to Java package naming conventions
- The Activity model uses Lombok annotations (`@Data`, `@NoArgsConstructor`, `@AllArgsConstructor`) to reduce boilerplate code

## Future Enhancements

- [ ] Add request/response caching to reduce external API calls
- [ ] Add filtering options (activity type, participant count, price range)
- [ ] Add database persistence for activity history and user preferences
- [ ] Implement comprehensive error handling and retry logic
- [ ] Add extensive unit and integration tests
- [ ] Add API documentation with Swagger/OpenAPI (Springdoc)
- [ ] Add rate limiting and throttling
- [ ] Containerize with Docker
- [ ] Add WebClient for non-blocking HTTP calls
- [ ] Add request validation and error response standardization

## References

- [Bored API Documentation](https://www.boredapi.com/)
- [Actuator Ref](https://github.com/resilience4j/resilience4j/issues/2350)
- [Resilience4j Documentation](https://resilience4j.readme.io/docs)
- [Youtube ref] (https://www.youtube.com/watch?v=3-ChrD3Zosg)

## License

This project is licensed under the MIT License. See the LICENSE file for details.

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request or open an issue.

## Support

For issues, questions, or suggestions, please open an issue in the repository.
