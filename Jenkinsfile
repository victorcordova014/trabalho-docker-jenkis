pipeline {
 stages {
	stage('Build Imagem Docker') {
		steps {
			sh 'docker image build -t trabalho-sidnei/tomcat ./'
		}
	}
	stage('Remove') {
		steps {
			sh 'docker container rm -f $(docker container ls -aq)'
		}
	}
	stage('Executar') {
		steps {
		sh 'docker container run -d --name trabalho-sidnei --publish 8081:8080 trabalho-sidnei/tomcat'
		}
	}
 }
}
