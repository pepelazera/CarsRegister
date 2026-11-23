# Here in the FROM, I put the image i will use (java image)
# The base of my image
FROM eclipse-temurin:17
# Here, I put the responsible to mantain the image
LABEL maintainer="pepelazera@gmail.com"
# Work Directory
WORKDIR /application
# The "docker-test.jar" is just a copy of all this path
COPY target/CarsStore-0.0.1-SNAPSHOT.jar /application/docker-test.jar
# In the ENTRYPOINT, I say: "I will execute docker-test.jar"
ENTRYPOINT ["java", "-jar", "docker-test.jar"]