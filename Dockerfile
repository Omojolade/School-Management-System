FROM openjdk:11

VOLUME /tmp

EXPOSE 8081
ADD school-management-system.jar school-management-system.jar

ENTRYPOINT ["java", "-jar", "school-management-system.jar"]