FROM ubuntu:20.04

RUN apt-get update && \
    apt-get install -y default-jdk wget tar

RUN mkdir /opt/tomcat

RUN wget https://dlcdn.apache.org/tomcat/tomcat-9/v9.0.91/bin/apache-tomcat-9.0.91.tar.gz -O /tmp/apache-tomcat-9.0.91.tar.gz && \
    tar xvzf /tmp/apache-tomcat-9.0.91.tar.gz -C /opt/tomcat --strip-components=1

COPY target/ROOT.war /opt/tomcat/webapps/

EXPOSE 8080

ENV CATALINA_HOME=/opt/tomcat
ENV PATH=$PATH:$CATALINA_HOME/bin

CMD ["catalina.sh", "run"]


