FROM maven:3.8-amazoncorretto-17

WORKDIR /account

COPY pom.xml .
RUN mvn verify clean --fail-never

COPY . .
CMD mvn spring-boot:run