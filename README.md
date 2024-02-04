# Flight Search API

## Description

The Flight Search API is a backend service designed to provide comprehensive flight search functionalities. It allows
users to query flights based on various criteria and manage bookings. This project is built using Spring Boot and
follows RESTful principles.

## Features

- Search for flights based on departure and arrival locations, dates, and times.
- View detailed information about flights including price and duration.
- User authentication and authorization for secure access.
- Ability to create, read, update, and delete (CRUD) flight and airport data.
- Scheduled tasks for fetching and updating flight data from third-party services.

## Installation

### Tech Used

- Spring Boot.
- Maven.
- MongoDB.

### Setup

1. **Clone the repository**
    ```bash
    git clone https://github.com/burakkececi/flight-search-api
    cd flight-search-api
    ```

2. **Configure the database**
    - Create a new database in your MongoDB server.
    - Update `src/main/resources/application.properties` with your database credentials and URL.

3. **Build the application**
    - For Maven:
        ```bash
        mvn clean install
        ```

4. **Run the application**
    - For Maven:
        ```bash
        mvn spring-boot:run
        ```

## Usage

After starting the application, you can access the API endpoints through `http://localhost:8080/`. 
Here is the Swagger documentation.

![alt text](https://github.com/burakkececi/flight-search-api/blob/3ef0891edaf2112717779b59da0ca83fe458cad5/swagger-img.png?raw=true)

For detailed API documentation, visit `http://localhost:8081/swagger-ui.html` after starting the application.
