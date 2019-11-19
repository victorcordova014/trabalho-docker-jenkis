pipeline {
 stages {
	stage('Git Pull') {
		steps {
			sh 'docker container stop trabalho-sidnei'
			sh 'git pull origin master'
		}
	}
	stage('Alterar Container') {
		steps {
		sh 'docker run -d --name trabalho-docker-jenkins -p 8888:80 php:7.2-apache'
		}
	}
	stage('Copia PHP para o container'){
		steps {
		sh 'docker container cp trabalho-docker-jenkins/* my_php:/var/www/html'
		}
	}
 }
}
