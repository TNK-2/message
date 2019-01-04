FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ./com.app-1.5.8.RELEASE.jar app.jar
ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=production","-Dcloud.aws.stack.auto=false","-Dcloud.aws.credentials.useDefaultAwsCredentialsChain=true","/app.jar"]