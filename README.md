# Spring Boot

This is a sample Java / Maven / Spring Boot application that can be used as a starter for creating a microservice complete. This project use Oauth2 Authentication and Postman export can be found on file ProvaP.postman_collection.json

This project use H2 memory database.

Endpoints:

  - http://localhost:8088/api/oauth/token
  - http://localhost:8088/api/accounts
  - http://localhost:8088/api/accounts/1
  - http://localhost:8088/api/transactions



### Installation

Install the dependencies and devDependencies .

```sh
$ mvn clean install
```

### Sonar 
To run sonnar you must alter sonar-project.properties and run.
```sh
$ sonar-scanner
```
### Docker 
```sh
docker build --pull --rm -f "Dockerfile" -t interviewp:latest "."
docker run -d --name interview  -p 8088:8088 interviewp
```
