Steps to reproduce the [issue](https://github.com/spring-cloud/spring-cloud-netflix/issues/923):
----------------------------
1. Run demo service:

  ```
  cd demo
  mvn spring-boot:run
  ```

2. Run zuul: mvn spring-boot:run

  ```
  cd demo
  mvn spring-boot:run
  ```
  
3. Test the demo service endpoint directly

  ```
  curl --verbose -H "Origin: www.example.com" -H "Access-Control-Request-Method: PUT" -X OPTIONS localhost:8080/demo-service/some-resource
  ```

  Produces output:

  ```
  < HTTP/1.1 200 OK
  < Server: Apache-Coyote/1.1
  < Access-Control-Allow-Origin: www.example.com
  < Vary: Origin
  < Access-Control-Allow-Methods: PUT
  < Access-Control-Allow-Credentials: true
  < Access-Control-Max-Age: 1800
  < Allow: GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH
  < Content-Length: 0
  ```

4. Test via zuul
  ```
  curl --verbose -H "Origin: www.example.com" -H "Access-Control-Request-Method: PUT" -X OPTIONS localhost:8765/demo-service/some-resource
  ```
  Produces output:
  ```
  < HTTP/1.1 403 Forbidden
  < Server: Apache-Coyote/1.1
  < X-Application-Context: application:8765
  < Allow: GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH
  < Content-Length: 20
  ```
