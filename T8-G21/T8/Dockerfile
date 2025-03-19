FROM maven:3.9.6-eclipse-temurin-21 AS builder

WORKDIR /T8

COPY evosuite /T8/evosuite
COPY target/T8-0.0.1-SNAPSHOT.jar /T8/app.jar

# Install Java 8 per evosuite
RUN apt-get update && \
    apt-get install -y openjdk-8-jdk && \
    update-alternatives --install /usr/bin/java java /usr/lib/jvm/java-8-openjdk-amd64/bin/java 1 && \
    update-alternatives --install /usr/bin/javac javac /usr/lib/jvm/java-8-openjdk-amd64/bin/javac 1

# Setto JAVA_HOME a Java 21
#ENV JAVA_HOME=/opt/java/openjdk
#ENV PATH="${JAVA_HOME}/bin:${PATH}"

EXPOSE 8088
CMD ["java", "-jar", "/T8/app.jar"]
