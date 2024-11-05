# Use the OpenJDK image from Docker Hub (version 11 as specified)
FROM openjdk:11-jdk-slim

# Expose the port on which your Spring Boot application will run
EXPOSE 8082

# Copy the JAR file from the target directory to the Docker image
# Update 'tp-foyer-1.0.jar' with the actual name of your built JAR file
ADD target/tp-foyer-1.0.jar tp-foyer.jar

# Define the entry point for running the application
ENTRYPOINT ["java", "-jar", "/tp-foyer.jar"]
