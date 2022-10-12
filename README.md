# springboot-microservices-v2
- Eureka Naming Server
- Eureka Discovery Client
- Cloud Gateway
- Resilience4J
- Zipkin
- Sleuth
- Config Server
- Containerization
### To run Zipkin locally:
`docker run -d -p 9411:9411 openzipkin/zipkin`
### Build docker images
`mvn clean install spring-boot:build-image -DskipTests`
