pipeline {
    agent any
    tools {
        jdk 'JAVA_HOME'
    }
	stages {
   		stage ('Build'){
   			steps {
   				bat 'mvn clean package -DskipTests=true'    
   			}     		
   		}
   	
   		stage ('Tests Execution'){
   			steps {
   				bat 'mvn test'    
   			}     		
   		}
   	}
}
