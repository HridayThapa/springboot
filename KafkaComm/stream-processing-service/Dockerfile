# Use official OpenJDK image
FROM openjdk:23-jdk

# Set working directory inside the container
WORKDIR /app

# Copy the built JAR file into the container
COPY target/stream-processing-service.jar app.jar

# Expose the application port
EXPOSE 8083

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
