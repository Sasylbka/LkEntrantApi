FROM openjdk:11-jdk

WORKDIR /deployments
COPY build/libs/lk-entrant-*.jar lk-entrant.jar
ENV JAVA_OPTS=""
EXPOSE 8080
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar lk-entrant.jar $JAVA_ARGS"]

