FROM ubuntu/jre:8_edge

USER root

EXPOSE 8080
ADD target/challenge_2.jar challenge_2.jar
ENTRYPOINT ["java", "-jar", "challenge_2.jar"]
