# Project: Active Tech Style

This project is a full-stack e-commerce web application that uses React.js, Java, Spring Boot, MySQL and is deployed on AWS.

------

## Try it out

The website is deployed [here](https://activetechstyle.vercel.app/). 

The server is hosted on AWS Elastic Beanstalk which is connected to an Amazon Relational Database Service (RDS) instance.

## Technologies Used

- React.js
- Java
- Spring Boot
- MySQL
- AWS (Elastic Beanstalk, RDS, ACM, Route 53)

## Steps to Run Locally

**Backend**

- Set up the database by starting a MySQL server.
- Modify the file *server2/assignment6/src/main/resources/application.properties* (see instructions below)

Uncomment this line:
```
# Uncomment this out to test on local database
#spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/activetechstyle?createDatabaseIfNotExist=true
```

Comment out this line:
```
# Comment this out to test on local database, after uncommenting above
spring.datasource.url=jdbc:mysql://${DB_URL}:3306/ebdb?createDatabaseIfNotExist=true
```

Insert Database Username and Password:
```
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASSWORD}
```

**Frontend**

- To start the frontend, cd into client and type:

```
npm install // Installs all dependencies
npm run dev // Run the client
```
