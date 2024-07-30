FROM openjdk:17
ADD targe/StudentDocker.jar StudentDocker.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","StudentDocker.jar"]