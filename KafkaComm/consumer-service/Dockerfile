	# Use OpenJDK 23 as base image
FROM eclipse-temurin:23-jdk

# Set working directory inside the container
WORKDIR /app

# Copy the JAR file from the target directory
COPY target/consumer-service.jar consumer-service.jar

# Expose the application port
EXPOSE 8081

# Run the JAR file
ENTRYPOINT ["java", "-jar", "consumer-service.jar"]
