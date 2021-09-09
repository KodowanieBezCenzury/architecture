# Code example for framework adoption
## Here we got example how to use [Spring Boot](https://docs.spring.io/spring-boot/docs/current/reference/html/) 

Idea is to make application accesible via HTTP and try to not polute bisiness logic with technical details. What we want to do is to expose this domain functionality: [StockPriceMonitor](https://github.com/KodowanieBezCenzury/architecture/blob/49eb9e9adce12e255cd8c23f0276d165211f0e58/framework-adoption/spring/src/main/java/com/kodowaniebezcenzury/subieslaw/stockprice/model/StockPriceMonitor.java#L12) using Spring Boot as infrastructure.

### Resources
* domain package: [framework-adoption/spring/src/main/java/com/kodowaniebezcenzury/subieslaw/stockprice/model](https://github.com/KodowanieBezCenzury/architecture/tree/main/framework-adoption/spring/src/main/java/com/kodowaniebezcenzury/subieslaw/stockprice/model)
* infrastructure code: [framework-adoption/spring/src/main/java/com/kodowaniebezcenzury/subieslaw/stockprice/infrastructure](https://github.com/KodowanieBezCenzury/architecture/tree/main/framework-adoption/spring/src/main/java/com/kodowaniebezcenzury/subieslaw/stockprice/infrastructure)
* infrastructure tests: [framework-adoption/spring/src/test/java/com/kodowaniebezcenzury/subieslaw/stockprice/infrastructure](https://github.com/KodowanieBezCenzury/architecture/tree/main/framework-adoption/spring/src/test/java/com/kodowaniebezcenzury/subieslaw/stockprice/infrastructure)

### How to implement Spring integraion
* [Getting Started with Spring Boot](https://spring.io/guides/gs/spring-boot/)
* [Testing Spring Web](https://spring.io/guides/gs/testing-web/)

# Application 

Project is a simple [StockPriceMonitor](https://github.com/KodowanieBezCenzury/architecture/blob/49eb9e9adce12e255cd8c23f0276d165211f0e58/framework-adoption/spring/src/main/java/com/kodowaniebezcenzury/subieslaw/stockprice/model/StockPriceMonitor.java#L12) application using dummy stock reader having one HTTP endpoint:

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
Ctrl+C and Ctrl+V technique works every time!