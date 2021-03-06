# Code example for Toogle Feature presentation
## How to use Togglz library

# Feature Toggle implementation
This example is using [https://www.togglz.org/](https://www.togglz.org/) with Spring-Boot integration [https://www.togglz.org/documentation/spring-boot-starter.html](https://www.togglz.org/documentation/spring-boot-starter.html).

Project is a simple StockReader application having one HTTP endpoint:

```
GET /stockprice?ticker={id}
```
Please start with:
```
git clone https://github.com/KodowanieBezCenzury/architecture.git
cd feature-toggle/stock-price
./gradlew bootRun
```

And use this links:
* example: [http://localhost:8080/stockprice?ticker=AMZN](http://localhost:8080/stockprice?ticker=AMZN)
* toggle status: [http://localhost:8080/actuator/togglz](http://localhost:8080/actuator/togglz)
* toggle management: [http://localhost:8080/togglz-console/index](http://localhost:8080/togglz-console/index)

### Trivia:
Creating this example I discovered that lombok is now supporting spring [@Qualifier](https://docs.spring.io/spring-framework/docs/current/javadoc-api/) annotation when using [@RequiredArgsConstructor](https://projectlombok.org/api/lombok/RequiredArgsConstructor.html) [please read this post](https://ath3nd.wordpress.com/2018/12/13/spring-lombok-or-injection-just-became-a-bit-easier-part-2-of-2/)!
