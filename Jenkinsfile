pipeline {
 agent any 
 stages {
	stage('Build Imagem Docker! ') {
		steps {
			sh 'cp /var/lib/jenkins/workspace/trabalho-sidnei_master/dist/GerenciaBanco.war /home/lucasjansen/docker/'
			sh 'docker image build -t trabalho-sidnei/tomcat /home/lucasjansen/docker/'
		}
	}
	stage('Remove Container') {
		steps {
			//sh 'docker container stop trabalho-sidnei'
			sh 'docker container rm -f $(docker container ls -aq)'
		}
	}
	stage('Executar') {
		steps {
			sh 'docker container run -d --name trabalho-sidnei --publish 8081:8080 trabalho-sidnei/tomcat'
		}
	}
	stage('Remover War pasta Docker') {
		steps {
			//sh 'sudo rm -f --recursive -r /var/lib/jenkins/workspace/trabalho-sidnei_master'
			sh 'rm -f /home/lucasjansen/docker/GerenciaBanco.war'
		}
	}
 }
}
