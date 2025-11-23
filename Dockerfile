FROM registry.access.redhat.com/ubi8/openjdk-17:1.20

ENV LANG='en_US.UTF-8' LANGUAGE='en_US:en'

# Crear directorio de logs
USER root
RUN mkdir -p /var/log/quarkus && chmod -R 777 /var/log/quarkus

# Copiar la aplicación
COPY --chown=185 target/quarkus-app/lib/ /deployments/lib/
COPY --chown=185 target/quarkus-app/*.jar /deployments/
COPY --chown=185 target/quarkus-app/app/ /deployments/app/
COPY --chown=185 target/quarkus-app/quarkus/ /deployments/quarkus/

EXPOSE 8080
USER 185

ENV JAVA_OPTS_APPEND="-Dquarkus.http.host=0.0.0.0 -Djava.util.logging.manager=org.jboss.logmanager.LogManager"
ENV JAVA_APP_JAR="/deployments/quarkus-run.jar"

#docker build -t quarkus-app .
#
#docker run -p 8080:8080 -v $(pwd)/logs:/var/log/quarkus --name quarkus-logs quarkus-app
