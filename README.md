# QuickNotesAPI

QuickNotesAPI is a Java Spring Boot based application that provides a quick note management system for users. This project includes authentication, note creation, update, deletion, and more.

## Characteristics

- **User Authentication:** Login and registration system using JWT.
- **Note Management:** Full CRUD to create, read, update and delete notes.
- **User Management:** View and manage users.
- **Security:** Custom security configuration with Spring Security and JWT.

## Technologies used

- **Java** (JDK 21)
- **Spring Boot** (Main framework)
- **Spring Security** (Security and authentication management)
- **JWT** (Json Web Tokens for authentication)
- **PostgreSQL** (Relational database)
- **Maven** (Dependency management)
- **Javadoc** (Project documentation)

## Prerequisites

- **Java** JDK 21
- **Maven** 3.8 or higher
- **PostgreSQL** 14 or higher

## Installation

1. Clone this repository:

```bash
    git clone https://github.com/JordanRondon/QuickNotesAPI.git
```

2. Configure the properties in `application.properties` to connect to your PostgreSQL database: Replace the database name, username, and password with your data.

```bash
    spring.datasource.url=jdbc:postgresql://localhost:5432/yourDatabaseName
    spring.datasource.username=yourUsername
    spring.datasource.password=yourPassword
```

- **optional:** Replace the key for the JWT signature. It is recommended that the string length be 64 characters (32 bytes)

  `jwt.secret=yourPersonalizedKey`

3. Install dependencies using Maven:

```bash
    mvn clean install
```

4. Create the database with the `yourDatabaseName` entered in `application.properties` and run the scripts located in the `resources\database` folder

```bash
    src/
    └── main/
        ├── java/com/QuickNotesAPI/QuickNotes/
        └── resources/
            └── database/
                ├── 01_schema.sql
                ├── 02_triggers.sql
                ├── 03_data.sql
```

## Execution

1. Run the project with Maven:

```bash
    mvn spring-boot:run
```

2. Access the API from your browser or REST client at http://localhost:8080

## Documentation

1. Project documentation is generated using Javadoc. To generate it, run the following command in the project directory:

```bash
    mvn javadoc:javadoc
```

2. Your project documentation is available in the generated HTML file at the following path:

```bash
    cd QuickNotes\target\site\apidocs\index.html
```
