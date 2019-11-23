FROM tomcat:8.0

MAINTAINER trabalho-sidnei

#RUN cp /var/lib/jenkins/workspace/trabalho-sidnei_master/dist/GerenciaBanco.war /home/lucasjansen/docker/

COPY /trabalho-sidnei_master/dist/GerenciaBanco.war /usr/local/tomcat/webapps/
