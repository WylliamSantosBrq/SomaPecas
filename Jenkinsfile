pipeline {
    agent any
    tools {
        jdk 'JAVA_HOME'
    }
	stages {
   		stage ('Build'){
   			steps {
   				sh 'mvn clean package -DskipTests=true'    
   			}     		
   		}
   	
   		stage ('Tests Execution'){
   			steps {
   				sh 'mvn test'    
   			}     		
   		}
   	}
}
