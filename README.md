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


## To convert the PEM files to the PKCS12 version:

Go to /etc/letsencrypt/live/absurvey.giize.com.
We convert the keys to PKCS12 using OpenSSL in the terminal as follows.
openssl pkcs12 -export -in fullchain.pem -inkey privkey.pem -out keystore.p12 -name tomcat -CAfile chain.pem -caname root

The file 'keystore.p12' with PKCS12 is now generated in '/etc/letsencrypt/live/absurvey.giize.com'.

server.port: 443
security.require-ssl=true
server.ssl.key-store:/etc/letsencrypt/live/absurvey.giize.com/keystore.p12
server.ssl.key-store-password: changeit
server.ssl.keyStoreType: PKCS12
server.ssl.keyAlias: tomcat