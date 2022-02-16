pipeline {
    agent any
    tools {
        jdk 'JAVA_LOCAL'
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
    post {
          always {
               cucumber buildStatus: "UNSTABLE",
               fileIncludePattern: "**/cucumber.json",
               jsonReportDirectory: 'target'
          	}
	  }
}