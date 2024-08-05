FROM ubuntu:latest
RUN sudo apt -y update && apt -y upgrade
RUN sudo apt -y install openjdk-8-jdk 
RUN mkdir /usr/local/tomcat
RUN wget http://www-us.apache.org/dist/tomcat/tomcat-8/v8.5.16/bin/apache-tomcat-8.5.16.tar.gz -O /tmp/tomcat.tar.gz
RUN cd /tmp && tar xvfz tomcat.tar.gz
RUN cp -Rv /tmp/apache-tomcat-8.5.16/* /usr/local/tomcat/
EXPOSE 8080
CMD /usr/local/tomcat/bin/catalina.sh run


----------------------------------------------------------

FROM tomcat:latest
CMD ["catalina.sh", "run"]

----------------------------------------------------------
