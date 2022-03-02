pipeline {
    agent any
    tools{
        jdk "JAVA_HOME"
    }
    stages {
    	stage ('Java Version'){
   			steps {
   				bat "java -version"    
   			}     		
   		}    	
    	stage ('Mvn Version'){
   			steps {
   				bat "mvn -version"    
   			}     		
   		}
   		stage ('Tests execution'){
   			steps {
   				bat 'mvn -Dmaven.test.failure.ignore=true install'    
   			}     		
   		}

   	}
   	   	post {
            always {
                cucumber buildStatus: "UNSTABLE",
                fileIncludePattern: "**/cucumber.json",
                jsonReportDirectory: 'target'
           		bat "jar -cfM evidencias.zip Evidencias"
				archiveArtifacts artifacts: 'evidencias.zip', fingerprint: true     
				
			   }
			   cleanup{
                cleanWs()
    		}
     }
}


