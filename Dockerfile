FROM openjdk:11

ADD target/*.jar app.jar

ENV JAVA_OPTS="-Xmx512m -Xms512m"

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar app.jar" ]