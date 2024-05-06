# 기본 이미지로 OpenJDK를 사용
FROM openjdk:17-jdk-slim

# 애플리케이션 jar 파일을 이미지 내부로 복사
ARG JAR_FILE=/build/libs/invest-crafter-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

# wait-for-it.sh
RUN apt-get update && apt-get install -y bash
COPY wait-for-it.sh wait-for-it.sh
RUN chmod +x wait-for-it.sh