pipeline {
 agent any 
 stages {
	stage('Build Imagem Docker') {
		steps {
			sh 'run sudo cp /var/lib/jenkins/workspace/trabalho-sidnei_master/dist/GerenciaBanco.war /home/lucasjansen/docker/'
			sh 'docker image build -t trabalho-sidnei/tomcat /home/lucasjansen/docker/'
		}
	}
	/*stage('Remove') {
		steps {
			//sh 'docker container stop trabalho-sidnei'
			//sh 'docker container rm -f $(docker container ls -aq)'
		}
	}*/
	stage('Executar') {
		steps {
			sh 'docker container run -d --name trabalho-sidnei --publish 8081:8080 trabalho-sidnei/tomcat'
		}
	}
	stage('Remover Workspace') {
		steps {
			sh 'sudo rm -f -r /var/lib/jenkins/workspace/trabalho-sidnei_master'
		}
	}
 }
}
