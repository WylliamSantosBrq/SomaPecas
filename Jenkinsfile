pipeline {
    agent {
    docker{
        image 'maven:3-alpine' 
   
    }
}
    stages {
   		stage ('Build'){
   			steps {
   				 sh 'mvn -B -DskipTests clean package'
   			}     		
   		}
   		stage('Test Execution') { 
            steps {
                sh 'mvn test' 
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
		


