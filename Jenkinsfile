pipeline {
  agent any
	options {
	skipStagesAfterUnstable()
 }
 stages {
	stage('Git Clone') {
		steps {
			sh 'rm -rf trabalho-docker-jenkins'
			sh 'git clone https://github.com/lucasrjansen/trabalho-docker-jenkis.git'
		}
	}
	stage('Roda novo Container') {
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
