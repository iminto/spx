FROM openjdk:8-jdk-alpine
ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENV JAVA_OPTS="-Xmx400m -Xms400m -XX:SurvivorRatio=8 -XX:MetaspaceSize=64m -XX:MaxMetaspaceSize=96m \
-XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/ \
-Xloggc:/gc.log -XX:GCLogFileSize=10M"
ENTRYPOINT ["sh", "-c","java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar /app.jar"]