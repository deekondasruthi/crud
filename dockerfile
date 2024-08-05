FROM tomcat:9.0.73-jdk11
COPY /var/lib/jenkins/workspace/be/crud/target/ROOT.war /usr/local/tomcat/webapps/
EXPOSE 8080
CMD ["catalina.sh", "run"]
