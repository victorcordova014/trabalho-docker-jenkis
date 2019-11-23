pipeline {
 agent any 
 stages {
	stage('Remove') {
		steps {
			sh 'sudo docker container rm -f $(docker container ls -aq)'
		}
	}
	stage('Build Imagem Docker') {
		steps {
			sh 'sudo docker image build -t trabalho-sidnei/tomcat ./'
		}
	}
	stage('Executar') {
		steps {
			sh 'sudo docker container run -d --name trabalho-sidnei --publish 8081:8080 trabalho-sidnei/tomcat'
		}
	}
 }
}
