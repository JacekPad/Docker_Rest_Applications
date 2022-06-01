# Docker_Rest_Applications
Rest applications connected to each other and a database in docker containers.

## Description
Two REST applications and MySQL database on three different docker containers in the same network. Two application are connected to each other through REST calls.
Both applications have their own schemas in the same database.

Applications store and process information about families - the first application stores information about a family as a whole (family's name and number of people at certain age range), the second application stores information about each person's individual data (name, age, family's name).
The First application validates acquired data (age validation for each member), and then sends relevant data to the second application for storage.

The first application can also access family's member's information stored in the second application to show alongside the family data.

## Instllation

To run the program type: 
```
docker-compose up --build
```
in the terminal in the project's main folder. <br>
Database access: <br>
Login: ```user``` <br>
Password: ```password``` <br>
The project also includes Postman collection with different API calls for testing the responses. 

## Other

### Notices
- The MySQL server within docker container takes a couples of minutes to start, which makes both applications fail to connect. For this reason both applications have a parameter ```reset on failure```. After a couple of minutes the MySQL server comes online and both applications make the connection and start to work properly.

### Technologies
  - SpringBoot
  - Spring Data
  - Hibernate
  - Docker
  - Docker Compose
  - MySQL
  - Apache Maven
  - Flyway
  
