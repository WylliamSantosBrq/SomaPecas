pipeline {
    agent {
    docker{
   		image 'gradle:6.7-jdk8'
    }
}
    stages {
   		stage ('Build'){
   			steps {
   				 sh 'gradle --version'
   			}     		
   		}
   	}
}
		


