FROM openjdk:8
copy target/AppointmentService-0.0.1-SNAPSHOT.jar AppointmentService-0.0.1-SNAPSHOT.jar
EXPOSE 8091
ENTRYPOINT ["JAVA","-JAR","/AppointmentService-0.0.1-SNAPSHOT.jar"]
