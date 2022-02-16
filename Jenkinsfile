pipeline {
    agent any
    tools{
        jdk "JAVA_LOCAL"
    }
    stages {
   		stage ('Tests execution'){
   			steps {
   				bat 'mvn clean package'    
   			}     		
   		}
   		 stage ('Cucumber Reports') {

            steps {
               	    cucumber buildStatus: "UNSTABLE",
                    fileIncludePattern: "**/cucumber.json",
                    jsonReportDirectory: 'target'
			   }
         }
   	}
}