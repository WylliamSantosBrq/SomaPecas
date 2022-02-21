pipeline {
    agent {
    docker{
  		image 'maven: 3.8.4'	
   		args '-u root'
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
		


