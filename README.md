# hystrix-exception-mapping

This sample application can map `HystrixRuntimeException` to HTTP 503 error response directly by using jersey exception mapping feature. When Hystrix exception is thrown, HystrixRuntimeExceptionMapper maps it to 503 and directly returned by resource. Hence there is no need for resource to catch the hystrix runtime exception explicitly. 


### Run and build
Step-1: 
./gradlew clean build

Step-2:
* java -jar build/libs/sample-0.0.1-SNAPSHOT.jar

### Test
Run curl http://localhost:{server_ip}/api/hystrix