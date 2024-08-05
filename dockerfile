FROM tomcat:9.0.73-jdk11
WORKDIR /crud
RUN mv target/*.war ROOT.war
COPY target/ROOT.war /usr/local/tomcat/webapps/
EXPOSE 8080
CMD ["catalina.sh", "run"]
