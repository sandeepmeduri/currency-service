FROM openjdk:8-jdk-alpine
RUN ["mkdir", "-p", "/opt/currencyapp"]
WORKDIR /opt/currencyapp
COPY ["target/currency-service*.jar", "currency-service.jar"]
ENTRYPOINT ["java", "-jar", "currency-service.jar"]