# Code example for framework adoption
## Here we got example how to use [Spring Boot](https://docs.spring.io/spring-boot/docs/current/reference/html/) 

Idea is to make application accesible via HTTP and try to not polute bisiness logic with technical details.

# Application 

Project is a simple StocReader application using dummy stock reader having one HTTP endpoint:

```
GET /stockprice?ticker={id}
```
Please start application with:
```
git clone https://github.com/KodowanieBezCenzury/architecture.git
cd framework-adoption/spring
./gradlew bootRun
```

Here are some useful links:
* example: [http://localhost:8080/stockprice?ticker=AMZN](http://localhost:8080/stockprice?ticker=AMZN)
* actuator status: [http://localhost:8080/actuator](http://localhost:8080/actuator)

### Trivia:
