# Spring Boot Chat Application

## Tutorial for Amazon EC2 Ubuntu

**Allow inbound traffic on port 80**

**This tutorial is tested with JDK 17.0.2**

1. **Provision Ubuntu EC2 and Install Java 17.0.2**
   - Update the package index:
     ```bash
     sudo apt update
     ```
   - Install OpenJDK 17:
     ```bash
     sudo apt install openjdk-17-jdk -y
     ```
   - Verify the Java installation:
     ```bash
     java -version
     ```

2. **Build the Application**
   - Package the Spring Boot application using Maven:
     ```bash
     mvn package
     ```

3. **Run the Application in a tmux Session**
   - Start a tmux session (if not already in one):
     ```bash
     tmux
     ```
   - Run the Spring Boot JAR file:
     ```bash
     sudo java -jar chat-1.jar
     ```
