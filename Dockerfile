# Use an official OpenJDK runtime as a parent image
FROM eclipse-temurin:17-jdk

# Set the working directory
WORKDIR /app

# Copy the Maven wrapper and pom.xml
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# Download dependencies
RUN ./mvnw dependency:go-offline

# Copy the rest of the source code
COPY . .

# Package the application
RUN ./mvnw clean package -DskipTests

# Run the application
CMD ["java", "-jar", "target/bakery-0.0.1-SNAPSHOT.jar"]
