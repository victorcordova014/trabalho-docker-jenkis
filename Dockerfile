FROM tomcat:8.0

MAINTAINER trabalho-sidnei

COPY ./dist/GerenciaBanco.war /usr/local/tomcat/webapps/
