FROM tomcat:9.0.73-jdk11
RUN mv /var/lib/jenkins/workspace/be/crud/target/*.war ROOT.war
COPY /var/lib/jenkins/workspace/be/crud/target/ROOT.war /usr/local/tomcat/webapps/
EXPOSE 8080
CMD ["catalina.sh", "run"]
