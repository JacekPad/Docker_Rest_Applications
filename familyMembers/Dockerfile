FROM maven:3.6.3-openjdk-17 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:17
ARG JAR_FILE
COPY --from=build /home/app/target/FamilyMemberApp.jar FamilyMemberApp.jar
ENTRYPOINT ["java", "-jar", "FamilyMemberApp.jar"]