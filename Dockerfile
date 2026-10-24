FROM maven:3.9.6-eclipse-temurin-17

WORKDIR /app

COPY pom.xml .

COPY . /app

RUN mvn package


CMD ["java", "-Dfile.encoding=UTF-8", "-jar", "target/OTP1_inclass1_assignment_Dornaraj-1.0-SNAPSHOT.jar"]