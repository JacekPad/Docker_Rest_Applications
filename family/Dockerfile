FROM maven:3.6.3-openjdk-17 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:17
ARG JAR_FILE
COPY --from=build /home/app/target/Family.jar Family.jar
ENTRYPOINT ["java", "-jar", "Family.jar"]