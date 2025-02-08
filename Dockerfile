# Use Amazon Corretto 17 as the base image
FROM amazoncorretto:17

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR from the host machine to the container
COPY build/libs/*-SNAPSHOT.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the application with the correct classpath
ENTRYPOINT ["java", "-jar", "app.jar"]
