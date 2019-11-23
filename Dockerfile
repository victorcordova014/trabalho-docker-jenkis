FROM tomcat:8.0

MAINTAINER trabalho-sidnei

RUN cp ./dist/GerenciaBanco.war /home/lucasjansen/docker/

COPY ./dist/GerenciaBanco.war /usr/local/tomcat/webapps/
