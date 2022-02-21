pipeline {
    agent any
    tools{
        jdk "JAVA_HOME"
    }
    stages {
   		stage ('Tests execution'){
   			steps {
   				sh 'mvn clean package'    
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


