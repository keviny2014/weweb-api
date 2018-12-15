FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD weweb-api-0.0.1-SNAPSHOT.jar weweb-api.jar
RUN sh -c 'touch /weweb-api.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /weweb-api.jar" ]