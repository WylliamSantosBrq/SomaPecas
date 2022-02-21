pipeline {
    agent {
    docker{
  		image 'gradle:6.7-jdk8'
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
		


