FROM openjdk:8
EXPOSE 8080
ADD target/team-2-project.jar team-2-project.jar
ENTRYPOINT ["java","-jar","/team-2-project.jar","--spring.profiles.active=prod","--DB=team2project.cryncpn8iv7d.ap-southeast-1.rds.amazonaws.com"]