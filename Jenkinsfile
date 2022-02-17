pipeline {
    agent any
    tools {
        jdk 'JAVA_HOME'
    }
	stages {
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
