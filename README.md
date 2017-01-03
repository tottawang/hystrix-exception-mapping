# hystrix-exception-mapping

This same application is to use exception mapping to map `HystrixRuntimeException` to HTTP 503 error response.

### Run and build
Step-1: 
./gradlew clean build

Step-2:
* java -jar build/libs/sample-0.0.1-SNAPSHOT.jar

### Test
Run curl http://localhost:{server_ip}/api/hystrix