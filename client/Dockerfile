FROM tomcat:8.5.75-jre11-openjdk

ARG PROJ_ROOT
ARG JAR_FILE

# VOLUME ["/etc/certs"]

# ADD tls-client.jar tls-client.jars
# ADD ../tlsclient/target/tls-client-1.0-SNAPSHOT.jar tls-client.jar
ADD ${JAR_FILE} tls-client.jar

EXPOSE 8080

RUN mkdir -p /etc/certs

ADD ${PROJ_ROOT}/certs/* /etc/certs/

ADD ${PROJ_ROOT}/createKeystores.sh ./

RUN sh createKeystores.sh

#CMD ["catalina.sh", "run"]
ENTRYPOINT ["java","-jar", "-Dspring.profiles.active=linux", "tls-client.jar"]