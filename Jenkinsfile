pipeline {
    agent {
    docker{
  		image 'maven:3-alpine'	
   		args '-u root'
   		image 'gradle:6.7-jdk8'
    }
}
    stages {
   		stage ('Build'){
   			steps {
   				 sh 'mvn --version'
   			}     		
   		}
   	}
}
		


