From openjdk:8
COPY /var/lib/jenkins/workspace/alchemy-appoint/target/appointmentservice-0.0.1-SNAPSHOT.jar /appointmentservice-0.0.1-SNAPSHOT.jar/
CMD ["java" "-jar" "Appointmentservice-0.0.1-SNAPSHOT.jar"]
EXPOSE 8091
